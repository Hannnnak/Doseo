package qna.service;

import java.sql.Connection; 
import java.sql.SQLException;

import qna.MODEL.Qna;
import qna.DAO.QnaDao;
import jdbc.connection.ConnectionProvider;

public class ReadQnaService {

		private QnaDao qnaDao = new QnaDao();
		
		
		public QnaData getQna(int qNo, boolean incrementReadCount) {
			try (Connection conn = ConnectionProvider.getConnection()) {
				System.out.println(qNo);
				Qna qna = qnaDao.selectByID (conn,qNo);
				
				if(qna == null) {
					throw new QnaNotFoundException();
				}
				if(incrementReadCount) {
					qnaDao.incrementReadCount(conn, qNo);
				}
				
				return new QnaData(qna);
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
			
		}
}
