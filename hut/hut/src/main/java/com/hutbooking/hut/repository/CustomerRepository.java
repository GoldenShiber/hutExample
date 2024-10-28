package com.hutbooking.hut.repository;

import com.hutbooking.hut.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
