package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class TokenService {
    // Demo token only. Replace with signed JWT verification in production.
    private static final String VALID_TOKEN = "my-secret-token";

    public boolean validateToken(String token) {
        return VALID_TOKEN.equals(token);
    }
}
