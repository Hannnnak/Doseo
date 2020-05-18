package product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import product.model.Product;
import product.service.ProductNotFoundException;
import product.service.ReadProductService;

public class UserReadProductListHandler implements CommandHandler{
	private static final String FORM_VIEW = "/view_member/productDetail.jsp";
	private ReadProductService readService = new ReadProductService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UserReadProductListHandler의 process진입");
		System.out.println("process진입--"+request.getParameter("pNo"));
		String noVal = request.getParameter("pNo");
		int productNum = Integer.parseInt(noVal);

		
		try {
			Product  product = readService.getProduct(productNum);
			request.setAttribute("product", product);
			return FORM_VIEW;
		}catch(ProductNotFoundException e) {
			request.getServletContext().log("no product", e);
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

}
