package com.hutbooking.hut;

import com.hutbooking.hut.model.Customer;
import com.hutbooking.hut.model.Hut;
import com.hutbooking.hut.repository.CustomerRepository;
import com.hutbooking.hut.repository.HutRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configuration annotations means it always runs when application is started!
@Configuration
class LoadDatabase {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository, HutRepository hutRepository){
        return args -> {
            // Add customers, however not really "important for this demo"
            LOGGER.info("Preloading " + customerRepository.save(new Customer("Kalle Anke", "911")));
            LOGGER.info("Preloading " + customerRepository.save(new Customer("Arne Anke", "112")));
            // Add some Huts
            LOGGER.info("Preloading " + hutRepository.save(new Hut("Vault of wealth", "Ankeborg", "A big vault filled with money")));
            LOGGER.info("Preloading " + hutRepository.save(new Hut("Travel van", "On the Road", "Perfect for traveling")));
            LOGGER.info("Preloading " + hutRepository.save(new Hut("Science House", "Ankeborg", "Inventions all over the place")));


        };

    }
}
