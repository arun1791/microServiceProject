package com.userservice.com.Controller;

import com.userservice.com.enities.User;
import com.userservice.com.service.UserService;
import com.userservice.com.service.impl.UserServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger=  LoggerFactory.getLogger(UserServiceImpl.class);
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
       User user1=  userService.savUser(user);
       return  ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }


    //get user
    int retryCount=1;
    @GetMapping("/{userId}")
   // @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
   // @Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "userRatelimiter" , fallbackMethod = "ratingHotelFallback")
    public  ResponseEntity<User> getSignleUser( @PathVariable String userId){
        logger.info("Retry count {}"+retryCount);
        retryCount++;
       User user= userService.getUser(userId);
       return ResponseEntity.ok(user);
    }

    //creaing cercit breaker fall back method
    public  ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){
//        logger.info("Fallback is excuted becuse service is down ",ex.getMessage());


        User user=User.builder()
                .email("dummy@gamail.com")
                .name("dummy")
                .about("this kis user is dummy bexusde suer not working")
                .userId("12344")
                .build();
                return  new ResponseEntity<>(user,HttpStatus.OK);
    }
    //get all user

    @GetMapping("/")
    public  ResponseEntity<List<User>> getAlluser(){
        List<User> users= userService.getAlluser();
        return  ResponseEntity.ok(users);
    }

}