package com.ankit.UserService.service;

import com.ankit.UserService.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hotel-service")
public interface HotelService {

    @GetMapping("/hotel/{hotelId}")
    Hotel getHotelById(@PathVariable String hotelId);
}
