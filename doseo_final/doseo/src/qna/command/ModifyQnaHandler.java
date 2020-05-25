package qna.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import mvc.command.CommandHandler;
import qna.MODEL.Qna;
import qna.MODEL.Writer;
import qna.service.ModifyQnaService;
import qna.service.PermissionDeniedException;
import qna.service.QnaData;
import qna.service.QnaModifyRequest;
import qna.service.QnaNotFoundException;
import qna.service.ReadQnaService;
public class ModifyQnaHandler implements CommandHandler {
	
	private static final String FROM_VIEW = "./view/qna/modifyQnaForm.jsp";
	private ReadQnaService readService = new ReadQnaService();
	private ModifyQnaService modifyService = new ModifyQnaService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ModifyQnaHandler의 process()진입 ");
		
		if(request.getMethod().equalsIgnoreCase("GET")) {	//GET방식으로 요청이 들어오는 경우
			System.out.println("Get방식 호출 -> ModifyArticleHandler의 processForm()호출");
			return	processForm(request, response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) {	//post방식으로 요청이 들어오는 경우
			System.out.println("Post방식 호출 ->ModifyArticleHandler의 processSubmit()호출");
			return	processSubmit(request, response);
		}else {
			//405에러(요청한 파일이 있지만 접근할 수 없는 오류일 경우)
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return	null;
		}
	
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		try {
			String noVal = req.getParameter("qNo");
			int no = Integer.parseInt(noVal);
			QnaData qnaData = readService.getQna(no, false);
			User AUTHUSER = (User) req.getSession().getAttribute("AUTHUSER2");
			
			if(!canModify(AUTHUSER, qnaData)) {
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			QnaModifyRequest modReq = new QnaModifyRequest(AUTHUSER.getId(), no,
					qnaData.getQna().getqTitle(),
					qnaData.getQna().getqContents());
			System.out.println("req.getParameter(\"qTitle\") = " + req.getParameter("qTitle") );
			req.setAttribute("modReq", modReq );
//			System.out.println("req.getParameter(\"qTitle\") = " + req.getParameter("qTitle"));
			return FROM_VIEW;
			
		} catch (QnaNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	private boolean canModify(User AUTHUSER, QnaData qnaData) {
		String writerId = qnaData.getQna().getWriter().getmemberID();
//		System.out.println("modifyqnahandler writerId = "+writerId);
//		System.out.println("modifyqnahandler authUser= "+AUTHUSER);
		System.out.println("작성자 = 세션유저 확인");
		return AUTHUSER.getId().equals(writerId);
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		User AUTHUSER = (User) req.getSession().getAttribute("AUTHUSER2");
		String noVal = req.getParameter("qNo");
		System.out.println("handler qno = " + req.getParameter("qNo"));
		int no = Integer.parseInt(noVal);

		QnaModifyRequest modReq = new QnaModifyRequest(AUTHUSER.getId(), no,
				req.getParameter("qTitle"),
				req.getParameter("qContents"));
		System.out.println(" req.getParam = "  +  req.getParameter("qTitle"));
		req.setAttribute("modReq", modReq);

		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		modReq.vaildate(errors);
		if (!errors.isEmpty()) {
			return FROM_VIEW;
		}
		try {
			modifyService.modify(modReq);
			return "./view/qna/qnamodifySuccess.jsp";
		} catch (QnaNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		} catch (PermissionDeniedException e) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
	}
}

	
