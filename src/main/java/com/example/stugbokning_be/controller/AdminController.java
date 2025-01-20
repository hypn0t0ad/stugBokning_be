package com.example.stugbokning_be.controller;

import com.example.stugbokning_be.model.BookingResponse;
import com.example.stugbokning_be.service.BookCabinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin/")
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class AdminController {

    private final BookCabinService bookCabinService;

    @GetMapping("/admin/hello")
    public ResponseEntity<String> helloAdmin(){
        return ResponseEntity.ok("Hello Admin");
    }

    @GetMapping("/allbookings")
    public ResponseEntity<List<BookingResponse>> allBookings() {
        List<BookingResponse> bookingResponses = bookCabinService.allBookings();
        return ResponseEntity.ok(bookingResponses);
    }
}

