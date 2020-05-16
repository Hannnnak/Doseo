package product.command;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import product.service.WriteProductService;
import product.service.WriteRequest;

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

	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws ParseException {
		System.out.println("processSubmit()진입");
		System.out.println(req.getParameter("pName"));
		System.out.println(req.getParameter("pPrice"));
		System.out.println(req.getParameter("bDate"));

		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		//로그인 정보는 일단 생략
		WriteRequest writeReq = createWriteRequest(req);
//		int newProductNo = writeService.write((WriteRequest) req);
		int newProductNo = writeService.write(writeReq);
		req.setAttribute("newProductNo", newProductNo);
		
		return "/view_admin/writeProductSuccess.jsp";
	}//end of processForm()

	private WriteRequest createWriteRequest(HttpServletRequest req) throws NumberFormatException, ParseException {
//		System.out.println(req.getParameter("pPrice"));
		String p=req.getParameter("pPrice");
		int pPrice = Integer.parseInt(p);
		
		String d=req.getParameter("discount");
		int discount=Integer.parseInt(d);
		
//		String bd=req.getParameter("bDate");
//		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Date bDate = transFormat.parse(bd);


		
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
