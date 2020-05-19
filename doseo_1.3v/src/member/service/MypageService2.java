package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import order.DAO.OrderDAO;
import order.MODEL.Order;

public class MypageService2 {

	private OrderDAO orderDao = new OrderDAO();
	
	//마이페이지처리요청
	//MypageHandler에서  호출
	public Order getOrder(String MemberId) {
		
		try {
			Connection conn = ConnectionProvider.getConnection();

			//아이디로 회원정보 가져오기
			Order order = orderDao.selectById2(conn, MemberId);
			
			System.out.println("getOrder="+order);
			
			return order;
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
