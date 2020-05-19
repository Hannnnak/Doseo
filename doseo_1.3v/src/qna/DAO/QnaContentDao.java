package qna.DAO;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.SQLException;

import qna.MODEL.QnaContent;
import jdbc.JdbcUtil;

public class QnaContentDao {

	public QnaContent insert(Connection conn, QnaContent content)
	throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql =
				"insert into QnA" +
				"values(?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,content.getqNo());
			stmt.setString(2,content.getqContents() );
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
	
}
