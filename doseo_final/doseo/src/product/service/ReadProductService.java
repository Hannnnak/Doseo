package product.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import product.dao.ProductDao;
import product.model.Product;

public class ReadProductService {
	private ProductDao productDao = new ProductDao();
	
	//유저 검색으로 상품가져오기
	public List<Product> getProductBySearch(String search) {
		try {
			System.out.println("ReadProductService의 getProductBySearch진입 ");
			Connection conn = ConnectionProvider.getConnection();
			List<Product> product = productDao.selectBySearch(conn, search);
			
			if(product==null) {
				throw new ProductNotFoundException();
		    }
			return product;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	//관리자검색으로 상품  가져오기
	public List<Product> getProduct(String col, String word) {
		try {
			Connection conn = ConnectionProvider.getConnection();
			List<Product> product = productDao.selectByWord(conn, col, word);
			System.out.println(product.toString());
			if(product==null) {
				throw new ProductNotFoundException();
		    }
			return product;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	//카테고리로 상품 가져오기
	public List<Product> getProduct(String category) {
		try {
			Connection conn = ConnectionProvider.getConnection();
			System.out.println("getProduct");
			List<Product> product = productDao.selectByCategory(conn, category);
			if(product==null) {
				throw new ProductNotFoundException();
		    }

			return product;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	//상품번호로 상품 가져오기
	public Product getProduct(int ProductNum) {
		try {
			Connection conn = ConnectionProvider.getConnection();
			Product product = productDao.selectById(conn, ProductNum);
			if(product==null) {
				throw new ProductNotFoundException();
			}			
		
			System.out.println("ReadProductService의 "+product.getImageFileURL());
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
