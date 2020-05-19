package product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import product.service.ListProductService;
import product.service.ProductPage;

public class UserMainHandler implements CommandHandler{

	//view
	private static final String FORM_VIEW = "../view_member/main.jsp";
	
	//Service 
	private ListProductService listService= new ListProductService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UserMainHandler의 process()진입 ");
		
		String pageNoVal = request.getParameter("pageNo");
		int pageNo = 1;
		if( pageNoVal != null ) {
			pageNo=Integer.parseInt(pageNoVal);
		}
		ProductPage productPage = listService.getProductPage(pageNo);
		request.setAttribute("productPage", productPage);
		return FORM_VIEW;
	}

}
