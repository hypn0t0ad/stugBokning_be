package com.example.stugbokning_be.controller;

import com.example.stugbokning_be.entity.AdminEntity;
import com.example.stugbokning_be.model.AdminRequest;
import com.example.stugbokning_be.model.BookingResponse;
import com.example.stugbokning_be.model.LoginRequest;
import com.example.stugbokning_be.service.AdminService;
import com.example.stugbokning_be.service.BookCabinService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin/")
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private BookCabinService bookCabinService;

    @GetMapping("/bookings")
    public ResponseEntity<List<BookingResponse>> allBookings() {
        return ResponseEntity.ok(bookCabinService.allBookings());
    }
}