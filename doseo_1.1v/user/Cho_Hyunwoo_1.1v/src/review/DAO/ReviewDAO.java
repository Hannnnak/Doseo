package review.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jdbc.JdbcUtil;
import review.MODEL.Review;
import review.MODEL.Writer;

public class ReviewDAO {

	public Review insert(Connection conn, Review review) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("	insert into review "
					+ "	(memberId, name, rTitle, rDate, mDate, rCnt) "
					+ "	values (?,?,?,?,?,0)	");
			pstmt.setString(1, review.getWriter().getId());
			pstmt.setString(2, review.getWriter().getName());
			pstmt.setString(3, review.getTitle());
			pstmt.setTimestamp(4, toTimestamp(review.getRegDate()));
			pstmt.setTimestamp(5, toTimestamp(review.getModifiedDate()));
			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select last_insert_id() from review");
				if (rs.next()) {
					Integer newNo = rs.getInt(1);
					return new Review(newNo,
							review.getWriter(),
							review.getTitle(),
							review.getRegDate(),
							review.getModifiedDate(),
							0);
				}
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}

	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from review");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public List<Review> select(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("	select * from review " +
					"	order by rNo desc limit ?, ?	");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			List<Review> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertReview(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Review convertReview(ResultSet rs) throws SQLException {
		return new Review(rs.getInt("rNo"),
				new Writer(
						rs.getString("memberId"),
						rs.getString("name")),
				rs.getString("rTitle"),
				toDate(rs.getTimestamp("rDate")),
				toDate(rs.getTimestamp("mDate")),
				rs.getInt("rCnt"));
	}

	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	
	public Review selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from review where rNo = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			Review review = null;
			if (rs.next()) {
				review = convertReview(rs);
			}
			return review;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public void increaseReadCount(Connection conn, int no) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"	update review set rCnt = rCnt + 1 "+
						"	where rNo = ?	")) {
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}
	}
	
	public int update(Connection conn, int no, String title) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"	update review set rTitle = ?, mDate = now() "+
						"	where rNo = ?	")) {
			pstmt.setString(1, title);
			pstmt.setInt(2, no);
			return pstmt.executeUpdate();
		}
	}
}
