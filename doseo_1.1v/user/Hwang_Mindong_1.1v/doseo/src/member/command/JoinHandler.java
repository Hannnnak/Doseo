package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;

//GET방식으로  요청이 들어오면  폼(/view_member/joinForm.jsp)을 보여주기
/*POST방식으로 요청이 들어오면  회원가입요청을 진행
	-입력데이터가 잘못된 경우에 다시 (/view_member/joinForm.jsp)을 보여주기
	-회원가입       성공한 경우에         (/view_member/joinSuccess.jsp)을 보여주기*/

public class JoinHandler implements CommandHandler {

	//View지정
	private static final String FORM_VIEW = "/view_member/joinForm.jsp";
	private JoinService joinService = new JoinService();
	
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
	
	//GET방식으로  요청이 들어오면  폼(/view/member/joinForm.jsp)을 보여주기
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("JoinHandler의 processForm()호출");
		return FORM_VIEW;
	}
	
	
	//POST방식으로 요청이 들어오면  회원가입요청을 진행 (P598-35)
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("JoinHandler의 processSubmit()호출");
		//할일
		//1.요청파라미터 받기
		//String name =request.getParameter("name");
		//JoinRequest는 유저가 입력한 폼의 내용을 객체로 묶어서 처리
		JoinRequest joinReq = new JoinRequest();
		
		joinReq.setJmemberId(request.getParameter("memberId"));
		joinReq.setJmemberPw(request.getParameter("memberPw"));
		joinReq.setJname(request.getParameter("name"));
		joinReq.setJgender(request.getParameter("gender"));
		joinReq.setJbirth(request.getParameter("birth"));
		joinReq.setJenrollDate(request.getParameter("enrollDate"));
		joinReq.setJphone(request.getParameter("phone"));
		joinReq.setJemail(request.getParameter("email"));
		joinReq.setJfavorite(request.getParameter("favorite"));
		joinReq.setJaddress(request.getParameter("address"));	
		
		System.out.println(request.getParameter("memberId"));
		//2.비즈니스로직수행(<->Service<->DAO<->DB)
		joinService.join(joinReq);
		
		//3.Model
		
		
		//4.View지정
		return "/view_member/joinSuccess.jsp";
		
	}
	

}