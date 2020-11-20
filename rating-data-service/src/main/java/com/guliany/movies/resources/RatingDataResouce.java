package com.guliany.movies.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guliany.movies.models.Rating;
import com.guliany.movies.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataResouce {

	@RequestMapping("/{movieId}")
	public Rating getRatingData(@PathVariable(name = "movieId") String movieId) {
		return new Rating(movieId, 4);
	}

	@RequestMapping("/users/{userId}")
	public UserRating getRating(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(new Rating("500", 4), new Rating("600", 5));
		UserRating userRating = new UserRating(ratings);
		return userRating;
	}

}
