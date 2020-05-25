package qna.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna.service.QnaData;
import qna.service.QnaNotFoundException;
import qna.service.ReadQnaService;
import mvc.command.CommandHandler;

public class ReadQnaHandler implements CommandHandler {
	
	private ReadQnaService readService = new ReadQnaService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
//		System.out.println("ReadQnaHandler에 들어옴");
//		System.out.println( request.getParameter("qNo")); 
		
		String noVal = request.getParameter("qNo");
		
		int number= Integer.parseInt(noVal);			
//		System.out.println("readqnahandler qNo에 noval넣기");
		try {
				QnaData qnaData = readService.getQna(number, true);
//				System.out.println("qna number가져옴");
				request.setAttribute("qnaData", qnaData);
//				System.out.println(qnaData);
				return "./view/qna/readQna.jsp";
			}catch (QnaNotFoundException e) {
				request.getServletContext().log("no Qna", e);
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return null;
				
			}
		
	}
	
	
	
	

}
