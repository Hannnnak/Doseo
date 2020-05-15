package product.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import product.dao.ProductDao;
import product.model.Product;


//전체목록보기 요청 담당 컨트롤러에서 호출하는 서비스클래스
//DAO와 연동
public class ListProductService {

	private ProductDao productDao = new ProductDao();
	private int size = 5; //한 페이지당 출력할 게시글 수
	//한 페이지당 출력할 게시글 수가 10개라면 size는 10
	
	//페이지정보
	public ProductPage getProductPage(int pageNo) {
		try {
			Connection conn = ConnectionProvider.getConnection();
			
			//전체 게시글수 조회
			int total = productDao.selectCount(conn);	//5
			
			//public List<Product> select(Connection conn, int startRow, int size)
			List<Product> content = productDao.select(conn, (pageNo-1)*size, size);
			//System.out.println("content는 "+content.toString());

			return new ProductPage(total, pageNo, size, content);
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
