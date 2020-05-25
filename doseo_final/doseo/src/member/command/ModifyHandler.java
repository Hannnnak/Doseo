package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.User;
import member.MODEL.Member;
import member.service.ModifyRequest;
import member.service.ModifyService;
import member.service.MypageService;
import mvc.command.CommandHandler;

//이 클래스는  마이페이지 요청을 담당 컨트롤러
public class ModifyHandler implements CommandHandler {

	private ModifyService modifyService = new ModifyService();
	private MypageService mypageService = new MypageService();
	
	@Override
	public String process(HttpServletRequest request, 
						  HttpServletResponse response) throws Exception {
		System.out.println("JoinHandler 진입성공");
		
		//할일
		//1.요청파라미터 받기
		
		//2.비즈니스로직수행(<->Service<->DAO<->DB)
		
		//3.Model
		
		//4.View지정
		//GET방식으로  요청이 들어오면
		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("joinForm.jsp의 method방식="+request.getMethod());
			return processForm(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) { //POST방식으로 요청이 들어오면
			System.out.println("joinForm.jsp의 method방식="+request.getMethod());
			return processSubmit(request,response);
		}else {
			//405에러
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); 
			return null;
		}
	}
	
	//GET방식으로  요청이 들어오면  폼(/view/member/ModifyForm.jsp)을 보여주기
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("JoinHandler의 processForm()호출");
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
			
			//3.Model
			request.setAttribute("member",member);
			
			//4.View
			return "/view_member/modifyForm.jsp";
		}finally {
			
		}
	}
	
	
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		//할일
		//1.파라미터받기
		ModifyRequest modifyReq = new ModifyRequest();
		
		modifyReq.setMid(request.getParameter("id"));
//		modifyReq.setMmemberPw(request.getParameter("memberPw"));
		modifyReq.setMname(request.getParameter("name"));
		modifyReq.setMgender(request.getParameter("gender"));
		modifyReq.setMbirth(request.getParameter("birth"));
//		modifyReq.setMenrollDate(request.getParameter("enrollDate"));
		modifyReq.setMphone1(request.getParameter("phone1"));
		modifyReq.setMphone2(request.getParameter("phone2"));
		modifyReq.setMphone3(request.getParameter("phone3"));
		modifyReq.setMemail(request.getParameter("email"));
		modifyReq.setMfavorite1(request.getParameter("favorite1"));
		modifyReq.setMfavorite2(request.getParameter("favorite2"));
		modifyReq.setMfavorite3(request.getParameter("favorite3"));
		modifyReq.setMaddress(request.getParameter("address"));			
		//2.비즈니스로직수행(<->Service<->DAO<->DB)
		modifyService.modify(modifyReq);
			
		//3.Model
		
		
		//4.View지정
		return "/view_member/modifySuccess.jsp";
	}

}