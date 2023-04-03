package com.userservice.com.Controller;

import com.userservice.com.enities.User;
import com.userservice.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    //create
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
       User user1=  userService.savUser(user);
       return  ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }


    //get user
    @GetMapping("/{userId}")
    public  ResponseEntity<User> getSignleUser( @PathVariable String userId){
       User user= userService.getUser(userId);
       return ResponseEntity.ok(user);
    }

    //get all user

    @GetMapping("/")
    public  ResponseEntity<List<User>> getAlluser(){
        List<User> users= userService.getAlluser();
        return  ResponseEntity.ok(users);
    }

}