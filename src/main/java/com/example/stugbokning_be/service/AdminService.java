package com.example.stugbokning_be.service;

import com.example.stugbokning_be.entity.AdminEntity;
import com.example.stugbokning_be.model.AdminRequest;
import com.example.stugbokning_be.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AdminEntity createAdmin(AdminRequest request){
        AdminEntity admin = new AdminEntity();
        admin.setName(request.name());
        admin.setUsername(request.username());
        admin.setPassword(passwordEncoder.encode(request.password()));
        admin.setRole("ADMIN");
        return  adminRepository.save(admin);
    }
}
