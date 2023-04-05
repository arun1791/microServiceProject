package com.userservice.com.service.impl;


import com.userservice.com.enities.Hotel;
import com.userservice.com.enities.Rating;
import com.userservice.com.enities.User;
import com.userservice.com.exception.ResourceNotFoundException;
import com.userservice.com.external.service.HotelService;
import com.userservice.com.repository.UserRepository;
import com.userservice.com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;
    private final Logger logger=  LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User savUser(User user) {

       String randomUserId=  UUID.randomUUID().toString();
       user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAlluser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user= userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given not fpund !! "+userId));
        Rating[] ratingForuser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{}",ratingForuser);
        List<Rating> ratings = Arrays.stream(ratingForuser).toList();
        // Rating ratingnew=new Rating();
        List<Rating> ratingList = ratings.stream().map(rating -> {
            //localhost:8082/hotels/e12f29fd-07ec-4984-86bc-bb1c0103db8f
            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            //return to rating
            return rating;
        }).collect(Collectors.toList());
        user.setRating(ratingList);
        return  user;

    }
}
