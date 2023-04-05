package com.hotelservice.com.service.impl;

import com.hotelservice.com.entities.Hotel;
import com.hotelservice.com.exception.ResourceNotFoundException;
import com.hotelservice.com.respository.HotelRepository;
import com.hotelservice.com.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceimpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        String hotelRandomId= UUID.randomUUID().toString();
        hotel.setId(hotelRandomId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getall() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel with given id not found "+id));
    }
}
