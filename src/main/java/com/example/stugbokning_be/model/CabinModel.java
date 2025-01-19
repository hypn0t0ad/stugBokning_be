package com.example.stugbokning_be.model;

public record CabinModel(
        long id,
        String name,
        int price,
        int size
) {
}
