package cart.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class FromDBSelectProductHandler implements CommandHandler {
	private static final String FORM_VIEW = "/cart.dom";
	
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FromDBSelectProductHandler 진입");
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

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
}
