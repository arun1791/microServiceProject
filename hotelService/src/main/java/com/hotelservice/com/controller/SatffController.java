package com.hotelservice.com.controller;

import com.sun.research.ws.wadl.HTTPMethods;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/staff")
public class SatffController {

    @GetMapping
    public ResponseEntity<List<String >> getSatffData()
    {
        List<String> list = Arrays.asList("aun", "tom", "neha");
        return new ResponseEntity<>(list, HttpStatus.OK);

    }
}
