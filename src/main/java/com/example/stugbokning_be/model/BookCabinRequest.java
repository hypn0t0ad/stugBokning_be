package com.example.stugbokning_be.model;

import java.time.LocalDate;

public record BookCabinRequest(
        long id,
        LocalDate start,
        LocalDate until
) {
}
