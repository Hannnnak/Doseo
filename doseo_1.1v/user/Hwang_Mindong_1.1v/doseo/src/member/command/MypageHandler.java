package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.User;
import member.MODEL.Member;
import member.service.MypageService;
import mvc.command.CommandHandler;

//이 클래스는  글상세보기 요청을 담당 컨트롤러
//p659
public class MypageHandler implements CommandHandler {

	private MypageService mypageService = new MypageService();
	
	@Override
	public String process(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		//할일
		//1.파라미터받기
		HttpSession session = request.getSession();
		User user=(User)session.getAttribute("AUTHUSER");
		String id= user.getId();
		System.out.println("세션에서 받은 id = "+id);
				
		//2.비즈니스로직(<->Service<->DAO<->DB)
		try {
			Member member = 
					mypageService.getMember(id);
			System.out.println("MypageHandler-process(member)="+member);
			
			//3.Model
			request.setAttribute("member",member);
			
			//4.View
			return "/view_member/mypageForm.jsp";
		}finally {
			
		}
	}

}