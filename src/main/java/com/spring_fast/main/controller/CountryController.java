package com.spring_fast.main.controller;

import com.spring_fast.main.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/france")
    public ResponseEntity<Country> getFrance() {
        Country country = Country.of("France", 67_000_000);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent","Europe")
                .header("capital", "Paris")
                .body(country);
    }

    @GetMapping("/all")
    public List<Country> getAll() {
        Country france = Country.of("France", 67_000_000);
        Country spain = Country.of("Spain", 46_000_000);

        return List.of(france, spain);
    }
}
