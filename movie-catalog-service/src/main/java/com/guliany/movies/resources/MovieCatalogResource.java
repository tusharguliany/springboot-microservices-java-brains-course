package com.guliany.movies.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;

import com.guliany.movies.models.CatalogItem;
import com.guliany.movies.models.UserRating;
import com.guliany.movies.services.MovieInfo;
import com.guliany.movies.services.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired 
	private MovieInfo movieInfo;
	
	@Autowired
	private UserRatingInfo userRatingInfo;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable(name = "userId") String userId) {
		UserRating ratings = this.userRatingInfo.getUserRating(userId);
		return ratings.getUserRating().stream().map(rating -> this.movieInfo.getCatalogItem(rating)).collect(Collectors.toList());
	}

}
