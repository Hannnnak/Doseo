package member.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.JdbcUtil;
import member.MODEL.Member;

public class MemberDAO {
	
	
	public Member selectById(Connection conn, String id) 
			throws SQLException {
		System.out.println("MemberDAO-selectById(id)호출="+id);
		
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		Member member = null;
		
		String sql = "SELECT  memberId,memberPw,name,gender,birth,enrollDate,phone,email,favorite,address " + 
					 " FROM doseo.member " + 
					 "	WHERE memberId=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {  //유저가 입력한 id인 회원이 존재하는 경우
				String memberId = rs.getString("memberId");
				String memberPw = rs.getString("memberPw");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String birth = rs.getString("birth");
				String enrollDate = rs.getString("enrollDate");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String favorite = rs.getString("favorite");
				String address = rs.getString("address");
				
				member = new Member(memberId,memberPw,name,gender,birth,enrollDate,phone,email,favorite,address);	
			}
			
			System.out.println("00="+member);
			return member;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	
	
	
	public void insert(Connection conn,Member member)
			throws SQLException {
			System.out.println("MemberDAO-insert()호출");
			String sql = "INSERT INTO doseo.member(memberId,memberPw,name,gender,birth,enrollDate,phone,email,favorite,address) " + 
					     " VALUES(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,member.getMemberId());
			pstmt.setString(2,member.getMemberPw());
			pstmt.setString(3,member.getName());
			pstmt.setString(4,member.getGender());
			pstmt.setString(5,member.getBirth());
			pstmt.setString(6,member.getEnrollDate());
			pstmt.setString(7,member.getPhone());
			pstmt.setString(8,member.getEmail());
			pstmt.setString(9,member.getFavorite());
			pstmt.setString(10,member.getAddress());
			pstmt.executeUpdate();
		}	
	

	
	
	public Member select(Connection conn, String memberId) 
			throws SQLException {
			System.out.println("MemberDAO의 select()="+memberId);
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
			String sql = 
			"select	* " + 
			" from  doseo.member " +
			" where memberId=?";
			pstmt =	conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			Member member = null;	
			if(rs.next()) {
				member = convertMember(rs);
			}
			return member;
			}finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}




	private Member convertMember(ResultSet rs) 
	    throws SQLException{
		System.out.println("MemberDAO의  convertMember()");
		
		return new Member(rs.getString("memberId"),
				rs.getString("memberPw"),
				rs.getString("name"),
				rs.getString("gender"),
				rs.getString("birth"),
				rs.getString("enrollDate"),
				rs.getString("phone"),
				rs.getString("email"),
				rs.getString("favorite"),
				rs.getString("address"));
	}
	
	
	
	
	
	
	
	

}