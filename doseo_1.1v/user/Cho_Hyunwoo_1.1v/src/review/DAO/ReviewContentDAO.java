package review.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import review.MODEL.ReviewContent;

public class ReviewContentDAO {

	public ReviewContent insert(Connection conn, ReviewContent content) 
	throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"	insert into review_content " + 
					"	(rNo, rContents) values (?,?)	");
			pstmt.setLong(1, content.getNumber());
			pstmt.setString(2, content.getContent());
			int insertedCount = pstmt.executeUpdate();
			if (insertedCount > 0) {
				return content;
			} else {
				return null;
			}
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	public ReviewContent selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from review_content where rNo = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			ReviewContent content = null;
			if (rs.next()) {
				content = new ReviewContent(
						rs.getInt("rNo"), rs.getString("rContents"));
			}
			return content;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public int update(Connection conn, int no, String content) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"	update review_content set rContents = ? "+
						"	where rNo = ?	")) {
			pstmt.setString(1, content);
			pstmt.setInt(2, no);
			return pstmt.executeUpdate();
		}
	}
}
