package order.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import cart.MODEL.Cart;
import jdbc.connection.ConnectionProvider;
import order.MODEL.OrderList;

public class OrderDAO {
	private OrderDAO() {
	}
	
	private static OrderDAO instance = new OrderDAO();
	
	public static OrderDAO getInstance() {
		return instance;
	}

	public int insertOrder(ArrayList<Cart> cartList, String id) {
		int maxoNo = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		
		try {
			conn = ConnectionProvider.getConnection();
			String sql = "insert into OrderList(oNo, memberID, bNo, address, requests) values(oNo.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				maxoNo = rs.getInt(1);
			}
			pstmt.close();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			for (Cart cart : cartList) {
				insertOrderDetail(cart, maxoNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.close(conn, pstmt);
		}
		return maxoNo;
	}
	
	public void insertOrderDetail(Cart cart, int maxoNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionProvider.getConnection();
			String insertOrderDetail = "insert into Odetail(oNo, dpNo, " +
										"pNO, dPrice, quantity, total) values(?, dpNo.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(insertOrderDetail);
			pstmt.setInt(1, maxoNo);
			pstmt.setInt(2, cart.getbNo());
			pstmt.setString(3, cart.getMemberID());
			pstmt.setInt(4, cart.getpNO());
			pstmt.setInt(5, cart.getQuantity());
			pstmt.setInt(6, cart.getPrice());
			pstmt.setInt(7, cart.getdPrice());
			pstmt.setString(8, cart.getpDate());
			pstmt.executeUpdate();
			pstmt.close();
			
			String updateCartResult = "update cart set result=2 where cseq=?";
			pstmt = conn.prepareStatement(updateCartResult);
			pstmt.setInt(1, cart.getQuantity());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.close(conn, pstmt);
		}
	}
	
	public ArrayList<OrderList> listOrderById(String id, String result, int oseq) {
		ArrayList<OrderList> orderList = new ArrayList<OrderList>();
		String sql = "select * from order_view where id=? "
					+ "and result like '%'||?||'%' and oseq=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, result);
			pstmt.setInt(3, oseq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderList order = new OrderList();
				order.setoNo(rs.getInt("oNo"));
				order.setMemberID(rs.getString("memberID"));
				order.setbNo(rs.getInt("bNo"));
				order.setOrderDate(rs.getString("orderDate"));
				order.setAddress(rs.getString("address"));
				order.setRequests(rs.getString("requests"));
				orderList.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.close(conn, pstmt, rs);
		}
		return orderList;
		}
	
	public ArrayList<Integer> selectSeqOrderIng(String id) {
		ArrayList<Integer> oseqList = new ArrayList<Integer>();
		String sql = "select distinct oseq from order_view " +
					"where id=? and result='1' order by oseq desc";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				oseqList.add(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.close(con, pstmt, rs);
		}
			return oseqList;
	}
}