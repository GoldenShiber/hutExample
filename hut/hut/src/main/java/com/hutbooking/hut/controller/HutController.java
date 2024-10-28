package com.hutbooking.hut.controller;

import com.hutbooking.hut.exceptions.HutNotFoundException;
import com.hutbooking.hut.model.Hut;
import com.hutbooking.hut.repository.HutRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HutController {

    private final HutRepository hutRepository;
    HutController(HutRepository repository){
        this.hutRepository = repository;
    }

    @GetMapping("/huts")
    List<Hut> all(){
        return hutRepository.findAll();
    }

    @GetMapping("/huts/{id}")
    Hut one(@PathVariable Long id){
        return hutRepository.findById(id).orElseThrow(() -> new HutNotFoundException(id));
    }
}
