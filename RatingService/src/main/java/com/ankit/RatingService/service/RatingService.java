package com.ankit.RatingService.service;

import com.ankit.RatingService.model.Rating;
import com.ankit.RatingService.repo.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    public Rating saveRating(Rating rating){
        return ratingRepo.save(rating);
    }

    public Rating getRatingById(String ratingId){
        return ratingRepo.findById(ratingId).orElse(null);
    }

    public List<Rating> getAllRatings(){
        return ratingRepo.findAll();
    }


    public void deleteRating(String ratingId){
        ratingRepo.deleteById(ratingId);
    }


}
