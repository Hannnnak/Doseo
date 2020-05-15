package product.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import product.dao.ProductDao;
import product.model.Product;

public class ModifyProductService {

	private ProductDao productDao = new ProductDao();
	
	public void modify(Product modReq) {
		Connection conn =null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Product product = productDao.selectById(conn, modReq.getpNo());
			
			if(product==null) {
				throw new ProductNotFoundException();
			}

			productDao.update(conn, modReq.getpNo(), modReq);
			conn.commit();
			
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException();
		}catch(PermissionDeniedException e) {
			JdbcUtil.rollback(conn);
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
	}//end of modify
	
}
