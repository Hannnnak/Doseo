package payment.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import order.MODEL.Order;
import payment.DAO.paymentDAO;

public class paymentService {
	private paymentDAO paymentDao = new paymentDAO();
	
	public void insertOrder(String memberID,String address,String requests) {
		try {
			Connection conn = ConnectionProvider.getConnection();
			
			paymentDao.insertOrder(conn, memberID,address,requests);
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public Order selectOrder(String id) {
		try {
			Connection conn = ConnectionProvider.getConnection();
			
			Order order=new Order();
			order=paymentDao.selectOrder(conn, id);
			
			return order;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
