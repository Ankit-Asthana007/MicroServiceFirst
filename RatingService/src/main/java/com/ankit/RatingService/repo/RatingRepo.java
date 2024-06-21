package com.ankit.RatingService.repo;

import com.ankit.RatingService.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepo extends JpaRepository<Rating, String>{
}
