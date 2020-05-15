package article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleContentNotFoundException;
import article.service.ArticleData;
import article.service.ArticleNotFoundException;
import article.service.ReadArticleService;
import mvc.command.CommandHandler;

//이 클래스는  글상세보기 요청을 담당 컨트롤러
//p659
public class ReadArticleHandler implements CommandHandler {

	private ReadArticleService readService =
			new ReadArticleService();
	
	@Override
	public String process(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		//할일
		//1.파라미터받기
		String no = request.getParameter("no");	//(게시글)글번호
		int articleNum =Integer.parseInt(no);
		String pageNo=request.getParameter("pageNo");	//보고싶은페이지(릴레이용)
				
		//2.비즈니스로직(<->Service<->DAO<->DB)
		try {
			//p660 22
			//2-1.조회수증가 : 조회수증가시 true전달
			//2-2.상세내용조회
			ArticleData articleData  = 
				readService.getArticle(articleNum, true);
			
			//3.Model
			request.setAttribute("articleDATA",articleData);
			request.setAttribute("pageNo",pageNo);//보고싶은페이지(릴레이용)
			//P662의 readArticle.jsp완성하자~~~~~~~~~~~~~
			
			
			//4.View
			return "/view/article/readArticle.jsp";
		}catch(ArticleNotFoundException |
				ArticleContentNotFoundException e) {
			request.getServletContext().log("no article", e);
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

}










