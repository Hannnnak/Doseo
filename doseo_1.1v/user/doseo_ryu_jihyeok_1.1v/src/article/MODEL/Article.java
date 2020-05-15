package article.MODEL;

import java.util.Date;

//P631 코드작성 후
//WriteArticleService의 toArticle()함수등 에서 사용
//article 테이블관련 데이터를  관리하는 클래스
public class Article {

	private Integer number;
	private Writer 	writer;		//writer_id 컬럼용,writer_name 컬럼용
	private String 	title;		//title컬럼용	 
	private	Date	regDate;	//regdate컬럼용
	private	Date	modifiedDate;//moddate컬럼용
	private int		readCount;	 //read_cnt컬럼용
	
  //public Article(null,req.getWriter(),req.getTitle(), now,now,0) {
	public Article(Integer number,
			Writer 	writer,String 	title,
			Date	regDate,Date	modifiedDate,
			int		readCount) {	
		this.number = number;
		this.writer = writer;
		this.title  = title;
		this.regDate= regDate;
		this.modifiedDate=modifiedDate;
		this.readCount=readCount;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	@Override
	public String toString() {
		return "Article [number=" + number + ", writer=" + writer + ", title=" + title + ", regDate=" + regDate
				+ ", modifiedDate=" + modifiedDate + ", readCount=" + readCount + "]";
	};
	
	
}







