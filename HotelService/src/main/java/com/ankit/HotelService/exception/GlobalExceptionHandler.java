package com.ankit.HotelService.exception;

import com.ankit.HotelService.payload.HotelApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<HotelApiResponse> handleUserException(HotelException userException) {
        String message = userException.getMessage();
        HotelApiResponse hotelApiResponse = HotelApiResponse.builder().message(message).success(true).statusCode(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<HotelApiResponse>(hotelApiResponse, HttpStatus.NOT_FOUND);
    }
}
