package qna.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import qna.service.DeleteQnaService;

public class DeleteQnaHandler implements CommandHandler {
	private static final String FORM_VIEW="./view/qna/deleteSuccess.jsp";

	private DeleteQnaService deleteService = new DeleteQnaService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}
		return null;
	}
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		
		String noVal = req.getParameter("qNo");
		int no = Integer.parseInt(noVal);
		req.setAttribute("qNo", no);
		System.out.println("delete handler no = " + no);
		deleteService.delete(no);
		
		return FORM_VIEW;
	
	
}
}
