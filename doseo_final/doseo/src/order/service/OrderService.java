package order.service;

import java.sql.Connection;
import java.sql.SQLException;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import order.DAO.OrderDAO;
import order.MODEL.Order;

public class OrderService {
	private OrderDAO orderDAO = new OrderDAO();
	
	public void changeQuantity(int bNo, int quantity) {
		Connection conn = null;
		
	}
}
