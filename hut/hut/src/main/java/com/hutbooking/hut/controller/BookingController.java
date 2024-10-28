package com.hutbooking.hut.controller;

import com.hutbooking.hut.exceptions.BookingNotFoundException;
import com.hutbooking.hut.model.Booking;
import com.hutbooking.hut.repository.BookingRepository;
import com.hutbooking.hut.repository.CustomerRepository;
import com.hutbooking.hut.repository.HutRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class BookingController {

    private final CustomerRepository customerRepository;
    private final HutRepository hutRepository;
    private final BookingRepository bookingRepository;

    BookingController(CustomerRepository customerRepository,
                      HutRepository hutRepository,
                      BookingRepository bookingRepository){
        this.customerRepository = customerRepository;
        this.hutRepository = hutRepository;
        this.bookingRepository = bookingRepository;
    }

    @GetMapping("/bookings")
    List<Booking> all(){
        return bookingRepository.findAll();
    }

    @GetMapping("/bookings/{id}")
    Booking one(@PathVariable Long id){
        return bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException(id));
    }

    @PutMapping("bookings/{customerId}/{hutId}/{startDate}/{endDate}")
    void book(@PathVariable Long customerId, @PathVariable Long hutId, @PathVariable Timestamp startDate, @PathVariable Timestamp endDate){
        bookingRepository.save(new Booking(startDate, endDate, customerId, hutId));
    }

}
