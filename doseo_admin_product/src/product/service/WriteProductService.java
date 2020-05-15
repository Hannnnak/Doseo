package product.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.management.RuntimeErrorException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import product.dao.ProductDao;
import product.model.Product;

//상품등록 기능을 제공한다.
public class WriteProductService {

	private ProductDao productDao = new  ProductDao();
	
	public Integer write(WriteRequest req) {
		Connection conn=null;
		try {
			conn=ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Product product = toProduct(req);
			Product savedProduct = productDao.insert(conn, product);
			
			if(savedProduct==null) {
				throw new RuntimeException("fail to insert product");
			}
			
			conn.commit();
			
			return savedProduct.getpNo();
						
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}catch(RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
	}//end of write()

	
	
	private Product toProduct(WriteRequest req) {
		Date now = new Date();
		return new Product(null, req.getpName(), req.getCategory(), req.getpPrice(), req.getDiscount(), req.getWriter(),
				req.getPublishing(), req.getImageFileURL(), req.getbDate(), req.getDetailContent());
		
	}
	
	
	
}
