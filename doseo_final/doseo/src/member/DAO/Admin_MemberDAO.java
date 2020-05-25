package member.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jdbc.JdbcUtil;
import member.MODEL.Member;


public class Admin_MemberDAO {

	//전체 회원 수 구하기
	public int selectCount(Connection conn) throws SQLException {
		System.out.println("전체회원수 구하기 Admin_MemberDAO-selectCount()호출성공");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select  count(*) "+
						 "	from  member";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {//등록된 회원이 존재하면
				return rs.getInt(1); //전체 회원수가 리턴
			}
			return 0; //등록된 회원이 존재하지 않으면  0을 리턴
			
	  }finally {
		JdbcUtil.close(rs);  
		JdbcUtil.close(pstmt);
	  }
	  
	}//end of selectCount
	
	public List<Member> select(Connection conn,
			int startRow,int size)  
			throws SQLException {
		System.out.println("Admin_MemberDAO의 select(startRow,size)="
			                +startRow+"/"+size);
		PreparedStatement pstmt = null;
		ResultSet rs   = null;
		try {
			String sql = 
			"SELECT  memberid, memberpw, name, gender, birth, enrolldate, phone1, phone2, phone3, email, favorite1, favorite2, favorite3, address " + 
			" from  member " +
			" limit ?, ?";
		//limit  0부터시작행번호, 읽어올레코드수
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,startRow); //시작행번호
			pstmt.setInt(2,size); //읽어올레코드수
			rs = pstmt.executeQuery();
			List<Member> result = new ArrayList<>();
			while( rs.next() ) {
				result.add(convertArticle(rs));
			}
			return result;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}	
	}
	

	//select쿼리문 결과를 받아서  Member클래스타입으로 묶어주는 함수 p647 36
	private Member convertArticle(ResultSet rs) 
	    throws SQLException{
		System.out.println("Admin_MemberDAO의  convertArticle()");
		
		return new Member(rs.getString("memberid"),
						  rs.getString("memberpw"),
						  rs.getString("name"),
						  rs.getString("gender"),
						  rs.getString("birth"),
						  toDate1(rs.getTimestamp("enrolldate")),
						  rs.getString("phone1"),
						  rs.getString("phone2"),
						  rs.getString("phone3"),
						  rs.getString("email"),
						  rs.getString("favorite1"),
						  rs.getString("favorite2"),
						  rs.getString("favorite3"),
						  rs.getString("address"));
	}

	//Timestamp타입을 Date타입으로 변환 p648 47
	private Date toDate1(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	
	
	
	
	//회원정보 검색
	public void finddate(Connection conn, Member member)
			throws SQLException {
		System.out.println("MemberDAO-finddate()호출");
		String sql = "SELECT * from member " + 
				"	  WHERE memberid = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.executeUpdate();
	}
	
	
	//회원삭제 delete
	
	
	
	
	
}







