package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jdbc.JdbcUtil;
import product.model.Product;

//product테이블에 데이터를 추가할 떄 사용할 productDao클래스
public class ProductDao {
	public Product insert(Connection conn, Product product) throws SQLException{
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("insert into product	"
						+ "	(pName, category, pPrice, discount, writer, publishing, imageFileURL, pDate, detailContent)	"
						+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?);	");
			pstmt.setString(1, product.getpName());
			pstmt.setString(2, product.getCategory());
			pstmt.setInt(3, product.getpPrice());
			pstmt.setInt(4, product.getDiscount());
			pstmt.setString(5, product.getWriter());
			pstmt.setString(6, product.getPublishing());
			pstmt.setString(7, product.getImageFileURL());
			pstmt.setString(8, product.getpDate());
			pstmt.setString(9, product.getDetailContent());
			
			int insertedCount = pstmt.executeUpdate();
			
			if(insertedCount>0) {
				stmt=conn.createStatement();
				rs=stmt.executeQuery("select last_insert_id() from product");
				
				if(rs.next()) {
					Integer newNum = rs.getInt(1);
					
					return new Product(newNum, product.getpName(), product.getCategory(),product.getpPrice(),
							product.getDiscount(),product.getWriter(),product.getPublishing(), product.getImageFileURL(),
							product.getpDate(), product.getDetailContent());
				}//end of if
				
			}//end of if(삽입여부 확인)
			return null;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
		
	}//end of insert()

	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}


	public int selectCount(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select count(*) from product";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
	}//end of selectCount


	//지정한 범위의 게시글을 읽어오기 위한 매서드
	public List<Product> select(Connection conn, int startRow, int size) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("List<Product> select진입");
		System.out.println("startRow="+startRow+"/"+"size="+size);
		try {
			String sql = " select pNo, pName, category, pPrice, discount, writer, publishing, imageFileURL, pDate, detailContent " + 
						"	from product	"+ 
						"   order by pNo desc "+
						"	limit ?, ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			List<Product> result = new ArrayList<>();
			while(rs.next()) {
				result.add(convertProduct(rs));

			}
	
			return result;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}//end of select()

	private Product convertProduct(ResultSet rs) throws SQLException{

		return new Product(rs.getInt("pNo"), 
							rs.getString("pName"),
							rs.getString("category"),
							rs.getInt("pPrice"),
							rs.getInt("discount"),
							rs.getString("writer"),
							rs.getString("publishing"),
							rs.getString("imageFileURL"),
							rs.getString("pDate"),
							rs.getString("detailContent")
							);
		
	}

	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}

	
	public Product selectById(Connection conn, int no) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from product where pNo=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			Product product = null;
			if(rs.next()) {
				product = convertProduct(rs);
			}
			return product;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}//end of selectById
	
	//상품목록 수정하는 매서드
	public int update(Connection conn, int no, Product product) throws SQLException{
		System.out.println("ProductDao-update()호출성공");
		PreparedStatement pstmt = null;
		
		try{
			String sql = "update product " + 
					"	set pName=?, category=?, pPrice=?, discount=?, writer=?, publishing=?, imageFileURL=?, pDate=?, detailContent=? " + 
					"    where pNo=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getpName());
			pstmt.setString(2, product.getCategory());
			pstmt.setInt(3, product.getpPrice());
			pstmt.setInt(4,product.getDiscount());
			pstmt.setString(5, product.getWriter());
			pstmt.setString(6, product.getPublishing());
			pstmt.setString(7, product.getImageFileURL());
			pstmt.setString(8, product.getpDate());
			pstmt.setString(9, product.getDetailContent());
			pstmt.setInt(10, no);
			return pstmt.executeUpdate();
		}finally {
			JdbcUtil.close(pstmt);
		}
		
	}//end of update
	

}













