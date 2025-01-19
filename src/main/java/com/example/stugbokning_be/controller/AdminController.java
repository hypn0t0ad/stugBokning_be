package com.example.stugbokning_be.controller;

import com.example.stugbokning_be.model.*;
import com.example.stugbokning_be.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/v1")
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class AdminController {

    private final BookingService bookingService;

    // log in

    // register

    @GetMapping("/bookings")
    public ResponseEntity<List<BokningResponse>> allaBokningar() {
        return ResponseEntity.ok().body(bookingService.avaibleDatesForCabin());
    }
}
