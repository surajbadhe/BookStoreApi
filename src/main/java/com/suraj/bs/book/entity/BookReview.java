package com.suraj.bs.book.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BookReview {
	@Id
	@GeneratedValue
	private Long breviewID;
	//private InventoryID
	
	@Column(name = "REVIEW_DATE")
	private Date reviewdate;
	
	@Column(name = "REVIEW_COMMENT")
	private String reviews;
	
	@Column(name = "RATING")
	private String rating;
	
	@Column(name = "USER_NAME")
	private String username;

	public Long getBreviewID() {
		return breviewID;
	}

	public void setBreviewID(Long breviewID) {
		this.breviewID = breviewID;
	}

	public Date getReviewdate() {
		return reviewdate;
	}

	public void setReviewdate(Date reviewdate) {
		this.reviewdate = reviewdate;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((breviewID == null) ? 0 : breviewID.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((reviewdate == null) ? 0 : reviewdate.hashCode());
		result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookReview other = (BookReview) obj;
		if (breviewID == null) {
			if (other.breviewID != null)
				return false;
		} else if (!breviewID.equals(other.breviewID))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (reviewdate == null) {
			if (other.reviewdate != null)
				return false;
		} else if (!reviewdate.equals(other.reviewdate))
			return false;
		if (reviews == null) {
			if (other.reviews != null)
				return false;
		} else if (!reviews.equals(other.reviews))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
