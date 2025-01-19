package com.example.stugbokning_be.model;

import java.time.LocalDate;

public record BokningResponse(
        CabinModel cabinModel,
        LocalDate fran,
        LocalDate till
) {
}
