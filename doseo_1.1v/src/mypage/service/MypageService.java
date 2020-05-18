package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import jdbc.connection.ConnectionProvider;
import member.DAO.MemberDAO;
import member.MODEL.Member;

//MypageHandler에서  호출
//회원가입기능을 제공 => DAO연동
public class MypageService {

	private MemberDAO memberDao = new MemberDAO();
	
	//마이페이지처리요청
	//MypageHandler에서  호출
public Member getMember(String MemberId) {
		
		try {
			Connection conn  =
				ConnectionProvider.getConnection();

			//아이디로 회원정보 가져오기
			Member member = memberDao.selectById(conn, MemberId);
			
			System.out.println("ff="+member);
			
			return member;
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}	
}