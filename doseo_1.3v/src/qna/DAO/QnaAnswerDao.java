package qna.DAO;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.SQLException;

import qna.MODEL.QnaAnswer;
import jdbc.JdbcUtil;

public class QnaAnswerDao {
	
	public QnaAnswer insert(Connection conn, QnaAnswer answer)
			throws SQLException {
				PreparedStatement stmt = null;
				try {
					String sql =
						"insert into QnA" +
						"values(?,?)";
					stmt = conn.prepareStatement(sql);
					stmt.setInt(1,answer.getqNo());
					stmt.setString(2,answer.getAnswer() );
					int insertedCount = stmt.executeUpdate();
					
					if(insertedCount>0) { //insert쿼리 실행성공시
						return answer;
					}else {
						return null;
					}
					
				}finally {
					JdbcUtil.close(stmt);
				}
			}
			
		}