package order.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import order.MODEL.Order;

public class OrderDAO {

	public Order selectById2(Connection conn, String id) 
			throws SQLException {
		System.out.println("MemberDAO-selectById2(id)호출="+id);
		
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		Order order = null;
		
		String sql = "select oNo,memberId,bNo,orderDate,address,requests " + 
					 " from doseo.orderlist " + 
					 " where memberId=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {  //유저가 입력한 id인 회원이 존재하는 경우
				String oNo = rs.getString("oNo");
				String memberId = rs.getString("memberId");
				String bNo = rs.getString("bNo");
				String orderDate = rs.getString("orderDate");
				String address = rs.getString("address");
				String requests = rs.getString("requests");
				
				order = new Order(oNo,memberId,bNo,orderDate,address,requests);	
			}
			
			System.out.println("selectById2="+order);
			return order;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
}
