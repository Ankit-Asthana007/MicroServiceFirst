package com.ankit.UserService.exception;


import com.ankit.UserService.payload.UserApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalUserExceptionHandler {

    public ResponseEntity<UserApiResponse> handleUserException(UserException userException) {
        String message = userException.getMessage();
        UserApiResponse userApiResponse = UserApiResponse.builder().message(message).success(true).statusCode(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<UserApiResponse>(userApiResponse, HttpStatus.NOT_FOUND);
    }
}
