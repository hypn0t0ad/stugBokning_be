package com.example.stugbokning_be.model;

public record LoginRequest(
        String username,
        String password
) {
}
