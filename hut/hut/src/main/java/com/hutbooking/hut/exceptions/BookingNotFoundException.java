package com.hutbooking.hut.exceptions;

public class BookingNotFoundException extends RuntimeException{
    public BookingNotFoundException(Long id){
        super("Booking cannot be found: " + id);
    }
}
