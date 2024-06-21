package com.ankit.RatingService.exception;

import com.ankit.RatingService.payload.RatingApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRatingExceptionHandler {

    public ResponseEntity<RatingApiResponse> handleUserException(RatingException ratingException) {
        String message = ratingException.getMessage();
        RatingApiResponse userApiResponse = RatingApiResponse.builder().message(message).success(true).statusCode(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<RatingApiResponse>(userApiResponse, HttpStatus.NOT_FOUND);
    }
}
