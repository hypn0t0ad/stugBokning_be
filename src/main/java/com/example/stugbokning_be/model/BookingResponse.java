package com.example.stugbokning_be.model;

import java.time.LocalDate;

public record BookingResponse(
        CabinModel cabinModel,
        LocalDate fran,
        LocalDate till
) {
}
