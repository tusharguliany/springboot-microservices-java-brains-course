package com.guliany.movies.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.guliany.movies.models.Movie;
import com.guliany.movies.models.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@Value("${api.key}")
	private String apiKey;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		MovieSummary movieSummary = webClientBuilder
				.build()
				.get()
				.uri("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey)
				.retrieve()
				.bodyToMono(MovieSummary.class)
				.block();
		return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
	}

}
