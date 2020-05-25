package product.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;
import product.model.Product;
import product.service.ListProductService;
import product.service.ProductNotFoundException;
import product.service.ProductPage;
import product.service.ReadProductService;

public class ListProductHandler implements CommandHandler {

	//view
	private static final String FORM_VIEW = "../view_admin/listProduct.jsp";
	
	//service(dao연결)
	private ListProductService listService= new ListProductService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ListProductHandler의 process()진입 ");

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
