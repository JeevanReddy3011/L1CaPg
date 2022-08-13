package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Movie;



@RestController
@RequestMapping("/movies")
public class MovieInfoResource {
	@RequestMapping("/{movieId}")
	public Movie getmovieInfo(@PathVariable("movieId")String movieId) {
		return new Movie("text", "next");
		
	}
}


