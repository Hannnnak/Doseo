package review.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import review.DAO.ReviewDAO;
import review.MODEL.Review;

public class ListReviewService {

	private ReviewDAO reviewDao = new ReviewDAO();
	private int size = 10;

	public ReviewPage getReviewPage(int pageNum) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = reviewDao.selectCount(conn);
			List<Review> content = reviewDao.select(
					conn, (pageNum - 1) * size, size);
			return new ReviewPage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
