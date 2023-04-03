package com.ratingservice.com.service.impl;

import com.ratingservice.com.entities.Rating;
import com.ratingservice.com.repository.RatingRepositotry;
import com.ratingservice.com.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepositotry ratingRepositotry;
    @Override
    public Rating create(Rating rating) {
        String RatingRandomeId= UUID.randomUUID().toString();
        rating.setRatingId(RatingRandomeId);
        return ratingRepositotry.save(rating);
    }

    @Override
    public List<Rating> getAllrating() {
        return ratingRepositotry.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepositotry.findByUserId(userId);
    }

    @Override
    public List<Rating> getratingByhotelId(String hotelId) {
        return ratingRepositotry.findByHotelId(hotelId);
    }
}
