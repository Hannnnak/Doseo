package order.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.command.CommandHandler;
import payment.service.paymentService;

public class OrderSuccessHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//HttpSession session = request.getSession();
		//String id=(String) session.getAttribute("ID");
		
		String memberID = "123123";
		
		String address = request.getParameter("addressList");
		String requests = request.getParameter("request");
	
		paymentService paymentservice=new paymentService();
		paymentservice.insertOrder(memberID,address,requests);
		
		return null;
	}

}
