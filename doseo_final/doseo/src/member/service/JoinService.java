package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.DAO.MemberDAO;
import member.MODEL.Member;

//p596
//JoinHandler에서  호출
//회원가입기능을 제공 => DAO연동
public class JoinService {

	private MemberDAO memberDao = new MemberDAO();
	
	
	//회원가입처리요청 p596-16  m801-832-38
	//JoinHandler에서  호출
	public void join(JoinRequest joinReq) {
		System.out.println("JoinService-join()호출");
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);//트랜잭션 시작
			
			//p596-22~26 추가예정~~~~~~~~~~~~~~~
			
			Member member = memberDao.selectById(conn, joinReq.getId());
			if(member != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			
			
			//p596-28 
			memberDao.insert(conn,
					new Member( joinReq.getId(), 
							//joinReq.getName(), 
							joinReq.getPassword(), 
							joinReq.getname(),
							joinReq.getGender(),
							joinReq.getBirth(),
							new Date(),
							joinReq.getPhone1(),
							joinReq.getPhone2(),
							joinReq.getPhone3(),
							joinReq.getEmail(),
							joinReq.getFavorite1(),
							joinReq.getFavorite2(),
							joinReq.getFavorite3(),
							joinReq.getAddress()
							)
					);
			
			conn.commit(); //트랙잭션 반영
		}catch(SQLException e) {
			JdbcUtil.rollback(conn); //트랙잭션 취소
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
		
	}//end of join
	
}//end of class






