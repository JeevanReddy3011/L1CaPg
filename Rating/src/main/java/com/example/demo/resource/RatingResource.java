package com.example.demo.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Rating;
import com.example.demo.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
	
	
	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable("userId")String userId)
	{
		List<Rating> ratings = Arrays.asList(
				new Rating("1234",9),
				new Rating("5687", 7)
		);
		UserRating userRating=new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}

}
