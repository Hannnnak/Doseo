package review.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import review.DAO.ReviewContentDAO;
import review.DAO.ReviewDAO;
import review.MODEL.Review;
import review.MODEL.ReviewContent;

public class ReadReviewService {

	private ReviewDAO reviewDao = new ReviewDAO();
	private ReviewContentDAO contentDao = new ReviewContentDAO();
	
	public ReviewData getReview(int reviewNum, boolean increaseReadCount) {
		try (Connection conn = ConnectionProvider.getConnection()){
			Review review = reviewDao.selectById(conn, reviewNum);
			if (review == null) {
				throw new ReviewNotFoundException();
			}
			ReviewContent content = contentDao.selectById(conn, reviewNum);
			if (content == null) {
				throw new ReviewContentNotFoundException();
			}
			if (increaseReadCount) {
				reviewDao.increaseReadCount(conn, reviewNum);
			}
			return new ReviewData(review, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
