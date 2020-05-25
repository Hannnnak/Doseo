package qna.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import qna.DAO.QnaDao;
import qna.MODEL.Qna;
import jdbc.connection.ConnectionProvider;

public class ListQnaService {
	
		private QnaDao qnaDao = new QnaDao();
		private int size = 10;
		
		public QnaPage getQnaPage(int pageNum) {
			try (Connection conn = ConnectionProvider.getConnection()) {
				int total = qnaDao.selectCount(conn);
				List<Qna> content = qnaDao.select(
						conn, (pageNum - 1) * size, size);
				return new QnaPage(total, pageNum, size, content);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}