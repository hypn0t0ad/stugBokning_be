package com.example.stugbokning_be.model;

import java.time.LocalDate;
import java.util.List;

public record StugaResponse(
        long id,
        String namn,
        int pris,
        int storlek,
        List<LocalDate> bokadeDatum
) {
}
