package review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import review.service.ReadReviewService;
import review.service.ReviewContentNotFoundException;
import review.service.ReviewData;
import review.service.ReviewNotFoundException;

public class ReadReviewHandler implements CommandHandler {

	private ReadReviewService readService = new ReadReviewService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		String noVal = req.getParameter("no");
		int reviewNum = Integer.parseInt(noVal);
		try {
			ReviewData reviewData = readService.getReview(reviewNum, true);
			req.setAttribute("reviewData", reviewData);
			return "./view/review/readReview.jsp";
		} catch (ReviewNotFoundException | ReviewContentNotFoundException e) {
			req.getServletContext().log("no review", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

}
