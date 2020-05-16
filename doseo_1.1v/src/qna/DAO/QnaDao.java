package qna.DAO;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import qna.MODEL.Qna;
import qna.MODEL.Writer;
import jdbc.JdbcUtil;

public class QnaDao {
	
	public int selectCount(Connection conn) throws SQLException {
		System.out.println("전체게시물수 구하기 ArticleDAO-selectCount()호출성공");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select  count(*) "+
						 "	from  Qna";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {//등록된 게시글이 존재하면
				return rs.getInt(1); //전체 게시물수가 리턴
			}
			return 0; //등록된 게시글이 존재x하면  0을 리턴
			
	  }finally {
		JdbcUtil.close(rs);  
		JdbcUtil.close(pstmt);
	  }
	  
	}//end of selectCount	
	
	
	public List<Qna> select(Connection conn,
			int startRow,int size)  
			throws SQLException {
		System.out.println("ArticleDAO의 select(startRow,size)="
			                +startRow+"/"+size);
		PreparedStatement pstmt = null;
		ResultSet rs   = null;
		try {
			String sql = 
			"select	qNo,memberID, " + 
			"		qTitle,qContents,qDate,read_cnt " + 
			" from  Qna " +
			" order by qNo desc "+
			" limit ?, ?";
		//limit  0부터시작행번호, 읽어올레코드수
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,startRow); //시작행번호
			pstmt.setInt(2,size); //읽어올레코드수
			rs = pstmt.executeQuery();
			List<Qna> result = new ArrayList<>();
			while( rs.next() ) {
				result.add(convertQna(rs));
			}
			return result;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}	
	}
	
	//select쿼리문 결과를 받아서  Atricle클래스타입으로 묶어주는 함수 p647 36
	private Qna convertQna(ResultSet rs) 
	    throws SQLException{
		System.out.println("qnaDAO의  convertqna()");
		
		return new Qna(rs.getInt("qNo"),
				new Writer(
						rs.getString("memberID"),
						rs.getString("name")),
				rs.getString("qTitle"),
				rs.getString("qContents"),
				toDate(rs.getTimestamp("qDate")),
				rs.getInt("readCount"));
	}
	//Timestamp타입을 Date타입으로 변환 p648 47
	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	public Qna insert(Connection conn,Qna qna) throws SQLException {
		
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String sql = 
					"insert into QnA(memberID,qTitle,qContents,qDate,read_cnt) " +
					" values(?,?,?,?,0)";
			
			pstmt = conn.prepareStatement(sql);
			Writer writer=qna.getWriter();
			String id 	= writer.getmemberID();
//			String name 	= writer.getName();
										
			pstmt.setString(1,id);
			pstmt.setString(2,qna.getqTitle());
			pstmt.setString(3,qna.getqContents());
			pstmt.setTimestamp(4,toTimestamp(qna.getqDate()));
			int insertedCount = pstmt.executeUpdate();
			//p635 31
			if(insertedCount>0) { //insert성공시
				//insert시 들어갔던 article_no컬럼을 값을 가져오자
				//그래야지 article_content컬럼에
				//insert할 때 사용할 수 있다
				stmt = conn.createStatement();
				rs   = stmt.executeQuery("select last_insert_id()  "
						+ " from QnA");
				if(rs.next()) {
					int newNum = rs.getInt(1);
					return new Qna(newNum,
							qna.getWriter(),
							qna.getqTitle(),
							qna.getqContents(),
							qna.getqDate(),
							0);
				}
			}
			return null; //insert 실패시
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
	
	
	
	
//Date타입을 Timestamp타입으로 변환
	private   Timestamp toTimestamp(Date date) {
		return new  Timestamp(date.getTime());
	}


	//article테이블의 특정글번호 조회수 증가	 p656 20
		public void incrementReadCount(Connection conn, 
				int articleNum) throws SQLException{
			try {
				String sql = 
					"update article " + 
					" set   read_cnt=read_cnt+1 " + 
					" where article_no=?";
				PreparedStatement pstmt =
					conn.prepareStatement(sql);
				pstmt.setInt(1, articleNum);
				pstmt.executeUpdate();
			}finally {
				
			}
			
		}
		
		//P655 1
		//article테이블의 특정글번호 조회
		public Qna selectByID(Connection conn, int articleNum) 
			throws SQLException {
			System.out.println("ArticleDAO의 selectByID(articleNum)="
				                +articleNum);
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql = 
				"select	article_no,writer_id,writer_name, " + 
				"		title,regdate,moddate, read_cnt " + 
				" from  article " +
				" where article_no=?";
				pstmt =	conn.prepareStatement(sql);
				pstmt.setInt(1, articleNum);
				rs = pstmt.executeQuery();//p655 8
				
				Qna qna = null;
				if(rs.next()) {
					qna = convertQna(rs);
				}
				return qna;
			}finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}

	}
