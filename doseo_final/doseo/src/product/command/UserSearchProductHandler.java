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

public class UserSearchProductHandler implements CommandHandler{

	// view
	private static final String FORM_VIEW = "./view_member/search.jsp";

	// service(dao연결)
	private ListProductService listService = new ListProductService();
	private ReadProductService readService = new ReadProductService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UserSearchProductHandler진입");
		
		//파라미터받기=>제대로 받음
		String search = request.getParameter("search");
		System.out.println(search);
		
		try {
			// 비즈니스로직
			List<Product> product = readService.getProductBySearch(search);
			System.out.println(product.toString());
			request.setAttribute("product", product);
			
			return FORM_VIEW;
			
		} catch (ProductNotFoundException e) {
			request.getServletContext().log("no product", e);
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		
	}

}
