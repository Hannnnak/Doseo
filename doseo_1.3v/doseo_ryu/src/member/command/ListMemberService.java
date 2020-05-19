package member.command;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import member.DAO.Admin_MemberDAO;
import member.MODEL.Member;
import member.service.MemberPage;
import jdbc.connection.ConnectionProvider;

//전체목록보기 요청 담당 컨트롤러에서 호출하는 서비스클래스
//p650
//DAO와 연동
public class ListMemberService {

	private Admin_MemberDAO memberDAO = new Admin_MemberDAO();
	private int size = 3; //한 페이지당 출력할 게시글 수
	//한 페이지당 출력할 게시글 수가 10개라면 size는 10
	
	//페이지정보
	public MemberPage getMemberPage(int pageNo) {
		try {
			Connection conn = ConnectionProvider.getConnection();
			
			//전체 게시글수 조회
			int total = memberDAO.selectCount(conn);
			
			//특정페이지에 해당하는 게시글목록 조회
			//select(conn, 시작행번호, 가져올게시글수)
			//시작행번호는 0부터 시작되므로 첫게시글은 -1해야한다
			//보고싶은 페이지(pageNo)가 1이면 첫게시글의 인덱스번호는 0이되어야 한다
			
			List<Member> content = 
				memberDAO.select(conn, (pageNo-1)*size, size);
			
			//페이지정보가 포함된 내용을 리턴을 해줘야 한다
			return new MemberPage(total, pageNo, size, content);
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}







