package com.ratingservice.com.repository;

import com.ratingservice.com.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepositotry extends JpaRepository<Rating,String> {

    //custome  find method
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);

}
