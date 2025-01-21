package com.example.stugbokning_be.security;

import com.example.stugbokning_be.entity.AdminEntity;
import com.example.stugbokning_be.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminTestSetup {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AdminRepository adminRepository;

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            AdminEntity admin = new AdminEntity();
            admin.setName("Admin User");
            admin.setUsername("admin");
            admin.setRole("ADMIN");
            admin.setPassword(passwordEncoder.encode("ingetjidder123"));
            adminRepository.save(admin);
        };
    }
}

