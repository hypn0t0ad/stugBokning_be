package com.example.stugbokning_be.controller;

import com.example.stugbokning_be.model.BookingResponse;
import com.example.stugbokning_be.service.BookCabinService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/check-auth")
    public ResponseEntity<?> checkAuth(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return ResponseEntity.ok().body("Authenticated");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not authenticated");
    }
    @GetMapping("/bookings")
    public ResponseEntity<List<BookingResponse>> allBookings() {
        return ResponseEntity.ok(bookCabinService.allBookings());
    }
}