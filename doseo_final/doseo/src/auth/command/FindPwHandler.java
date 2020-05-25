package auth.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.Find;
import auth.service.FindService;
import auth.service.LoginFailException;
import mvc.command.CommandHandler;

//p597
//GET방식으로  요청이 들어오면  폼(/view/member/findForm.jsp)을 보여주기
/*POST방식으로 요청이 들어오면  회원가입요청을 진행
	-입력데이터가 잘못된 경우에 다시 (/view/member/findForm.jsp)을 보여주기
	-회원가입       성공한 경우에         (/view/member/findSuccess.jsp)을 보여주기
*/
public class FindPwHandler implements CommandHandler {

	//View지정(p598 16)
	private static final String FORM_VIEW = "/view/member/findPwForm.jsp";
	private FindService findService = new FindService();
	
	@Override
	public String process(HttpServletRequest request, 
						  HttpServletResponse response) throws Exception {
		System.out.println("FindPwHandler 진입성공");
		
		//할일
		//1.요청파라미터 받기
		
		//2.비즈니스로직수행(<->Service<->DAO<->DB)
		
		//3.Model
		
		//4.View지정
		//p598 21~
		//GET방식으로  요청이 들어오면
		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("findPwForm.jsp의 method방식="+request.getMethod());
			return processForm(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) { //POST방식으로 요청이 들어오면
			System.out.println("findPwForm.jsp의 method방식="+request.getMethod());
			return processSubmit(request,response);
		}else {
			//405에러
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); 
			return   null;
		}
	}
	
	//GET방식으로  요청이 들어오면  폼(/view/member/findForm.jsp)을 보여주기
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("FindHandler의 processForm()호출");
		return FORM_VIEW;
	}
	
	
	//POST방식으로 요청이 들어오면  회원가입요청을 진행 (P598-35)
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("FindHandler의 processSubmit()호출");
		//할일
		//1.요청파라미터 받기
		//String name =request.getParameter("name");
		//FindRequest는 유저가 입력한 폼의 내용을 객체로 묶어서 처리
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		
		//P598 42~49 입력하세요
		Map<String, Boolean> errors = new HashMap<>();
		request.setAttribute("errors", errors);
		
		if( name==null || name.isEmpty() ) {
			errors.put("name",Boolean.TRUE);
		}
		
		if( email==null || email.isEmpty() ) {
			errors.put("email",Boolean.TRUE);
		}
		
		if( id==null || id.isEmpty() ) {
			errors.put("id",Boolean.TRUE);
		}
		
		//에러가 발생되면
		if(  !errors.isEmpty() ) {
			return FORM_VIEW; //로그인폼으로 이동
		}
		//2.비즈니스로직수행(<->Service<->DAO<->DB)
		//findService.find(findReq);
		
		try {
			//리턴타입이 Find클래스인경우
			String findp = findService.find3(name, email, id);
			System.out.println("FindHandler클래스의 processSubmit() findp ="+findp);
			
			//3.Model
			request.setAttribute("FINDP", findp); //객체데이터를 모델로
			
			return "/view/member/findPwSuccess.jsp";
		} catch (LoginFailException e) {
			System.out.println("에러났다1");
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			e.printStackTrace(); //에러관련내용 콘솔출력
			return FORM_VIEW;
		}
		

		
		//3.Model
		
		
		//4.View지정
		//return "/view/member/findSuccess.jsp";
		
	}
	

}










