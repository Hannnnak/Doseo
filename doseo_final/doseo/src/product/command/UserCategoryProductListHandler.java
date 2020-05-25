package product.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import product.model.Product;
import product.service.ListProductService;
import product.service.ProductNotFoundException;
import product.service.ProductPage;
import product.service.ReadProductService;

public class UserCategoryProductListHandler implements CommandHandler{

	//view
	private static final String FORM_VIEW = "view_member/categoryList.jsp";
	private ReadProductService readService = new ReadProductService();
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UserCategoryProductListHandler의 process()진입 ");
		
		//1. 파라미터 받기
		String ca = request.getParameter("category");
		//System.out.println(ca);
		//2. 비즈니스로직 처리
		//제품상세보기와 비슷!!! 가져온 ca를 가지고 select * from product where category=ca;
		try {
			List<Product>  product = readService.getProduct(ca);
			request.setAttribute("product", product);
			return FORM_VIEW;
		}catch(ProductNotFoundException e) {
			request.getServletContext().log("no product", e);
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	
	}

}
