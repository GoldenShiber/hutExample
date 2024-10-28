package com.hutbooking.hut.exceptions;

public class HutNotFoundException extends RuntimeException{
    public HutNotFoundException(Long id){
        super("Could not find the hut: " + id);
    }
}
