package com.example.stugbokning_be.controller;

import com.example.stugbokning_be.entity.AdminEntity;
import com.example.stugbokning_be.model.AdminRequest;
import com.example.stugbokning_be.model.LoginRequest;
import com.example.stugbokning_be.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin/")
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/hello")
    public ResponseEntity<String> helloAdmin(){
        return ResponseEntity.ok("Hello Admin");
    }

    @PostMapping("/register")
    public ResponseEntity<AdminEntity> createAdmin(@RequestBody AdminRequest request){
        return new ResponseEntity<>(adminService.createAdmin(request), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        if(authentication.isAuthenticated()){
            return ResponseEntity.ok("Login Successful!");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login Failed");
    }
    @GetMapping("/cabins")
    public ResponseEntity<String> adminCabins(){
        return ResponseEntity.ok("Admin Cabins");
    }

    // Behöver en endpoint för att se alla bokningar också

}