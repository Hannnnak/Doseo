package review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import review.service.ListReviewService;
import review.service.ReviewPage;

public class ListReviewHandler implements CommandHandler {

	private ListReviewService listService = new ListReviewService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		ReviewPage reviewPage = listService.getReviewPage(pageNo);
		req.setAttribute("reviewPage", reviewPage);
		return "../view/review/listReview.jsp";
	}

}
