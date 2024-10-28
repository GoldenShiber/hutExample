package com.hutbooking.hut.repository;

import com.hutbooking.hut.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
