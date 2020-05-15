package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.DAO.ArticleContentDAO;
import article.DAO.ArticleDAO;
import article.MODEL.Article;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

//p667
//수정처리요청 컨트롤러에서 호출하는 서비스클래스
public class ModifyArticleService {

	private ArticleDAO articleDao = new ArticleDAO();
	private ArticleContentDAO contentDao = new ArticleContentDAO();
	
	//p667 17
	public void modify(ModifyRequest modiReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			//p667 23
			//articleDao.selectByID()는 p655 1
			Article article = articleDao.selectByID(conn, 
								modiReq.getArticleNumber());
			
			if(article==null) { //게실글이 없으면
				throw new ArticleNotFoundException();
			}
			
			//글작성자id와   로그인유저id 일치여부를 검사하는 함수호출
			//  일치하면 true리턴, 불일치하면 false
			if( !canModify(modiReq.getUserId(),article) ) {//불일치하면
				throw new PermissionDeniedException();
			}
			
			//p668 31
			//article테이블에 해당게시글의 제목수정
			articleDao.update(conn,
					modiReq.getTitle(), 
					modiReq.getArticleNumber());
			
			//article_content테이블에 해당게시글의 내용수정
			contentDao.update(conn, 
					modiReq.getContent(),
					modiReq.getArticleNumber());
			
			conn.commit();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException();
		}catch(PermissionDeniedException e) {
			JdbcUtil.rollback(conn);
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
		
	}

	//p668 47
	//게시글을 수정할 수 있는 권한이 있는 검사
	//=>글작성자id와   로그인유저id 일치여부
	//  일치하면 true리턴, 불일치하면 false
	private boolean canModify(String userId, Article article) {
		//글작성자id
		String id = article.getWriter().getId();
		
		//글작성자id.equals(로그인유저id )
		return id.equals(userId);
	}
	
}






