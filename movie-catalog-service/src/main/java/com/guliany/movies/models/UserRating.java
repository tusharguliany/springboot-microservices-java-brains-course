package com.guliany.movies.models;

import java.util.List;

/*
 * Sort of a DTO
 */
public class UserRating {

	private String userId;
	private List<Rating> userRating;

	public UserRating() {
		super();
	}

	public UserRating(String userId, List<Rating> userRating) {
		super();
		this.userId = userId;
		this.userRating = userRating;
	}

	public List<Rating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserRating [userId=" + userId + ", userRating=" + userRating + "]";
	}

}
