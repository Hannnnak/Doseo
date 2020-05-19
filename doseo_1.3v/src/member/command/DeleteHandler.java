package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.LoginFailException;
import auth.service.LoginService;
import auth.service.User;
import member.MODEL.Member;
import member.service.DeleteService;
import member.service.MypageService;
import mvc.command.CommandHandler;

//이 클래스는  마이페이지 요청을 담당 컨트롤러
public class DeleteHandler implements CommandHandler {
	
	//View지정
	private static final String FORM_VIEW = "/view_member/deleteForm.jsp";
	private	DeleteService deleteService = new DeleteService();
	private	MypageService mypageService = new MypageService();
	
	@Override
	public String process(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println("DeleteHandler의 process()진입");

		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("deleteForm.jsp의 method방식="+request.getMethod());
			return processForm(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) { //POST방식으로 요청이 들어오면
			System.out.println("deleteForm.jsp의 method방식="+request.getMethod());
			return processSubmit(request,response);
		}else {
			//405에러
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
		
	}

	//GET방식으로  요청이 들어오면  폼(/view/member/deleteForm.jsp)을 보여주기
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DeleteHandler의 processForm()호출");
		//1.파라미터 받기
		User user = (User)request.getSession().getAttribute("AUTHUSER");
		String id = user.getId();
		System.out.println("세션에서 받은 id = "+id);
		Member member = mypageService.getMember(id);
		System.out.println("MypageHandler-process(member)="+member);
		
		//3.Model
		request.setAttribute("member",member);
		
		//4.View

		return FORM_VIEW;
	}
	
	/*POST방식으로 요청이 들어오면  회원탈퇴요청을 진행
	  -입력데이터가 잘못된 경우에 다시 (/view/member/deleteForm.jsp)을 보여주기 */
	private String processSubmit(HttpServletRequest request, 
			HttpServletResponse response)
			throws Exception {
		//1.파라미터받기
		String id 		= trim(request.getParameter("id")); //아이디
		String password = request.getParameter("password"); //비번
		System.out.println("processSubmit() id/password="+id+"/"+password);
		
		//2.비즈니스로직수행(<->Servict<->DAO<->DB)
		Map<String,Boolean> errors = new HashMap<>();
		
			//유효성검사등관련 에러처리
			//에러에 대한 데이터를 Map방식으로 관리
			
			//3.Model(session객체이용,request객체이용,..)
			request.setAttribute("errors",errors); //View에 Model로 전달
			
			if( id==null || id.isEmpty() ) {
				errors.put("id",Boolean.TRUE);
			}
			
			if( password==null || password.isEmpty() ) {
				errors.put("password",Boolean.TRUE);
			}
			
			//에러가 발생되면
			if( !errors.isEmpty() ) {
				return FORM_VIEW; //로그인폼으로 이동
			}
			
		try {
			deleteService.deleteMember(id,password);
			// new User(member.getId(), member.getName())
			
			//형식> session.setAttribute(String name,Obejct value);
			HttpSession session = request.getSession();
			session.invalidate();
			
			//4.View
			//회원탈퇴 성공시  deleteSuccess.jsp문서로 sendRedirect를 이용하여 강제이동
			response.sendRedirect(request.getContextPath()+"/view_member/deleteSuccess.jsp");
			return null;
		} catch (LoginFailException e) {//로그인 실패시
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			e.printStackTrace(); //에러관련내용 콘솔출력
			return FORM_VIEW;    //  /view/member/deleteForm.jsp를  View지정 
		}
	}
	
	private String trim(String str) {
		//조건? 참: 거짓;
		return  str==null? null: str.trim();
	}
}