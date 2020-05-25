package payment.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.User;
import cart.MODEL.FromCartSelectMemberID;
import cart.service.CartService;
import mvc.command.CommandHandler;
import order.MODEL.Order;
import payment.service.paymentService;

public class PaymentHandler implements CommandHandler {
	private static final String FORM_VIEW = "/view_member/paymentSuccess.jsp";
	private CartService cartService = new CartService();
	
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("PaymentService 진입");
		
		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("payment.jsp의 method방식="+request.getMethod());
			return processForm(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) {
			System.out.println("payment.jsp의 method방식="+request.getMethod());
			return processSubmit(request,response);
		}else {
			//405에러
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); 
			return null;
		}
	}
		
	//GET방식
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("AUTHUSER");
		String id = user.getId();
		
		//String memberID = "123123";
		
		String address = request.getParameter("address");
		String requests = request.getParameter("requests");
		
		paymentService paymentservice=new paymentService();
		paymentservice.insertOrder(id,address,requests);
	
		String rs = request.getParameter("type");
		request.setAttribute("id", id);
		
		
		if(rs.equals("card")) {
			request.setAttribute("type","카드");
		}else if(rs.equals("kakaopay")) {
			request.setAttribute("type","카카오페이");
		}else if(rs.equals("phone")){
			request.setAttribute("type","휴대폰 소액결제");
		}else if(rs.equals("timeBankTransfer")){
			request.setAttribute("type","실시간 계좌이체");
		}else if(rs.equals("vbank")){
			request.setAttribute("type","가상계좌");
		}
		
		Order order=new Order();
		order=paymentservice.selectOrder(id);
		
		request.setAttribute("order", order);
		
		
		ArrayList<FromCartSelectMemberID> cartList = new ArrayList<FromCartSelectMemberID>();
		cartList = cartService.selectCartService(id);
		request.setAttribute("cartList", cartList);
		
		return FORM_VIEW;
	}
	
	//POST
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String address = request.getParameter("addressList");
		String requests = request.getParameter("request");
	
		request.setAttribute("address", address);
		request.setAttribute("requests", requests);
		
		return "view_member/payment.jsp";
		
	}

}
