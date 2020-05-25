package cart.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import auth.service.User;
import cart.DAO.CartDAO;
import cart.MODEL.Cart;
import cart.MODEL.FromCartSelectMemberID;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import order.MODEL.AddressList;

public class CartService {
	private CartDAO cartDAO = new CartDAO();
	
	public void changeQuantity(int bNo, int quantity) {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Cart cart = cartDAO.selectByBNo(conn, bNo);
			if(cart == null) {
				throw new ProductNotFoundException();
			}
			cart.setQuantity(quantity);
			CartDAO.update(conn, bNo);
			conn.commit();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}

	public ArrayList<FromCartSelectMemberID> selectCartService(String memberID) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			ArrayList<FromCartSelectMemberID> cartList = new ArrayList<FromCartSelectMemberID>();
			cartList = CartDAO.selectCart(conn, memberID);
			conn.commit();
			return cartList;
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}
	
	public ArrayList<AddressList> addressList (String memberID) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			ArrayList<AddressList> addressList = new ArrayList<AddressList>();
			addressList = CartDAO.selectAddress(conn, memberID);
			conn.commit();
			return addressList;
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}

	public void insertCart(int pno, int count, String id) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			CartDAO.insertCart(conn, pno,count,id);
			conn.commit();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}

	public String selectUser(String memberID) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			String phone=CartDAO.selectUser(conn, memberID);
			
			conn.commit();
			
			return phone;
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}
}
 