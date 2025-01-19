package com.example.stugbokning_be.controller;

import com.example.stugbokning_be.model.BookCabinRequest;
import com.example.stugbokning_be.model.VerifyCabinBookedResponse;
import com.example.stugbokning_be.model.CabinResponse;
import com.example.stugbokning_be.model.AvaibleDatesForCabinsRequest;
import com.example.stugbokning_be.service.BookCabinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cabins/")
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class BookCabinController {

    private final BookCabinService bookCabinService;


    @GetMapping("/all")
    public ResponseEntity<List<CabinResponse>> avaibleCabins() {
        return ResponseEntity.ok().body(bookCabinService.allAvaibleCabinsAndDates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CabinResponse> avaibleCabin(@PathVariable long id) {
        return ResponseEntity.ok().body(bookCabinService.specificCabinAndDates(id));
    }

    @PostMapping("/book")
    public ResponseEntity<VerifyCabinBookedResponse> bookCabin(@RequestBody BookCabinRequest request) {
        return ResponseEntity.ok().body(bookCabinService.bookCabin(request));
    }
}
