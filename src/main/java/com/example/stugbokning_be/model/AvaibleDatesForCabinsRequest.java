package com.example.stugbokning_be.model;

import java.time.LocalDate;

public record AvaibleDatesForCabinsRequest(
        LocalDate fran,
        LocalDate till
) {
}
