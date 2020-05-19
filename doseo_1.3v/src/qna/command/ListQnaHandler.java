package qna.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import qna.service.ListQnaService;
import qna.service.QnaPage;


public class ListQnaHandler implements CommandHandler {
	
	private ListQnaService listService = new ListQnaService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		System.out.println("listqnahandler¿Ôµû");
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		QnaPage qnaPage = listService.getQnaPage(pageNo);
		req.setAttribute("qnaPage", qnaPage);
		return "./view/qna/ListQna.jsp";

}
}
