package com.example.stugbokning_be.model;

public record AdminModel(
        long id,
        String name,
        String username,
        String password
) {
}
