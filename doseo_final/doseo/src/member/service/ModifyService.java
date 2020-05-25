package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.DAO.MemberDAO;
import member.MODEL.Member;

//ModifyHandler에서  호출
//회원정보수정을 제공 => DAO연동
public class ModifyService {

	private MemberDAO memberDao = new MemberDAO();
	
	//마이페이지처리요청
	//MypageHandler에서  호출
	public void modify(ModifyRequest modifyReq) {
		System.out.println("ModifyService-modify()호출");
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);//트랜잭션 시작

			memberDao.update2(conn,
					new Member(
//							modifyReq.getMmemberId(), 
//							modifyReq.getMmemberPw(), 
							modifyReq.getMname(),
							modifyReq.getMgender(), 
							modifyReq.getMbirth(),
//							modifyReq.getMenrollDate(),
							modifyReq.getMphone1(),
							modifyReq.getMphone2(),
							modifyReq.getMphone3(),
							modifyReq.getMemail(),
							modifyReq.getMfavorite1(),
							modifyReq.getMfavorite2(),
							modifyReq.getMfavorite3(),
							modifyReq.getMaddress(),
							modifyReq.getMid()
							)
					);
			conn.commit(); //트랙잭션 반영
		}catch(SQLException e) {
			JdbcUtil.rollback(conn); //트랙잭션 취소
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}	
	}	
}