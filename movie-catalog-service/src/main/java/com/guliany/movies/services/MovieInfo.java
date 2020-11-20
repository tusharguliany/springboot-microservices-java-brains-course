package com.guliany.movies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.guliany.movies.models.CatalogItem;
import com.guliany.movies.models.Movie;
import com.guliany.movies.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class MovieInfo {

	@Autowired
	private WebClient.Builder webClientBuilder;

	/*
	 * in case of failure, hystrix tells springboot to run fallback method with
	 * specified name
	 */
	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem", // name of the fallback method
			threadPoolKey = "movieInfoPool", // creates a seperate thread pool allocated to this key
			threadPoolProperties = { // starts to configure threadpoolproperties
					@HystrixProperty(name = "coreSize", value = "20"), // max threads for this method and request
					@HystrixProperty(name = "maxQueueSize", value = "10") // max requests in queue or waiting before
																			// triggering the fallback method
			} // ends configuration
	)
	public CatalogItem getCatalogItem(Rating rating) {
		// synchronous programming
		// Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" +
		// rating.getMovieId(), Movie.class);
		Movie movie = webClientBuilder.build().get() // get call
				.uri("http://movie-info-service/movies/" + rating.getMovieId()) // to uri
				.retrieve() // get the reply back action
				.bodyToMono(Movie.class) // store the data in movie class when it comes back
				.block(); // pause execution, wait for the reply back and then store it into movie object
		return new CatalogItem(movie.getName(), "Sci/Fi", rating.getRating());
	}

	public CatalogItem getFallbackCatalogItem(Rating rating) {
		return new CatalogItem("Movie Name not Found", "", rating.getRating());
	}

}
