package cart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import cart.MODEL.Cart;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class CartDAO {
	public CartDAO() {
	}
	
	private static CartDAO instance = new CartDAO();
	
	public static CartDAO getInstance() {
			return instance;
	}
	
	//유저가 수정하려는 장바구니가 존재하는지 확인
	public Cart selectByBNo(Connection conn, int selectBNo) throws SQLException {
		System.out.println("CartDAO의 selectByQuantity(selectBNo)호출="+selectBNo);
		
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		Cart cart = null;
		
		String sql = "SELECT  * " + 
					 " FROM cart " + 
					 " WHERE bNo=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, selectBNo);
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {  				
				int bNo = rs.getInt("bNo");
				String memberID = rs.getString("memberID");
				int pNO = rs.getInt("pNO");
				int quantity = rs.getInt("quantity");
				int price = rs.getInt("price");
				int dPrice = rs.getInt("dPrice");
				String pDate = rs.getString("pDate");
				
				cart = new Cart(bNo, memberID, pNO, quantity, price, dPrice, pDate);	
			}
			return cart;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	//장바구니 추가
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
	
	//장바구니 목록
	public ArrayList<Cart> listCart(int bNo) {
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		String sql = "select * from cart where bNo=? order by cseq desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
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
	
	//장바구니 삭제
	public void deleteCart(int bNo) {
		String sql = "delete cart where bNo=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.close(conn, pstmt);
		}
	}
	
	//장바구니 수정
	public void updateCart(int bNo, int quantity) {
		String sql = "update cart set quantity=?"
				+ " WHERE bNo=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.close(conn, pstmt);
		}
	}

	public static void update(Connection conn, int selectBNo) {
		
	}
}