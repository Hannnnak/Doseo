package review.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import review.DAO.ReviewContentDAO;
import review.DAO.ReviewDAO;
import review.MODEL.Review;
import review.MODEL.ReviewContent;

public class WriteReviewService {

	private ReviewDAO reviewDao = new ReviewDAO();
	private ReviewContentDAO contentDao = new ReviewContentDAO();

	public Integer write(WriteRequest req) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			Review review = toReview(req);
			Review savedReview = reviewDao.insert(conn, review);
			if (savedReview == null) {
				throw new RuntimeException("fail to insert review");
			}
			ReviewContent content = new ReviewContent(
					savedReview.getNumber(),
					req.getContent());
			ReviewContent savedContent = contentDao.insert(conn, content);
			if (savedContent == null) {
				throw new RuntimeException("fail to insert review_content");
			}

			conn.commit();

			return savedReview.getNumber();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private Review toReview(WriteRequest req) {
		Date now = new Date();
		return new Review(null, req.getWriter(), req.getTitle(), now, now, 0);
	}
}
