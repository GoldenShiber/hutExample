package com.hutbooking.hut.controller;

import com.hutbooking.hut.exceptions.CustomerNotFoundException;
import com.hutbooking.hut.model.Customer;
import com.hutbooking.hut.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerRepository repository;

    CustomerController(CustomerRepository repository){
        this.repository = repository;
    }

    @GetMapping("/customers")
    List<Customer> all(){
        return repository.findAll();
    }

    @GetMapping("/customers/{id}")
    Customer one(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }
}
