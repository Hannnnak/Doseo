package article.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import article.MODEL.Article;
import article.MODEL.Writer;
import jdbc.JdbcUtil;

//p634, 646, 647, 665
//article테이블과 연동하는  DAO
public class ArticleDAO {
	//p665 1
	//글 수정
	public int  update(Connection conn,String title,int no) 
		throws SQLException{
		System.out.println("글 수정 ArticleDAO-update()호출성공");
		PreparedStatement pstmt = null;
		try {
			String sql=
				"update article "+
				 " set   title=?, moddate=NOW() "+
				 " where article_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setInt(2, no);
			int cnt = pstmt.executeUpdate();
			//update성공적으로 실행되면 update된 레코드수가 리턴된다
			//여기에서는 pk특정글번호만 update되므로 성공시에는 1이 리턴
			return cnt;
		}finally {
			JdbcUtil.close(pstmt);
		}
	
	}
	
	//P646 1
	//전체게시물수 구하기(P646 1) pro1/guestbook.dao/MessageDAO.JAVA
	public int selectCount(Connection conn) throws SQLException {
		System.out.println("전체게시물수 구하기 ArticleDAO-selectCount()호출성공");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select  count(*) "+
						 "	from  article";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {//등록된 게시글이 존재하면
				return rs.getInt(1); //전체 게시물수가 리턴
			}
			return 0; //등록된 게시글이 존재x하면  0을 리턴
			
	  }finally {
		JdbcUtil.close(rs);  
		JdbcUtil.close(pstmt);
	  }
	  
	}//end of selectCount
	
	
	//보고싶은 페이지에 해당하는 일부게시물 목록 조회 p647 15
	//p645 참고
	//전체게시글은 1페이지당10개의 게시글 번호,제목,작성자,조회수
	//전체게시글수가 55개라면 
	//요청한 페이지가 n이면, 가장 최근 게시글이 제일 첫페이지지에 출력 순서
	/* 1페이지	의 글번호는	55~46  limit 0, 10 
	 * 2페이지			45~36  limit 10,10 
	 * 3페이지			35~26  limit 20,10
	 * 4페이지			25~16  limit 0시작행번호?, 10
	 */
	
	//모델의 형태가 여러개의 행과 2개이상의 컬럼(컬럼타입)으로 구성되어 있다면
	/*List<클래스> 참조변수 = new ArrayList<>();
			while( rs.next() ) {
				참조변수.add(클래스객체);
				//참조변수.add(new 클래스명());  5,'id1','홍길동','제목1',오늘,오늘,0
				//                         4,'id2','김길','제목2',오늘,오늘,0
				//                         3,'id33','삼삼이','제목3이요',어제,어제,0  
			}
	*/
	public List<Article> select(Connection conn,
			int startRow,int size)  
			throws SQLException {
		System.out.println("ArticleDAO의 select(startRow,size)="
			                +startRow+"/"+size);
		PreparedStatement pstmt = null;
		ResultSet rs   = null;
		try {
			String sql = 
			"select	article_no,writer_id,writer_name, " + 
			"		title,regdate,moddate, read_cnt " + 
			" from  article " +
			" order by article_no desc "+
			" limit ?, ?";
		//limit  0부터시작행번호, 읽어올레코드수
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,startRow); //시작행번호
			pstmt.setInt(2,size); //읽어올레코드수
			rs = pstmt.executeQuery();
			List<Article> result = new ArrayList<>();
			while( rs.next() ) {
				result.add(convertArticle(rs));
			}
			return result;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}	
	}
	
	//select쿼리문 결과를 받아서  Atricle클래스타입으로 묶어주는 함수 p647 36
	private Article convertArticle(ResultSet rs) 
	    throws SQLException{
		System.out.println("ArticleDAO의  convertArticle()");
		
		return new Article(rs.getInt("article_no"),
				new Writer(rs.getString("writer_id"),
						   rs.getString("writer_name")),
				rs.getString("title"),
				toDate(rs.getTimestamp("regdate")),
				toDate(rs.getTimestamp("moddate")),
				rs.getInt("read_cnt"));
	}

	//Timestamp타입을 Date타입으로 변환 p648 47
	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}


	public Article insert(Connection conn, 
			Article article) throws SQLException {
		System.out.println("ArticleDAO의 insert() article="+article);
		
		PreparedStatement pstmt = null;
		
		//article테이블에서 입력된 마지막 article_id값을 가져오는
		//쿼리를 실행하기위해 필요한  stmt와
		//그 실행결과를 담기위한 rs변수 선언
		Statement stmt = null;
		ResultSet rs   = null;	
		try {
			String sql = 
			"insert into article(writer_id,writer_name,title,regdate,moddate,read_cnt) " + 
			" values(?,?,?,?,?,0);";
			pstmt = conn.prepareStatement(sql);
			Writer writer = article.getWriter();
			String id 	  = writer.getId();
			pstmt.setString(1,id);
			pstmt.setString(2,writer.getName());
			pstmt.setString(3,article.getTitle());
			pstmt.setTimestamp(4, toTimestamp(article.getRegDate()));
			pstmt.setTimestamp(5, toTimestamp(article.getModifiedDate()));
			int insertedCount = pstmt.executeUpdate();
			
			//p635 31
			if(insertedCount>0) { //insert성공시
				//insert시 들어갔던 article_no컬럼을 값을 가져오자
				//그래야지 article_content컬럼에
				//insert할 때 사용할 수 있다
				stmt = conn.createStatement();
				rs   = stmt.executeQuery("select last_insert_id()  "
						+ " from article");
				if(rs.next()) {
					Integer newNum = rs.getInt(1);
					return new Article(newNum,
							article.getWriter(),article.getTitle(),
							article.getRegDate(),article.getRegDate(),
							0);
				}
			}
			return null; //insert 실패시
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
		
		
	}
	
	//Date타입을 Timestamp타입으로 변환
	private   Timestamp toTimestamp(Date date) {
		return new  Timestamp(date.getTime());
	}


	//article테이블의 특정글번호 조회수 증가	 p656 20
	public void incrementReadCount(Connection conn, 
			int articleNum) throws SQLException{
		try {
			String sql = 
				"update article " + 
				" set   read_cnt=read_cnt+1 " + 
				" where article_no=?";
			PreparedStatement pstmt =
				conn.prepareStatement(sql);
			pstmt.setInt(1, articleNum);
			pstmt.executeUpdate();
		}finally {
			
		}
		
	}
	
	//P655 1
	//article테이블의 특정글번호 조회
	public Article selectByID(Connection conn, int articleNum) 
		throws SQLException {
		System.out.println("ArticleDAO의 selectByID(articleNum)="
			                +articleNum);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = 
			"select	article_no,writer_id,writer_name, " + 
			"		title,regdate,moddate, read_cnt " + 
			" from  article " +
			" where article_no=?";
			pstmt =	conn.prepareStatement(sql);
			pstmt.setInt(1, articleNum);
			rs = pstmt.executeQuery();//p655 8
			
			Article article = null;
			if(rs.next()) {
				article = convertArticle(rs);
			}
			return article;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

}











