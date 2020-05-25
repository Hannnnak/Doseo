package payment.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import cart.MODEL.Cart;
import order.DAO.PaymentDAO;
import order.MODEL.Order;
import payment.MODEL.Payment;

public class paymentDAO {

	public paymentDAO() {
		
	}
	
	private static PaymentDAO instance = new PaymentDAO();
	public static PaymentDAO getInstance() {
		return instance;
	}
	
	//결제정보 출력
	public ArrayList<Payment> paymentSuccessInfos() {
		ArrayList<Payment> paymentSuccessList = new ArrayList<Payment>();
		String sql = "SELECT p.pName, c.price, c.dPrice, o.oNo, o.orderDate, c.bNo, c.quantity, o.address, o.requests "
				+ "FROM cart c INNER JOIN orderList o on c.bNo=o.bNo "
				+ "INNER JOIN product p ON p.pNo=c.pNo where c.memberId=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		
		
		return paymentSuccessList;
	}


	//주문 컬럼 삽입
	public void insertOrder(Connection conn, String memberID, String address, String requests) throws SQLException {
		//HttpSession session = request.getSession();	    
		//User user = (User)session.getAttribute("AUTHUSER");
		//String memberID = user.getId();
		
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO orderList (memberID,address,requests)" + 
				"VALUES (?,?,?);";
		
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, memberID);
        pstmt.setString(2, address);
        pstmt.setString(3, requests);
        
        pstmt.executeUpdate();
		
		
	}

	public Order selectOrder(Connection conn, String id) throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		
		String sql = "select * from orderList where memberID=?";
		
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        
        rs=pstmt.executeQuery();
        
        if(rs.next()) {
        	
        	Order order=new Order();
        	
        	int ono=rs.getInt(1);
        	String id1=rs.getString(2);
        	Date date=rs.getDate(3);
        	String address=rs.getString(4);
        	String requests=rs.getString(5);
        	
        	order.setoNo(ono);
        	order.setMemberId(id1);
        	order.setOrderDate(date);
        	order.setAddress(address);
        	order.setRequests(requests);
        	
        	return order;
        }
        return null;
	}}
