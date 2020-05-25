package qna.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import qna.DAO.QnaDao;
import qna.MODEL.Qna;

public class DeleteQnaService {
	
	private QnaDao qnaDao = new QnaDao();
	
	public void delete (int qNo) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Qna qna = qnaDao.selectByID(conn, qNo);
			if (qna == null) {
				throw new QnaNotFoundException()	;
			}
			
			qnaDao.delete(conn, qNo);
			
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
