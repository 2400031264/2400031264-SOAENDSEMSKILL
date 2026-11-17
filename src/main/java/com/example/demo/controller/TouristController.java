package com.example.demo.controller;

import com.example.demo.entity.Tourist;
import com.example.demo.repository.TouristRepository;
import com.example.demo.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/tourists")
public class TouristController {
    private final TouristRepository repository;
    private final TokenService tokenService;

    public TouristController(TouristRepository repository, TokenService tokenService) {
        this.repository = repository;
        this.tokenService = tokenService;
    }

    @PutMapping("/{id}")
    public Tourist updateTourist(
            @PathVariable Integer id,
            @RequestHeader("Authorization") String token,
            @RequestBody Tourist request) {

        if (!tokenService.validateToken(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid token");
        }

        Tourist existing = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Tourist not found"));

        existing.setName(request.getName());
        existing.setCity(request.getCity());
        existing.setBudget(request.getBudget());

        return repository.save(existing);
    }
}
