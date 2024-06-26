package com.ankit.UserService.payload;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserApiResponse {
    private String message;
    private boolean success;
    private HttpStatus statusCode;
}
