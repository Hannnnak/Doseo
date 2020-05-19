package review.service;

import review.MODEL.Review;
import review.MODEL.ReviewContent;

public class ReviewData {

	private Review review;
	private ReviewContent content;

	public ReviewData(Review review, ReviewContent content) {
		this.review = review;
		this.content = content;
	}

	public Review getReview() {
		return review;
	}

	public String getContent() {
		return content.getContent();
	}

}
