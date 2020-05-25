package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import auth.service.LoginFailException;
import auth.service.User;
import jdbc.connection.ConnectionProvider;
import member.DAO.MemberDAO;
import member.MODEL.Member;

//MypageHandler에서  호출
//마이페이지기능 제공 => DAO연동
public class DeleteService {

	private MemberDAO memberDao = new MemberDAO();
	
	//마이페이지처리요청
	//MypageHandler에서  호출
	public void deleteMember(String id, String password) {
		
		try {
			Connection conn = ConnectionProvider.getConnection();

			//아이디로 회원정보 가져오기
			Member member = memberDao.selectById(conn, id);
			
			if(member==null) { //회원으로 존재x=>비회원 
				throw new LoginFailException();
			}
			
			//비밀번호 불일치
			if( !member.matchPassword(password) ) {
				throw new LoginFailException();
			}
			
			memberDao.deleteById(conn, id);
			
			System.out.println("deleteMember="+member.getId());
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}	
}