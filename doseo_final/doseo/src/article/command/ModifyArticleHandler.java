package article.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import article.service.ArticleData;
import article.service.ArticleNotFoundException;
import article.service.ModifyArticleService;
import article.service.ModifyRequest;
import article.service.PermissionDeniedException;
import article.service.ReadArticleService;
import auth.service.User;
import mvc.command.CommandHandler;

//글 수정폼보여주기 요청 및
//글 수정처리 요청 담당 컨트롤러
//p669
/* 글수정 폼 modifyForm.jsp(p674)에서 get방식요청이 들어오면
 * 글 수정폼보여주기 요청이 진행되며 -> processForm()호출
 * 수정폼이 user에게 보여줄 때에는
 * 해당 게시글의 글번호,제목,내용이 폼안에 뿌려져있어야 한다 (select쿼리결과)
 * 
 * 글수정 폼 modifyForm.jsp(p674)에서 POST방식요청이 들어오면
 * 글 수정처리 요청이 진행된다	   -> processSubmit()호출
 * ==> update쿼리진행될 예정
 * 	   	
 * 
 * 글 수정이 실패되면 다시 글수정 폼 modifyForm.jsp(p674)으로 이동
 * 글 수정이 성공하면 modifySuccess.jsp로 이동
 */
public class ModifyArticleHandler implements CommandHandler {

	//View
	private static final String FORM_VIEW
		="/view/article/modifyForm.jsp";
	
	//Service
	//수정처리용 서비스
	private ModifyArticleService modifyService =
			new ModifyArticleService();
	
	//상세내용조회 서비스
	private ReadArticleService readService =
			new ReadArticleService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ModifyArticleHandler의 process()진입");

		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("modifyForm.jsp의 method방식="+request.getMethod());
			return processForm(request,response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) { //POST방식으로 요청이 들어오면
			System.out.println("modifyForm.jsp의 method방식="+request.getMethod());
			return processSubmit(request,response);
		}else {
			//405에러
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); 
			return   null;
		}
		
	}

	//p670 66
	//수정폼에서 수정할내용을 받아서 수정처리 => update쿼리실행과 연결
	private String processSubmit(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		System.out.println("ModifyArticleHandler-수정처리processSubmit()");
		//1.파라미터받기
		int no = Integer.parseInt(request.getParameter("no")); //글번호
		String title   = request.getParameter("title");//글제목
		String content = request.getParameter("content");//글내용
		
		//2.비즈니스로직(<->Service<->DAO<->DB) p670 68
		HttpSession session = request.getSession();
		User authUser=(User)session.getAttribute("AUTHUSER"); //세션에 저장된 로그인유저의id,이름
		ModifyRequest modiReq = new ModifyRequest(
				authUser.getId(),
				no,
				title,
				content
			);
		
		//에러정보  p670 77
		Map<String,Boolean> errors = new HashMap<>();
		request.setAttribute("errors",errors);
		modiReq.validate(errors);
		if(!errors.isEmpty()) { //에러가 존재하면
			return FORM_VIEW;   //수정폼으로 이동
		}

		//3.Model P670 75
		request.setAttribute("modiREQ", modiReq);
		
		//P670 84
		try {
			modifyService.modify(modiReq);
			return "/view/article/modifySuccess.jsp";
		}catch(ArticleNotFoundException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}catch(PermissionDeniedException e) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
	}

	//p669 38
	private String processForm(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		//1.파라미터받기
		int no = Integer.parseInt(request.getParameter("no")); //글번호
		
		//2.비즈니스로직(<->Service<->DAO<->DB)
		/*수정폼이 user에게 보여줄 때에는
		 * 해당 게시글의 글번호,제목,내용이 폼안에 뿌려져있어야 한다 
		 * select * from article         where article_no=?
		 * select * from article_content where article_no=?
		 * (select쿼리결과)*/
		//상세내용조회는 ReadArticleService의 getArticle()구현해놓은 것을 이용하자
		//단 조회수는 증가시키지 않을 것이므로 false주자  P670 1
		ArticleData articleData  = 
			readService.getArticle(no, false);
		HttpSession session = request.getSession();
		User authUser=(User)session.getAttribute("AUTHUSER"); //세션에 저장된 로그인유저의id,이름
		
		//p670 45
		//로그인한 유저의 id가  게시글작성자의 id일치 비교
		//일치하면  true, 불일치하면  false리턴하는 함수호출
		if(!canModify(authUser,articleData)) { //불일치하면
			//403 : Forbidden, 접근이 거부된 문서를 요청한 상태.
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		
		//ModifyRequest는 p666
		ModifyRequest modiReq = new ModifyRequest(
				authUser.getId(),
				no,
				articleData.getArticle().getTitle(),
				articleData.getContent().getContent()
			);
		
		//3.Model P670 53
		request.setAttribute("modiREQ", modiReq);
		
		//4.View
		return FORM_VIEW;
	}

	//p670 61
	//로그인한 유저의 id가  게시글작성자의 id일치 비교
	//일치하면  true, 불일치하면  false리턴하는 함수호출
	private boolean canModify(User authUser, ArticleData articleData) {
		//게시글작성자의 id
		String writerId = articleData.getArticle().getWriter().getId();
		
		//로그인한유저의id.equals(게시글작성자의id)
		return authUser.getId().equals(writerId);
	}

}








