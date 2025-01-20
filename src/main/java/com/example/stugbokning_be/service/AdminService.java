package com.example.stugbokning_be.service;

import com.example.stugbokning_be.entity.AdminEntity;
import com.example.stugbokning_be.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AdminService implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AdminEntity> admin = adminRepository.findByUsername(username);
        if(admin.isPresent()){
            return new User(admin.get().getUsername(), admin.get().getPassword(), new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("User not found " + username);
        }
    }
}
