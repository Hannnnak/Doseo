package review.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import mvc.command.CommandHandler;
import review.MODEL.Writer;
import review.service.WriteRequest;
import review.service.WriteReviewService;

public class WriteReviewHandler implements CommandHandler {
	private static final String FORM_VIEW = "./view/review/newReviewForm.jsp";
	private WriteReviewService writeService = new WriteReviewService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		User user = (User)req.getSession(false).getAttribute("AUTHUSER");
		WriteRequest writeReq = createWriteRequest(user, req);
		writeReq.validate(errors);
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		int newReviewNo = writeService.write(writeReq);
		req.setAttribute("newReviewNo", newReviewNo);
		
		return "./view/review/newReviewSuccess.jsp";
	}

	private WriteRequest createWriteRequest(User user, HttpServletRequest req) {
		return new WriteRequest(
				req.getParameter("bookname"),
				new Writer(user.getId(), user.getName()),
				req.getParameter("title"),
				req.getParameter("content"),
				req.getParameter("rating")
				);
	}
}
