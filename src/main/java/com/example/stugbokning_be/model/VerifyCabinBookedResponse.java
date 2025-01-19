package com.example.stugbokning_be.model;

import java.time.LocalDate;

public record VerifyCabinBookedResponse(
        CabinModel cabin,
        LocalDate bookedStart,
        LocalDate bookedUntil

) {
}
