package com.ankit.UserService.service;

import com.ankit.UserService.exception.UserException;
import com.ankit.UserService.model.Hotel;
import com.ankit.UserService.model.Rating;
import com.ankit.UserService.model.User;
import com.ankit.UserService.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public User getUserById(String id) {
        User user =  userRepo.findById(id).orElseThrow(() -> new UserException("User not found for the given userid !!" + id));
        //here we fetch the ratings for the useR
//        Rating[] ratingsOfUser1 = restTemplate.getForObject("http://localhost:8083/rating/user/" + user.getId(), Rating[].class);
        Rating[] ratingsOfUser1 = ratingService.getRatingByUserId(user.getId());
        List<Rating> ratingList =Arrays.stream(ratingsOfUser1).toList();
//        Rating[] ratingsOfUser = restTemplate.getForObject("http://rating-service/rating/user/" + user.getId(), Rating[].class); //using service call
//        List<Rating> ratingList = Arrays.stream(ratingsOfUser).toList();

        //To get the hotel which the user has rated
        List<Rating> ratingArrayList =  ratingList.stream().map(rating -> {
            //api call to hotel service to get the hotel details
//            Hotel hotelRatedByUser = hotelService.getHotelById(rating.getHotelId());  //using feign client

            Hotel hotelRatedByUser = restTemplate.getForObject("http://localhost:8082/hotel/" + rating.getHotelId(), Hotel.class);
//            Hotel hotelRatedByUser1 = restTemplate.getForObject("http://hotel-service/hotel/" + rating.getHotelId(), Hotel.class); //using service call
            rating.setHotel(hotelRatedByUser);
            return rating;
        }).collect(Collectors.toList());

        //the rating service will return the ratings of the user also with the hotel details
        user.setRatings(ratingArrayList);
        return user;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
