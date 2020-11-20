package com.guliany.movies.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;

import com.guliany.movies.models.Rating;
import com.guliany.movies.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserRatingInfo {

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	/*
	 * in case of failure, hystrix tells springboot to run fallback method with specified name
	 */
	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		return webClientBuilder.build().get().uri("http://rating-data-service/ratingsdata/users/" + userId).retrieve()
				.bodyToMono(UserRating.class).block();
	}

	public UserRating getFallbackUserRating(@PathVariable("userId") String userId) {
		return new UserRating(userId, Arrays.asList(new Rating("0", 0)));
	}
	
}
