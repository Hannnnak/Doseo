package product.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import product.model.Product;
import product.service.ListProductService;
import product.service.ProductNotFoundException;
import product.service.ProductPage;
import product.service.ReadProductService;

public class SearchProductHandler implements CommandHandler{

		// view
		private static final String FORM_VIEW = "../view_admin/searchProduct.jsp";

		// service(dao연결)
		private ListProductService listService = new ListProductService();
		private ReadProductService readService = new ReadProductService();

		@Override
		public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			if(request.getMethod().equalsIgnoreCase("GET")) {
				return processForm(request, response);
			}else if(request.getMethod().equalsIgnoreCase("POST")) {
				return processSubmit(request,response);
			}else {
				response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				return FORM_VIEW;
			}
			
		}// end of process

		private String processForm(HttpServletRequest request, HttpServletResponse response) {
			return FORM_VIEW;
		}

		
		private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws IOException {
			//파라미터받기=>제대로 받음
			String col = request.getParameter("col");
			String word = request.getParameter("word");
				
			try {
				// 비즈니스로직
				List<Product> product = readService.getProduct(col, word);
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
