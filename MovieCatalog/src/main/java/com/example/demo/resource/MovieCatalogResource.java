package com.example.demo.resource;

import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.model.CatalogItem;
import com.example.demo.model.Movie;
import com.example.demo.model.Rating;
import com.example.demo.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId")String userId){
		
		 
		
		UserRating ratings= restTemplate.getForObject("http://rating/ratingsdata/users/"+userId,UserRating.class);
		
		return ratings.getUserRating().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movieInfo/movies/"+rating.getMovieId(), Movie.class);
			
			return new CatalogItem(movie.getName(), "scifi", rating.getRating());
		}).collect(Collectors.toList());
		
	}

}
/*Movie movie = webClientBuilder.build()
.get()
.uri("http://localhost:8082/movies/"+rating.getMovieId())
.retrieve()
.bodyToMono(Movie.class)
.block();*/