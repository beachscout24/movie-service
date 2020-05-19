package com.bridgwater.controllers;

import com.bridgwater.models.Movie;
import com.bridgwater.respository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/{id}")
    public Movie getMovieInfo(@PathVariable("id") String id) {
        return new Movie(1, "Sneakers");
    }

    @PostMapping("/movie")
    public Integer saveMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieRepository.save(movie);
        return savedMovie.getId();
    }

}
