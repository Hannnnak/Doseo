package member.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.User;
import member.MODEL.Member;
import member.service.MypageService;
import member.service.MypageService2;
import mvc.command.CommandHandler;
import order.MODEL.Order;

//이 클래스는  마이페이지 요청을 담당 컨트롤러
public class MypageHandler implements CommandHandler {

	private MypageService mypageService = new MypageService();
	private MypageService2 mypageService2 = new MypageService2();
	
	@Override
	public String process(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		//할일
		//1.파라미터받기
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("AUTHUSER");
		String id = user.getId();
		System.out.println("세션에서 받은 id = "+id);
				
		//2.비즈니스로직(<->Service<->DAO<->DB)
		try {
			Member member = mypageService.getMember(id);
			System.out.println("MypageHandler-process(member)="+member);
			
			List<Order> order = mypageService2.getOrder(id);
			System.out.println("MypageHandler-process(order)="+order);
			
			//3.Model
			request.setAttribute("member",member);
			request.setAttribute("order",order);
			
			//4.View
			return "/view_member/mypageForm.jsp";
		}finally {
			
		}
	}

}