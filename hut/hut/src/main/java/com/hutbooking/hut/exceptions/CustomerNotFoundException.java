package com.hutbooking.hut.exceptions;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(Long id) {
        super("Could not find the customer " + id);
    }
}
