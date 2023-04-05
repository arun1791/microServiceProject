package com.userservice.com.external.service;

import com.userservice.com.enities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @PostMapping("/ratings")
    public Rating creatingRarting(Rating value);

    //put]
    @PutMapping("/ratings/{ratingId}")
    public  Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);
//Delete
    @DeleteMapping("/ratings/{ratingId}")
    public  void  deleteRating(@PathVariable String ratingId);

}
