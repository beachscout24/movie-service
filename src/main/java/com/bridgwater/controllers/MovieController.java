package com.bridgwater.controllers;

import com.bridgwater.models.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @GetMapping("/{id}")
    public Movie getMovieInfo(@PathVariable("id") String movieId) {
        return new Movie(1, "Sneakers");
    }

}
