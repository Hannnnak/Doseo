package cart.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cart.service.CartService;
import mvc.command.CommandHandler;

public class CartHandler implements CommandHandler {
	private static final String FORM_VIEW = "/view/view_member/cart.jsp";
	private CartService cartService = new CartService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CartHandler 진입");
		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("cart.jsp의 method방식="+request.getMethod());
			return processForm(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) {
			System.out.println("cart.jsp의 method방식="+request.getMethod());
			return processSubmit(request,response);
		}else {
			//405에러
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); 
			return null;
		}
	}

	//GET방식
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		return FORM_VIEW;
	}
	
	//POST방식
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		String curQuantity = request.getParameter("curQuantity");
		String newQuantity = request.getParameter("newQuantity");
		
		Map<String,Boolean> errors = new HashMap<>();
		return FORM_VIEW;
	}

}
