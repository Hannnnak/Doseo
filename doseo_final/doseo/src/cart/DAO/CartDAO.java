package cart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import auth.service.User;
import cart.MODEL.Cart;
import cart.MODEL.FromCartSelectMemberID;
import cart.MODEL.SelectAddress;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import order.MODEL.AddressList;

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
		String sql = "update cart set quantity=? WHERE bNo=?";
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

	public static ArrayList<FromCartSelectMemberID> selectCart(Connection conn, String memberID) {
		ArrayList<FromCartSelectMemberID> cartList = new ArrayList<FromCartSelectMemberID>();
		String sql = "select c.bNo, c.memberId, p.pName, c.price, c.dPrice, c.quantity "
				+ "from cart c join product p on c.pNO = p.pNO where c.memberId=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FromCartSelectMemberID fromCartSelectMemberID = new FromCartSelectMemberID();
				fromCartSelectMemberID.setbNo(rs.getInt(1));
				fromCartSelectMemberID.setMemberID(rs.getString(2));
				fromCartSelectMemberID.setpName(rs.getString(3));
				fromCartSelectMemberID.setPrice(rs.getInt(4));
				fromCartSelectMemberID.setdPrice(rs.getInt(5));
				fromCartSelectMemberID.setQuantity(rs.getInt(6));
				cartList.add(fromCartSelectMemberID);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionProvider.close(conn, pstmt, rs);
		}
		return cartList;
	}

	public static ArrayList<AddressList> selectAddress(Connection conn, String memberID) {
		ArrayList<AddressList> chooseAddressList = new ArrayList<AddressList>();
		/* String sql = "select m.name, m.phone1, m.phone2, m.phone3, m.address "
				+ "from cart c join member m on m.memberId=c.memberId where c.memberId=?"; */
		String sql = "select a.aNo, a.memberId, a.wAddress "
				+ "from addresslist a join member m on m.memberId=a.memberId where a.memberId=? order by aNo asc";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AddressList addressList = new AddressList();
				addressList.setaNo(rs.getInt(1));
				addressList.setMemberID(rs.getString(2));
				addressList.setwAddress(rs.getString(3));
				chooseAddressList.add(addressList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionProvider.close(conn, pstmt, rs);
		}
		return chooseAddressList;
	}

	public static void insertCart(Connection conn, int pno, int count,String id) throws SQLException {
		String sql = "select pPrice,(pPrice*(100-discount)/100) dPrice from product where pNo=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pno);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			int pPrice=rs.getInt(1);
			int dPrice=rs.getInt(2);
			
			String sql2 = "INSERT INTO cart (memberID,pNo,quantity,price,dPrice)" + 
					" VALUES (?,?,?,?,?);";
			
			PreparedStatement pstmt2 = null;
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setString(1, id);
			pstmt2.setInt(2, pno);
			pstmt2.setInt(3, count);
			pstmt2.setInt(4, pPrice);
			pstmt2.setInt(5, dPrice);
			pstmt2.executeUpdate();
			
		}
			
		
			
	}

	public static String selectUser(Connection conn, String memberID) throws SQLException {
	
		String sql = "select phone1,phone2,phone3 from member where memberID=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberID);
		System.out.println(pstmt);
		rs = pstmt.executeQuery();
		String phone="";
		if(rs.next()) {
			String phone1=rs.getString(1);
			String phone2=rs.getString(2);
			String phone3=rs.getString(3);
			phone=phone1+"-"+phone2+"-"+phone3;
		
		}
		return phone;
	}	
}