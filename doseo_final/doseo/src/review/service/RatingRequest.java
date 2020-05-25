package review.service;

public class RatingRequest {

	private int rating;
	private int reviewNumber;
	
	
	public RatingRequest(int rating, int reviewNumber) {
		this.rating = rating;
		this.reviewNumber = reviewNumber;
	}


	public int getRating() {
		return rating;
	}


	public int getReviewNumber() {
		return reviewNumber;
	}

	
	
}
