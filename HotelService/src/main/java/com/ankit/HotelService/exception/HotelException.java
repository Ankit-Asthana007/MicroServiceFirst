package com.ankit.HotelService.exception;

public class HotelException extends RuntimeException {

    public HotelException() {
        super("Hotel Not Found Exception !!");
    }
    public HotelException(String message) {
        super(message);
    }
}
