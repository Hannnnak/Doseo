package product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import product.model.Product;
import product.service.DeleteProductService;
import product.service.ModifyProductService;
import product.service.ReadProductService;

public class DeleteProductHandler implements CommandHandler{

	private static final String FORM_VIEW = "/view_admin/deleteSuccess.jsp";
	private DeleteProductService deleteService = new DeleteProductService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request.getMethod().equalsIgnoreCase("GET")) {	
			System.out.println("Get방식 호출 -> DeleteProductHandler의 processForm()호출");
			return	processForm(request, response);
		}
		return null;
		
	}

	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		
		String noVal = request.getParameter("pNo");
		int no = Integer.parseInt(noVal);
		request.setAttribute("pNo", no);
		
		deleteService.delete(no);
		return FORM_VIEW;
	}



}
