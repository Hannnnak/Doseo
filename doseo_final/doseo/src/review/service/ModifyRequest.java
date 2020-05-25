package review.service;

import java.util.Map;

public class ModifyRequest {

	private String userId;
	private int reviewNumber;
	private String title;
	private String content;
	private String bookname;
	private String rating;

	public ModifyRequest(String userId, int reviewNumber, String title, String content, String bookname, String rating) {
		this.userId = userId;
		this.reviewNumber = reviewNumber;
		this.title = title;
		this.content = content;
		this.bookname = bookname;
		this.rating = rating;
	}

	public String getUserId() {
		return userId;
	}

	public int getReviewNumber() {
		return reviewNumber;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
	
	

	public String getBookname() {
		return bookname;
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
