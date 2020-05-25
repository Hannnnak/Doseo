package order.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.User;
import cart.MODEL.FromCartSelectMemberID;
import cart.service.CartService;
import mvc.command.CommandHandler;
import order.MODEL.AddressList;
import order.MODEL.Order;
import order.service.OrderService;

public class OrderHandler implements CommandHandler {
	private static final String FORM_VIEW = "/view_member/order.jsp";
	private OrderService orderService = new OrderService();
	private CartService cartService = new CartService();
	ArrayList<FromCartSelectMemberID> cartList;
	
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("OrderService 진입");
		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("order.jsp의 method방식="+request.getMethod());
			return processForm(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) {
			System.out.println("order.jsp의 method방식="+request.getMethod());
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
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		HttpSession session = request.getSession();	    
		User user = (User)session.getAttribute("AUTHUSER");
		String memberID = user.getId();
		String name = user.getName();
		
		String phone = cartService.selectUser(memberID);
		
	    ArrayList<FromCartSelectMemberID> cartList = new ArrayList<FromCartSelectMemberID>();
		cartList = cartService.selectCartService(memberID);
		request.setAttribute("cartList", cartList);
		
		ArrayList<AddressList> addressList = new ArrayList<AddressList>();
		addressList = cartService.addressList(memberID);
		request.setAttribute("addressList", addressList);
		
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		
		return FORM_VIEW;
		
		
	}
}
