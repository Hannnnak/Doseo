package review.service;

import review.MODEL.Review;
import review.MODEL.ReviewContent;

public class ReviewData {

	private Review review;
	private ReviewContent content;
	private String bookname;
	private String rating;

	public ReviewData(Review review, ReviewContent content, String bookname, String rating) {
		this.review = review;
		this.content = content;
		this.bookname = bookname;
		this.rating = rating;
	}
	
	

	public String getBookname() {
		return bookname;
	}



	public String getRating() {
		return rating;
	}



	public Review getReview() {
		return review;
	}

	public String getContent() {
		return content.getContent();
	}

}
