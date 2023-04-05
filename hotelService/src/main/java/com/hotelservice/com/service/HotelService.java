package com.hotelservice.com.service;

import com.hotelservice.com.entities.Hotel;

import java.util.List;

public interface  HotelService {

    //create
    Hotel create(Hotel hotel);

    //getAll
    List<Hotel> getall();

    //get single
    Hotel get(String id);

}
