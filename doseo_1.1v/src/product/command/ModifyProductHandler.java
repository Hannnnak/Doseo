package product.command;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import product.model.Product;
import product.service.ModifyProductService;
import product.service.PermissionDeniedException;
import product.service.ProductNotFoundException;
import product.service.ReadProductService;


public class ModifyProductHandler implements CommandHandler{

	private static final String FORM_VIEW = "/view_admin/modifyForm.jsp";
	private ReadProductService readService = new ReadProductService();
	private ModifyProductService modifyService = new ModifyProductService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ModifyArticleHandler의 process()진입 ");
		
		if(request.getMethod().equalsIgnoreCase("GET")) {	//GET방식으로 요청이 들어오는 경우
			System.out.println("Get방식 호출 -> ModifyArticleHandler의 processForm()호출");
			return	processForm(request, response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) {	//post방식으로 요청이 들어오는 경우
			System.out.println("Post방식 호출 ->ModifyArticleHandler의 processSubmit()호출");
			return	processSubmit(request, response);
		}else {
			//405에러(요청한 파일이 있지만 접근할 수 없는 오류일 경우)
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return	null;
		}
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{
		System.out.println("ModifyArticleHandler의 processForm()진입");
		
		try {
			String noVal = request.getParameter("pNo");
			int no = Integer.parseInt(noVal);
			Product product = readService.getProduct(no);
			System.out.println(product.getpDate());

			//String pd=request.getParameter("pDate");
//			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
//			Date pDate = transFormat.parse(pd);
			
			Product modReq = new Product(no, 
											product.getpName(),
											product.getCategory(),
											product.getpPrice(),
											product.getDiscount(),
											product.getWriter(),
											product.getPublishing(),
											product.getImageFileURL(),
											product.getpDate(),
											product.getDetailContent());
			System.out.println(modReq.getpNo());
			request.setAttribute("pNo", modReq.getpNo());
			request.setAttribute("modReq", modReq);
			return FORM_VIEW;
		}catch(ProductNotFoundException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}//end of processForm
	
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String noVal = request.getParameter("pNo");
		
		int no = Integer.parseInt(noVal);
	
		String p=request.getParameter("pPrice");
		int pPrice = Integer.parseInt(p);
		
		String d=request.getParameter("discount");
		int discount=Integer.parseInt(d);
		
		Product modReq = new Product(no, 
										request.getParameter("pName"),
										request.getParameter("category"),
										pPrice,
										discount,
										request.getParameter("writer"),
										request.getParameter("publishing"),
										request.getParameter("imageFileURL"),
										request.getParameter("pDate"),
										request.getParameter("detailContent"));
		request.setAttribute("modReq", modReq);
		
		try {
			modifyService.modify(modReq);
			return "/view_admin/modifySuccess.jsp";
		}catch(ProductNotFoundException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}catch(PermissionDeniedException e) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
	}//end of processSubmit()


}
