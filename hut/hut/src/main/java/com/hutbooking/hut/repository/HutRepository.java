package com.hutbooking.hut.repository;

import com.hutbooking.hut.model.Hut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HutRepository extends JpaRepository<Hut, Long> {
}
