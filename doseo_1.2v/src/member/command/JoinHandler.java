package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;

//p597
//GET방식으로  요청이 들어오면  폼(/view/member/joinForm.jsp)을 보여주기
/*POST방식으로 요청이 들어오면  회원가입요청을 진행
	-입력데이터가 잘못된 경우에 다시 (/view/member/joinForm.jsp)을 보여주기
	-회원가입       성공한 경우에         (/view/member/joinSuccess.jsp)을 보여주기
*/
public class JoinHandler implements CommandHandler {

	//View지정(p598 16)
	private static final String FORM_VIEW = "/view/member/joinForm.jsp";
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
		//p598 21~
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
			return   null;
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
		
		joinReq.setId(request.getParameter("id"));
		joinReq.setPassword(request.getParameter("password"));
		joinReq.setConfirmPassword(request.getParameter("confirmPassword"));
		joinReq.setname(request.getParameter("name"));
		joinReq.setGender(request.getParameter("gender"));
		joinReq.setBirth(request.getParameter("birthyy")+request.getParameter("birthmm")+request.getParameter("birthdd"));
		joinReq.setPhone(request.getParameter("phone1") + request.getParameter("phone2") + request.getParameter("phone3"));
		//joinReq.setPhone(request.getParameter("phone1") +"-"+ request.getParameter("phone2") +"-"+ request.getParameter("phone3"));
		joinReq.setEmail(request.getParameter("email1") + request.getParameter("email2"));
//		joinReq.setFavorite(request.getParameter("favorite"));
//		joinReq.setFavorite(request.getParameterValues("favorite"));
		
		String[] a = request.getParameterValues("favorite");
		String b = "";
		if(a != null) {
			for (int i=0; i<a.length; i++)
				b = b + a[i] + " ";
		}else
			b = "없음";
		joinReq.setFavorite(b);
		System.out.println(b);	
		
//		joinReq.setAddress(request.getParameter("address"));
		joinReq.setAddress(request.getParameter("add1") + " " + 
				request.getParameter("add2") + " " + 
				request.getParameter("add3") + " (" + 
				request.getParameter("add4") + ")");	
	
		
		
		//P598 42~49 입력하세요
		Map<String, Boolean> errors = new HashMap<>();
		request.setAttribute("errors", errors);
		
		joinReq.validate(errors);
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
	
		//2.비즈니스로직수행(<->Service<->DAO<->DB)
		//joinService.join(joinReq);
		
		try {
			joinService.join(joinReq);
			return "/view/member/joinSuccess.jsp";
		} catch (DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
		
		//3.Model
		
		
		//4.View지정
		//return "/view/member/joinSuccess.jsp";
		
	}
	

}








