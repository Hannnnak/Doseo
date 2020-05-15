package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import VO.CartVO;
import jdbc.connection.ConnectionProvider;

public class OrderDAO {
	private OrderDAO() {
	}
	
	private static OrderDAO instance = new OrderDAO();
	
	public static OrderDAO getInstance() {
		return instance;
	}

	public int insertOrder(ArrayList<CartVO> cartList, String id) {;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		
		try {
			conn = ConnectionProvider.getConnection();
			String sql = "insert into orders(oseq, id) values(" +
					 "orders_seq.nextval, ?)";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				maxOseq = rs.getInt(1);
			}
			pstmt.close();
			
			pstmt = conn.prepareStatement(insertOrder);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			for (CartVO cartVO : cartList) {
				insertOrderDetail(cartVO, maxOseq);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.close(conn, pstmt);
		}
		return maxOseq;
	}
	
	public void insertOrderDetail(CartVO cartVO, int maxOseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionProvider.getConnection();
			String insertOrderDetail = "insert into order_detail(odseq, oseq, " +
										"pseq, quantity) values(order_detail_seq.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(insertOrderDetail);
			pstmt.setInt(1, maxOseq);
			pstmt.setInt(2, cartVO.getPseq());
			pstmt.setInt(3, cartVO.getQuantity());
			pstmt.executeUpdate();
			pstmt.close();
			String updateCartResult = "update cart set result=2 where cseq=?";
			pstmt = conn.prepareStatement(updateCartResult);
			pstmt.setInt(1, cartVO.getCseq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionProvider.close(conn, pstmt);
		}
	}
	
	public ArrayList<OrderVO> listOrderById(String id, String result, int oseq) {
		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
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
				OrderVO orderVO = new OrderVO();
				orderVO.setOdseq(rs.getInt("ODSEQ"));
				orderVO.setOseq(rs.getInt("OSEQ"));
				orderVO.setId(rs.getString("ID"));
				orderVO.setIndate(rs.getTimestamp("INDATE"));
				orderVO.setMname(rs.getString("MNAME"));
				orderVO.setZipNum(rs.getString("ZIP_NUM"));
				orderVO.setAddress(rs.getString("ADDRESS"));
				orderVO.setPhone(rs.getString("PHONE"));
				orderVO.setPseq(rs.getInt("PSEQ"));
				orderVO.setQuantity(rs.getInt("QUANTITY"));
				orderVO.setPname(rs.getString("PNAME"));
				orderVO.setPrice2(rs.getInt("PRICE2"));
				orderVO.setResult(rs.getString("RESULT"));
				orderList.add(orderVO);
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