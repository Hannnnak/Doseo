package review.service;

import java.util.Map;

import review.MODEL.Writer;

public class WriteRequest {

	private String bookname;
	private Writer writer;
	private String title;
	private String content;
	private String rating;
	
	public WriteRequest(String bookname, Writer writer, String title, String content, String rating) {
		this.bookname = bookname;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.rating = rating;
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

	public String getContent() {
		return content;
	}
	
	public String getRating() {
		return rating;
	}

	public void validate(Map<String, Boolean> errors) {
		if (title == null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		} 
	}

}
