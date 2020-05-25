package review.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import review.service.DeleteReviewService;

public class DeleteReviewHandler implements CommandHandler {
	private static final String FORM_VIEW = "./view/review/deleteSuccess.jsp";

	private DeleteReviewService deleteService = new DeleteReviewService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}
		return null;
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
	
			String noVal = req.getParameter("no");
			int no = Integer.parseInt(noVal);
			req.setAttribute("rNo", no);
			
			deleteService.delete(no);
			return FORM_VIEW;
			
	}

}
