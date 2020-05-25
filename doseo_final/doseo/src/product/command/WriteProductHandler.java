package product.command;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;
import product.model.Product;
import product.service.WriteProductService;
import product.service.WriteRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;;

//상품등록작성폼을 보여주고 폼전송을 처리
//get=>등록 폼 보여줌
//post=>들어온 정보를 저장하도록
public class WriteProductHandler implements CommandHandler{
	private static final String FORM_VIEW ="/view_admin/writeProductForm.jsp";
	private WriteProductService writeService = new WriteProductService();
	
	//get,post구분
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception { 
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req,res);
		}else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return FORM_VIEW;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("WriteProductHandler의 processForm()");
		return FORM_VIEW;
	}//end of processForm()

	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws ParseException, IOException {
		System.out.println("WriteProductHandler의 processSubmit()진입");
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		//파일 담을 객체생성
		MultipartRequest multi=null;
		
		//업로드 될 파일의 최대 사이즈(10메가)
		int sizeLimit = 10*1024*1024;
		
		//파일이 업로드될 실제 tomcat폴더의 경로
		@SuppressWarnings("deprecation")
		String savePath = req.getSession().getServletContext().getRealPath("/product_images");
		
		try {
			multi = new  MultipartRequest(req, 
								savePath, 
								sizeLimit, 
								"UTF-8",
								new DefaultFileRenamePolicy());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//파일이름 저장
		String image= multi.getFilesystemName("image");
		
		//파라미터 받기
		String price = multi.getParameter("pPrice");
		int pPrice = Integer.parseInt(price);
		System.out.println("pPrice="+pPrice);
		String dis = multi.getParameter("discount");
		int discount = Integer.parseInt(dis);
		
		WriteRequest product = new WriteRequest();
		product.setpName(multi.getParameter("pName"));
		System.out.println("multi.getParameter(pName)="+multi.getParameter("pName"));
		product.setCategory(multi.getParameter("category"));
		product.setpPrice(pPrice);
		product.setDiscount(discount);
		product.setWriter(multi.getParameter("writer"));
		product.setPublishing(multi.getParameter("publishing"));
		product.setImageFileURL(multi.getFilesystemName("imageFileURL"));
		System.out.println("multi.getParameter(imageFileURL)="+multi.getFilesystemName("imageFileURL"));
		product.setpDate(multi.getParameter("pDate"));
		product.setDetailContent(multi.getParameter("detailContent"));
		

		//로그인 정보는 일단 생략
		int newProductNo = writeService.write(product);
		req.setAttribute("newProductNo", newProductNo);
		
		return "/view_admin/writeProductSuccess.jsp";
	}//end of processForm()

	private WriteRequest createWriteRequest(HttpServletRequest req) throws NumberFormatException, ParseException {
		System.out.println("pPrice"+req.getParameter("pPrice"));
		String p=req.getParameter("pPrice");
		int pPrice = Integer.parseInt(p);
		
		String d=req.getParameter("discount");
		int discount=Integer.parseInt(d);
		
		return new WriteRequest(req.getParameter("pName"),
									req.getParameter("category"),
									pPrice,
									discount,
									req.getParameter("writer"),
									req.getParameter("publishing"),
									req.getParameter("imageFileURL"),
									req.getParameter("pDate"),
									req.getParameter("detailContent"));
	}


}
