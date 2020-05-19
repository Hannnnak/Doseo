package cart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import cart.MODEL.Cart;
import jdbc.connection.ConnectionProvider;

public class CartDAO {
	private CartDAO() {
	}
	
	private static CartDAO instance = new CartDAO();
	
	public static CartDAO getInstance() {
			return instance;
	}
	
	public void insertCart(Cart Cart) {
		String sql = "insert into cart(bNo,memberID,pNO,quantity,price,dPrice,pDate)" +
					 " values(bNo.nextval,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Cart.getbNo());
			pstmt.setString(2, Cart.getMemberID());
			pstmt.setInt(3, Cart.getpNO());
			pstmt.setInt(4, Cart.getQuantity());
			pstmt.setInt(5, Cart.getPrice());
			pstmt.setInt(6, Cart.getdPrice());
			pstmt.setString(7, Cart.getpDate());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.close(conn, pstmt);
		}
	}
	
	public ArrayList<Cart> listCart(String userId) {
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		String sql = "select * from cart_view where id=? order by cseq desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setbNo(rs.getInt(1));
				cart.setMemberID(rs.getString(2));
				cart.setpNO(rs.getInt(3));
				cart.setQuantity(rs.getInt(4));
				cart.setPrice(rs.getInt(5));
				cart.setdPrice(rs.getInt(6));
				cart.setpDate(rs.getString(7));
				cartList.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionProvider.close(conn, pstmt, rs);
		}
		return cartList;
		}
	
	public void deleteCart(int cseq) {
		String sql = "delete cart where cseq=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cseq);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.close(conn, pstmt);
		}
	}
}