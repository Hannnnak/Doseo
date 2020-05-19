package cart.service;

import java.sql.Connection;
import java.sql.SQLException;

import cart.DAO.CartDAO;
import cart.MODEL.Cart;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class CartService {
	private CartDAO cartDAO = new CartDAO();
	
	public void changeQuantity(int selectBNo, int curQuantity, int newQuantity) {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Cart cart = cartDAO.selectByBNo(conn, selectBNo);
			if(cart == null) {
				throw new ProductNotFoundException();
			}
			cart.setQuantity(newQuantity);
			CartDAO.update(conn, selectBNo);
			conn.commit();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}
	
	
}
 