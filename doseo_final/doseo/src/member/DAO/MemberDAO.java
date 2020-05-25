package member.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.MODEL.Member;
//import member.service.JoinRequest;

//p592
//Mysql의  board데이터베이스의 member테이블에 쿼리
//LoginService, JoinService에서 호출되는 함수를 선언
public class MemberDAO {

	//유저가 입력한 id를 가진 회원이 존재하는 확인
	//회원으로 존재하면 회원정보가 Member객체로 리턴
	//회원으로 존재x  회원정보가 Member객체가 null리턴
	/*SELECT  memberid, name, password, regdate
		FROM 	member
		WHERE	memberid=?;*/
	//p593
	public Member selectById(Connection conn, String id) 
			throws SQLException {
		System.out.println("MemberDAO-selectById(id)호출="+id);
		
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		Member member = null;
		
		String sql = "SELECT  memberid, memberpw, name, gender, birth, enrolldate, phone1, phone2, phone3, email, favorite1, favorite2, favorite3, address " + 
					 "	FROM 	member " + 
					 "	WHERE	memberid=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {  //유저가 입력한 id인 회원이 존재하는 경우
				//교재p592 25~ p593 29
				/*member = new Member(rs.getString("memberid"),
						rs.getString("name"),
						rs.getString("password"),
						toDate(rs.getTimestamp("regdate"));*/
				
				String memberid = rs.getString("memberid");
				String memberpw = rs.getString("memberpw");
				String name     = rs.getString("name");
				String gender	= rs.getString("gender");
				String birth	= rs.getString("birth");
				Date enrolldate = toDate(rs.getTimestamp("enrolldate"));
				String phone1	= rs.getString("phone1");
				String phone2	= rs.getString("phone2");
				String phone3	= rs.getString("phone3");
				String email	= rs.getString("email");
				String favorite1= rs.getString("favorite1");
				String favorite2= rs.getString("favorite2");
				String favorite3= rs.getString("favorite3");
				String address	= rs.getString("address");
				
				member = new Member(memberid, memberpw, name, gender, birth, enrolldate, phone1, phone2, phone3, email, favorite1, favorite2, favorite3, address);	
			}
			return member;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}//end of selectById()
		
		
	//p593 38
	//Timestamp타입의 데이터를   Date타입으로 변경
	private Date toDate(Timestamp date) {
		return  date==null? null: new Date(date.getTime());
	}




	//회원가입 p593-42
	/*INSERT INTO member(memberid,name,password,regdate)
		VALUES(memberid?,name?,password?,regdate?)*/
	public void  insert(Connection conn,Member mem)
		throws SQLException {
		System.out.println("MemberDAO-insert()호출");
		String sql = "INSERT INTO member(memberid, memberpw, name, gender, birth, enrolldate, phone1, phone2, phone3, email, favorite1, favorite2, favorite3, address) " + 
				     " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,mem.getId());
		pstmt.setString(2,mem.getPassword());
		pstmt.setString(3,mem.getName());
		pstmt.setString(4,mem.getGender());
		pstmt.setString(5,mem.getBirth());
		pstmt.setTimestamp(6, new Timestamp(mem.getRegDate().getTime() ) );
		pstmt.setString(7,mem.getPhone1());
		pstmt.setString(8,mem.getPhone2());
		pstmt.setString(9,mem.getPhone3());
		pstmt.setString(10,mem.getEmail());
		pstmt.setString(11,mem.getFavorite1());
		pstmt.setString(12,mem.getFavorite2());
		pstmt.setString(13,mem.getFavorite3());
		pstmt.setString(14,mem.getAddress());
		pstmt.executeUpdate();
	}

	//p620 17
	public void update(Connection conn, Member member)
			throws SQLException {
		System.out.println("MemberDAO-update()호출");
		String sql = "UPDATE  member " + 
				"	  SET	  name=?, memberpw = ? " + 
				"	  WHERE   memberid = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getName());
		pstmt.setString(2, member.getPassword());
		pstmt.setString(3, member.getId());
		pstmt.executeUpdate();
	}
	
	
	public void  update2(Connection conn,Member mem)
			throws SQLException {
			System.out.println("MemberDAO-insert()호출");
			String sql = "UPDATE  member " + 
					"	  SET	  name=?,gender=?,birth=?,phone1=?,phone2=?,phone3=?,email=?,favorite1=?,favorite2=?,favorite3=?,address=? " + 
					"	  WHERE   memberid = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1,mem.getId());
//			pstmt.setString(2,mem.getPassword());
			pstmt.setString(1,mem.getName());
			pstmt.setString(2,mem.getGender());
			pstmt.setString(3,mem.getBirth());
//			pstmt.setTimestamp(6, new Timestamp(mem.getRegDate().getTime() ) );
			pstmt.setString(4,mem.getPhone1());
			pstmt.setString(5,mem.getPhone2());
			pstmt.setString(6,mem.getPhone3());
			pstmt.setString(7,mem.getEmail());
			pstmt.setString(8,mem.getFavorite1());
			pstmt.setString(9,mem.getFavorite2());
			pstmt.setString(10,mem.getFavorite3());
			pstmt.setString(11,mem.getAddress());
			pstmt.setString(12,mem.getId());
			pstmt.executeUpdate();
		}
	
	public void deleteById(Connection conn, String memberId)
			throws SQLException{
			System.out.println("MemberDAO-deleteById()호출");
			String sql = "delete from member " + 
						"where memberId=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,memberId);
			pstmt.executeUpdate();
		}


	
	public Member findId(Connection conn, String name, String email) 
			throws SQLException {
		System.out.println("MemberDAO-findId(name, email)호출="+name+email);
	
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		Member member = null;
		String sql = "select memberid from member " +
					 "where name = ? and email = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//유저가 입력한 id인 회원이 존재하는 경우
				//교재p592 25~ p593 29
				/*member = new Member(rs.getString("memberid"),
						rs.getString("name"),
						rs.getString("password"),
						toDate(rs.getTimestamp("regdate"));*/
				
				String memberid = rs.getString("memberid");
				member = new Member(memberid);	
			}
			return member;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}//end of findId()
	
	
	//-------------------
	
	//---------------------------------------
	public String findPw(Connection conn, String name, String email, String id) 
			throws SQLException {
		System.out.println("MemberDAO-findPw(name, email, id)호출="+name+email+id);
	
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		String memberpw = null;
		
		String sql = "select memberpw from member " +
					 "where name = ? and email = ? and memberid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, id);
			System.out.println(pstmt);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				System.out.println("진행확인if1");
				//유저가 입력한 id인 회원이 존재하는 경우
				//교재p592 25~ p593 29
				/*member = new Member(rs.getString("memberid"),
						rs.getString("name"),
						rs.getString("password"),
						toDate(rs.getTimestamp("regdate"));*/
				
				memberpw = rs.getString("memberpw");
				System.out.println("rs.getString(memberpw) = " + rs.getString("memberpw"));
			}
			return memberpw;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}//end of String findPw ()
	
	
	
}







