package article.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import article.MODEL.ArticleContent;
import jdbc.JdbcUtil;

//P636
//article_content테이블과 연동하는  DAO
public class ArticleContentDAO {

	//p665 1
	//글 수정
	public int  update(Connection conn,String content,int no) 
		throws SQLException{
		System.out.println("글 수정 ArticleContentDAO-update(no)="+no);
		PreparedStatement pstmt = null;
		try {
			String sql=
				"update article_content "+
				 " set   content=? "+
				 " where article_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setInt(2, no);
			int cnt = pstmt.executeUpdate();
			//update성공적으로 실행되면 update된 레코드수가 리턴된다
			//여기에서는 pk특정글번호만 update되므로 성공시에는 1이 리턴
			return cnt;
		}finally {
			JdbcUtil.close(pstmt);
		}
	
	}
	
	//글 입력
	public ArticleContent insert(Connection conn, 
			ArticleContent content) throws SQLException {
		System.out.println("ArticleContentDAO- insert(content)="+content);
		
		PreparedStatement stmt = null;
		
		/*insert into article_content(article_no,content)
		values(article_no?,content?);*/
		try {
			String sql =
				"insert into article_content " + 
				" values(?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1,content.getNumber());
			stmt.setString(2,content.getContent() );
			int insertedCount = stmt.executeUpdate();
			
			if(insertedCount>0) { //insert쿼리 실행성공시
				return content;
			}else {
				return null;
			}
			
		}finally {
			JdbcUtil.close(stmt);
		}
	}

	//특정글번호 article_contnet조회 p656 1
	public ArticleContent selectByID(Connection conn, 
			int articleNum)  throws SQLException {
		System.out.println("ArticleContentDAO- selectByID(articleNum)="+articleNum);
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql =
				  "select article_no, content "
				+ "from   article_content "
				+ "where  article_no=?";		  
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,articleNum);
			
			rs = stmt.executeQuery(); //p656 8
			ArticleContent content = null;
			if(rs.next()) {
				content = new ArticleContent(
							rs.getInt("article_no"),
							rs.getString("content"));
				return content;
			}
			return content;
			
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
}






