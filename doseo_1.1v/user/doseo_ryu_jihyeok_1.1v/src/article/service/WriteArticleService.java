package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import article.DAO.ArticleContentDAO;
import article.DAO.ArticleDAO;
import article.MODEL.Article;
import article.MODEL.ArticleContent;
import article.command.WriteRequest;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

//p638
//글등록과 관련한 DAO와 연동
public class WriteArticleService {

	//article테이블과 연동하는  DAO
	private ArticleDAO articleDao = new ArticleDAO();
	
	//article_content테이블과 연동하는 DAO
	private ArticleContentDAO contentDao = 
			new ArticleContentDAO();
	
	//P639 19
	public Integer write(WriteRequest req) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false); //트랜잭션시작
		
			//dao호출 p639 25
			Article article = toArticle(req);
			/*insert into article(article_no,writer_id,writer_name,title,regdate,moddate,read_cnt)
values(article_no?,writer_id?,writer_name?,title?,regdate?,moddate?,0);*/
			Article savedArticle = articleDao.insert(conn,article);
			
			if(savedArticle==null) {//insert실패하면 null리턴
			 throw new RuntimeException("failt to insert article");
			}
			
			//P639 30
			ArticleContent content = 
				new ArticleContent(savedArticle.getNumber(),
									req.getContent());
			
			//article_content에 insert
			/*insert into article_content(article_no,content)
				values(article_no?,content?);*/
			ArticleContent savedContent = 
				contentDao.insert(conn,content);
			if(savedContent==null) { //article_content테이블의 insert실패시
				throw new RuntimeException("article_content테이블에 insert실패");
			}
			
			conn.commit(); //트랜잭션반영
			
			return savedContent.getNumber();//p639 40
			
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}catch(RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		}
	}

	//p639 52
	//WriteRequest를 통해 받은
	//writer_id 컬럼용,writer_name 컬럼용,title컬럼용,content컬럼용+
	//나머지 
	//regdate,moddate,read_cnt컬럼용 데이터를
	//채우는 함수
	private Article toArticle(WriteRequest req) {
		Date now = new Date();
		return	new Article(null,req.getWriter(),
				req.getTitle(), now,now,0);
		
	}//end of write
	
	

}







