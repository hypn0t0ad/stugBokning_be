package com.example.stugbokning_be.model;

import java.time.LocalDate;
import java.util.List;

public record CabinResponse(
        long id,
        String name,
        int price,
        int size,
        List<LocalDate> availableDates
) {
}
