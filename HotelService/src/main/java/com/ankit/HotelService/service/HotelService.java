package com.ankit.HotelService.service;

import com.ankit.HotelService.exception.HotelException;
import com.ankit.HotelService.model.Hotel;
import com.ankit.HotelService.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    public void deleteHotel(String hotelId) {
        hotelRepo.deleteById(hotelId);
    }

    public Hotel saveHotel(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    public Hotel getHotelById(String hotelId) {
        return hotelRepo.findById(hotelId).orElseThrow(()->new HotelException("Hotel Not Found !!"));
    }

    public List<Hotel> getHotelList() {
        return hotelRepo.findAll();
    }
}
