package com.ankit.RatingService.payload;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RatingApiResponse {

    private String message;
    private boolean success;
    private HttpStatus statusCode;
}
