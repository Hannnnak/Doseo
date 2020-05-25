package review.MODEL;

import java.util.Date;

public class Review {

	private Integer number;
	private String bookname;
	private Writer writer;
	private String title;
	private Date regDate;
	private Date modifiedDate;
	private String rating;
	private int readCount;

	public Review(Integer number, String bookname, Writer writer, String title, 
			Date regDate, Date modifiedDate, String rating, int readCount) {
		this.number = number;
		this.bookname = bookname;
		this.writer = writer;
		this.title = title;
		this.regDate = regDate;
		this.modifiedDate = modifiedDate;
		this.rating = rating;
		this.readCount = readCount;
	}

	public Integer getNumber() {
		return number;
	}
	
	public String getBookname() {
		return bookname;
	}
	
	public Writer getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public Date getRegDate() {
		return regDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public String getRating() {
		return rating;
	}
	
	public int getReadCount() {
		return readCount;
	}

}
