package com.ankit.UserService.service;

import com.ankit.UserService.model.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "rating-service")
public interface RatingService {

    @GetMapping("/rating/{userId}")
    public Rating[] getRatingByUserId(@PathVariable String userId);
}
