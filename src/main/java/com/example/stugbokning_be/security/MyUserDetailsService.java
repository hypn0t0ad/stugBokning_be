package com.example.stugbokning_be.security;

import com.example.stugbokning_be.entity.AdminEntity;
import com.example.stugbokning_be.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AdminEntity> admin = adminRepository.findByUsername(username);
        if(admin.isPresent()){
            AdminEntity adminUser = admin.get();
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(adminUser.getRole())); // Get the authorities from the role in DB
            return new User(adminUser.getUsername(), adminUser.getPassword(), authorities);
        }else {
            throw new UsernameNotFoundException("User not found " + username);
        }
    }
}