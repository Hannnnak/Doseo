package cart.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.User;
import cart.MODEL.Cart;
import cart.MODEL.FromCartSelectMemberID;
import cart.service.CartService;
import cart.service.ProductNotFoundException;
import mvc.command.CommandHandler;

public class CartHandler implements CommandHandler {
	private static final String FORM_VIEW = "/view_member/cart.jsp";
	private CartService cartService = new CartService();
	ArrayList<FromCartSelectMemberID> cartList;
	
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
	private String processForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();	    
		User user = (User)session.getAttribute("AUTHUSER");
		
		if(user==null) {
			return "/login.dom";
		}
		
		String memberID = user.getId();
		
		
		if((request.getParameter("pno"))!=null) {
			
		int pno=Integer.parseInt(request.getParameter("pno"));
		int count=Integer.parseInt(request.getParameter("count"));
		
		cartService.insertCart(pno,count,memberID);
		//장바구니에 도서 넣기 완료!
		}
		
	    ArrayList<FromCartSelectMemberID> cartList = new ArrayList<FromCartSelectMemberID>();
		cartList = cartService.selectCartService(memberID);
		request.setAttribute("cartList", cartList);
		
		return FORM_VIEW;
	}
	
	//POST방식
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return null;
	}
}
