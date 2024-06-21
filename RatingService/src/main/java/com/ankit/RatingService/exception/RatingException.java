package com.ankit.RatingService.exception;


public class RatingException extends RuntimeException{

    public RatingException(String message){
        super(message);
    }

    public RatingException() {
        super("Rating Exception Occurred !!");
    }
}
