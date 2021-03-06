package review.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import review.DAO.ReviewContentDAO;
import review.DAO.ReviewDAO;
import review.MODEL.Review;

public class DeleteReviewService {

	private ReviewDAO reviewDao = new ReviewDAO();
	private ReviewContentDAO contentDao = new ReviewContentDAO();
	
	public void delete(int rNo) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Review review = reviewDao.selectById(conn, rNo);
			if (review == null) {
				throw new ReviewNotFoundException();
			}
			
			reviewDao.delete(conn, rNo);
			contentDao.delete(conn, rNo);
			
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (PermissionDeniedException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
		
	}


}
