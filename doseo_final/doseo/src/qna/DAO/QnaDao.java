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
		System.out.println(" ArticleDAO-selectCount()");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select  count(*) "+
						 "	from  Qna";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1); 
			}
			return 0; 
			
	  }finally {
		JdbcUtil.close(rs);  
		JdbcUtil.close(pstmt);
	  }
	  
	}//end of selectCount	
	
	
	public List<Qna> select(Connection conn, int startRow,int size)  
			throws SQLException {
		System.out.println("ArticleDAO�쓽 select(startRow,size)="
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
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow); //�떆�옉�뻾踰덊샇
			pstmt.setInt(2, size); //�씫�뼱�삱�젅肄붾뱶�닔
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
	private Qna convertQna(ResultSet rs) 
	    throws SQLException{
		
		return new Qna(rs.getInt("qNo"),
				new Writer(
						rs.getString("memberID")),
//						rs.getString("name")),
				rs.getString("qTitle"),
				rs.getString("qContents"),
				toDate(rs.getTimestamp("qDate")),
				rs.getInt("read_cnt"));
	}
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
			if(insertedCount>0) { //insert�꽦怨듭떆
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
			return null; //insert �떎�뙣�떆
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
	
	
	
	
	private   Timestamp toTimestamp(Date date) {
		return new  Timestamp(date.getTime());
	}


		public void incrementReadCount(Connection conn, 
				int qNo) throws SQLException{
			try {
				String sql = 
					"update Qna " + 
					" set   read_cnt=read_cnt+1 " + 
					" where qNo=?";
				PreparedStatement pstmt =
					conn.prepareStatement(sql);
				pstmt.setInt(1, qNo);
				pstmt.executeUpdate();
			}finally {
				
			}
			
		}
		
		public Qna selectByID(Connection conn, int qNo) 
			throws SQLException {
			System.out.println("QnaDao selectByID(articleNum)="
				                +qNo);
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				String sql = 
				" select	qNo,memberID, " + 
				"		qTitle,qContents,qDate, read_cnt " + 
				"  from  Qna " +
				"  where qNo=?";
				pstmt =	conn.prepareStatement(sql);
				pstmt.setInt(1, qNo);
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
		
		public int update(Connection conn , int qNo, String qTitle, String qContents) throws SQLException{
			try (PreparedStatement pstmt = 
					conn.prepareStatement(
							"update qna set qTitle =?, qContents =?,  moddate = now() "+
							"where qNo = ?")){
				pstmt.setString(1, qTitle);
				pstmt.setString(2, qContents);
				pstmt.setInt(3, qNo);
				return pstmt.executeUpdate();
				}
			}
		
		
		public int delete(Connection conn, int qNo) throws SQLException{
			try (PreparedStatement pstmt = 
					conn.prepareStatement(
							"	delete from qna "+
				        	 "	where qNo = ?	")) {
				pstmt.setInt(1, qNo);
				return pstmt.executeUpdate();
			}
		}
		
		}
