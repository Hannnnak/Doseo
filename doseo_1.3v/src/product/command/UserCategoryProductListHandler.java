package product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import product.service.CategoryService;
import product.service.ListProductService;
import product.service.ProductPage;

public class UserCategoryProductListHandler implements CommandHandler{

	//view
	private static final String FORM_VIEW = "../view_member/categoryList.jsp";
	
	//service
	private ListProductService listService= new ListProductService();	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UserCategoryProductListHandler의 process()진입 ");

		//파라미터 받기
		String category = request.getParameter("category");
		System.out.println("category="+category);
		//비즈니스로직
//		switch() {
//		
//		}
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
