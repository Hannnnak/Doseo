package review.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import mvc.command.CommandHandler;
import review.service.ModifyRequest;
import review.service.ModifyReviewService;
import review.service.PermissionDeniedException;
import review.service.ReadReviewService;
import review.service.ReviewData;
import review.service.ReviewNotFoundException;

public class ModifyReviewHandler implements CommandHandler {
	private static final String FORM_VIEW = "../view/review/modifyForm.jsp";

	private ReadReviewService readService = new ReadReviewService();
	private ModifyReviewService modifyService = new ModifyReviewService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		try {
			String noVal = req.getParameter("no");
			int no = Integer.parseInt(noVal);
			ReviewData reviewData = readService.getReview(no, false);
			User AUTHUSER = (User) req.getSession().getAttribute("AUTHUSER");
			if (!canModify(AUTHUSER, reviewData)) {
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			ModifyRequest modReq = new ModifyRequest(AUTHUSER.getId(), no,
					reviewData.getReview().getTitle(),
					reviewData.getContent());

			req.setAttribute("modReq", modReq);
			return FORM_VIEW;
		} catch (ReviewNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

	private boolean canModify(User AUTHUSER, ReviewData reviewData) {
		String writerId = reviewData.getReview().getWriter().getId();
		return AUTHUSER.getId().equals(writerId);
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		User AUTHUSER = (User) req.getSession().getAttribute("AUTHUSER");
		String noVal = req.getParameter("no");
		int no = Integer.parseInt(noVal);

		ModifyRequest modReq = new ModifyRequest(AUTHUSER.getId(), no,
				req.getParameter("title"),
				req.getParameter("content"));
		req.setAttribute("modReq", modReq);

		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		modReq.validate(errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			modifyService.modify(modReq);
			return "../view/review/modifySuccess.jsp";
		} catch (ReviewNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		} catch (PermissionDeniedException e) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
	}
}
