package com.saladbar.microservice2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5173")
public class QuoteController {

    @GetMapping("/quote")
    public ResponseEntity<Quote> getQuote() {
        String url = "https://api.forismatic.com/api/1.0/?method=getQuote&key=457653&format=json&lang=en";
        RestTemplate restTemplate = new RestTemplate();

        Quote response = restTemplate.getForObject(url, Quote.class);
        return ResponseEntity.ok(response != null ? response : null);
    }



}
