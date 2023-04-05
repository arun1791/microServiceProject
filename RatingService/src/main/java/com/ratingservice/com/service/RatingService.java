package com.ratingservice.com.service;

import com.ratingservice.com.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RatingService {

    //create
     Rating create(Rating rating);


    //gte alll
    List<Rating> getAllrating();


    //gte all by userId
    List<Rating>getRatingByUserId(String userId);

    //gte all by hotel
    List<Rating> getratingByhotelId(String hotelId);

}
