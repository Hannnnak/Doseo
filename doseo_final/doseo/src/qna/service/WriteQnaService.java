package qna.service;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.Date;

import qna.DAO.QnaDao;
import qna.MODEL.Qna;
import qna.service.WriteRequest;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;




public class WriteQnaService {
	private QnaDao qnaDao = new QnaDao();
	
//	private QnaContentDao contentDao = new QnaContentDao();
	
	public int write(WriteRequest req) {
		System.out.println("WriteQnaService클래스 write()호출 req="+req);
		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false); //트랜잭션시작
		
			Qna qna = toQna(req);
			
			Qna savedQna = qnaDao.insert(conn,qna);
			
			if(savedQna==null) {
				throw new RuntimeException("fail to insert Qna");
			}
			
//			QnaContent qContents = 
//					new QnaContent(savedQna.getqNo(),
//							req.getqContents());
			
//			QnaContent savedContent = 
//					contentDao.insert(conn,qContents);
//			if(savedContent==null) { //article_content테이블의 insert실패시
//				throw new RuntimeException("qna_contents 테이블에 insert실패");
//			}
//			
			conn.commit(); //트랜잭션반영
			
			return savedQna.getqNo();//p639 40
			
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}catch(RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		}
	}
			
			
			
			private Qna toQna(WriteRequest req) {
				Date now = new Date();
				return	new Qna(0,
						req.getWriter(),
						req.getqTitle(),
						req.getqContents(), 
						now,
						0);				

			}
}
