package com.ankit.HotelService.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelApiResponse {
    private String message;
    private boolean success;
    private HttpStatus statusCode;
}
