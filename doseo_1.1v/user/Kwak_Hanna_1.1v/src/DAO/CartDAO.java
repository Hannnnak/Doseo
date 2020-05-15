package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import VO.CartVO;
import jdbc.connection.ConnectionProvider;

public class CartDAO {
	private CartDAO() {
	}
	
	private static CartDAO instance = new CartDAO();
	
	public static CartDAO getInstance() {
			return instance;
	}
	
	public void insertCart(VO.CartVO cartVO) {
		String sql = "insert into cart(bNo,memberID,pNO,quantity,price,dPrice,pDate)" +
					 " values(bNo.nextval,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cartVO.getbNo());
			pstmt.setString(2, cartVO.getMemberID());
			pstmt.setInt(3, cartVO.getpNO());
			pstmt.setInt(4, cartVO.getQuantity());
			pstmt.setInt(5, cartVO.getPrice());
			pstmt.setInt(6, cartVO.getdPrice());
			pstmt.setString(7, cartVO.getpDate());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.close(conn, pstmt);
		}
	}
	
	public ArrayList<CartVO> listCart(String userId) {
		ArrayList<CartVO> cartList = new ArrayList<CartVO>();
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
				CartVO cartVO = new CartVO();
				cartVO.setbNo(rs.getInt(1));
				cartVO.setMemberID(rs.getString(2));
				cartVO.setpNO(rs.getInt(3));
				cartVO.setQuantity(rs.getInt(4));
				cartVO.setPrice(rs.getInt(5));
				cartVO.setdPrice(rs.getInt(6));
				cartVO.setpDate(rs.getString(7));
				cartList.add(cartVO);
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