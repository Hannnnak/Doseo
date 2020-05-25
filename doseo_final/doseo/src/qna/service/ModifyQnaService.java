package qna.service;

import java.sql.Connection;
import java.sql.SQLException;

import qna.DAO.QnaDao;
import qna.MODEL.Qna;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class ModifyQnaService {
	
	private QnaDao qnaDao = new QnaDao();
	
	public void modify(QnaModifyRequest modReq) {
		Connection conn = null;
		System.out.println("QnaModifyRequest 들어옴 ");
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Qna qna = qnaDao.selectByID(conn, modReq.getqNo());
			if (qna == null) {
				throw new QnaNotFoundException();
			}
			qnaDao.update(conn, modReq.getqNo(), modReq.getqTitle(), modReq.getqContents());
			System.out.println("eeeeeeeeeeeeeeeeeeeeeee   " +modReq.getqTitle());
			conn.commit();
			
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException();
		}catch(PermissionDeniedException e) {
			JdbcUtil.rollback(conn);
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
	}//end of modify
	
}