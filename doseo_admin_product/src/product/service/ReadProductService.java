package product.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.connection.ConnectionProvider;
import product.dao.ProductDao;
import product.model.Product;

public class ReadProductService {
	private ProductDao productDao = new ProductDao();
	
	public Product getProduct(int ProductNum) {
		try {
			Connection conn = ConnectionProvider.getConnection();
			Product product = productDao.selectById(conn, ProductNum);
			if(product==null) {
				throw new ProductNotFoundException();
			}			
		
			return new Product(product.getpNo(),
								product.getpName(), 
								product.getCategory(), 
								product.getpPrice(),
								product.getDiscount(),
								product.getWriter(),
								product.getPublishing(),
								product.getImageFileURL(),
								product.getpDate(),
								product.getDetailContent()
								);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}//end of getProduct(0

}
