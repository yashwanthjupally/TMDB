package com.movieDB.IMBD.controller;

import com.movieDB.IMBD.model.Rating;
import com.movieDB.IMBD.model.RatingRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api/public")
@Slf4j
public class publicController {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${ratings-service.url}")
    private String ratingsServiceUrl;

    @PostMapping
    public ResponseEntity<Object> addRating(@RequestBody RatingRequest ratingRequest) {
        Rating rating;

        try {
            rating = restTemplate.postForObject(ratingsServiceUrl, ratingRequest, Rating.class);
            return ResponseEntity.ok(rating);
        } catch (HttpStatusCodeException ex) {
//            log.error("Error adding rating: {}", ex.getMessage());
            return ResponseEntity.status(ex.getStatusCode())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(ex.getResponseBodyAsString());
        }
    }
}