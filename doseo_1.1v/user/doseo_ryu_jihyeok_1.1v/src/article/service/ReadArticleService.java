package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.DAO.ArticleContentDAO;
import article.DAO.ArticleDAO;
import article.MODEL.Article;
import article.MODEL.ArticleContent;
import jdbc.connection.ConnectionProvider;

//p658
//게시글 상세조회 요청 컨트롤러에서 호출하는 서비스클래스
public class ReadArticleService {
	
	
	//Article테이블연동
	private ArticleDAO articleDao = new ArticleDAO();
	//Article_content 테이블연동
	private ArticleContentDAO contentDao = 
			new ArticleContentDAO();
	
	//조회수증가 : 조회수증가시 true전달
	//조회수 증가 및 특정글번호 내용 조회
	public ArticleData getArticle(int articleNum, boolean b) {
		
		try {
			Connection conn  =
				ConnectionProvider.getConnection();
			//조회수증가
			if( b==true ) {//p659 27 
				articleDao.incrementReadCount(conn,articleNum);
			}

			//특정글번호 article조회
			Article article = articleDao.selectByID(conn, articleNum);
			
			if( article==null ) {//특정글번호 article조회실패 p659 20 
				throw new ArticleNotFoundException();
			}
			
			//특정글번호 article_contnet조회 p659 23
			ArticleContent content = contentDao.selectByID(conn, articleNum);
			if( content==null ) {
				throw new ArticleContentNotFoundException();
			}
			return new ArticleData(article,content);
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	
		
	}
}
