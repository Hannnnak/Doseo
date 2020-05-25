package article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticlePage;
import mvc.command.CommandHandler;

//전체목록보기 요청 담당 컨트롤러
//P652
public class ListArticleHandler implements CommandHandler {

	//Service
	private ListArticleService listService =
			new ListArticleService();
	
	@Override
	public String process(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		//할일
		//1.파라미터 받기
		String pageNoVal = request.getParameter("pageNo");//보고싶은페이지
		int pageNo = 1;
		if( pageNoVal!=null ) { //보고싶은페이지가 넘어오면
			pageNo = Integer.parseInt(pageNoVal);
		}
				
		//2.비즈니스로직(<->Service<->DAO<->DB) p652 22
		ArticlePage articlePage = 
				listService.getArticlePage(pageNo);
		
		//3.Model
		request.setAttribute("articlePAPE", articlePage);
				
		//4.View
		return "/view/article/listArticle.jsp";
	}

}








