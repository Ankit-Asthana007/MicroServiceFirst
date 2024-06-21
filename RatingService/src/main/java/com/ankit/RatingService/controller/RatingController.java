package com.ankit.RatingService.controller;

import com.ankit.RatingService.model.Rating;
import com.ankit.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/saveRating")
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
        Rating rating1  = ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }

    @GetMapping("/getRating/{ratingId}")
    public ResponseEntity<Rating> getRatingById(@PathVariable String ratingId){
        Rating rating = ratingService.getRatingById(ratingId);
        return ResponseEntity.status(HttpStatus.OK).body(rating);
    }

    @GetMapping("/getAllRatings")
    public ResponseEntity<?> getAllRatings(){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatings());
    }
}
