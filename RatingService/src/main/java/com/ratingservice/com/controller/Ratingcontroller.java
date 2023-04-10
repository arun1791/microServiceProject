package com.ratingservice.com.controller;

import com.ratingservice.com.entities.Rating;
import com.ratingservice.com.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class Ratingcontroller {

    @Autowired
    private RatingService ratingService;
    //create rating
    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }
    @GetMapping("/")
    //get all
    public  ResponseEntity<List<Rating>> getRatings(){
        return  ResponseEntity.ok(ratingService.getAllrating());
    }

    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping("/users/{userId}")
    public  ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
        return  ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public  ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
        return  ResponseEntity.ok(ratingService.getratingByhotelId(hotelId));

    }




}
