package com.example.stugbokning_be.model;

public record AdminRequest(
        String name,
        String username,
        String password
) {
}
