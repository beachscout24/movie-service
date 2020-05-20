package com.bridgwater.controllers;

import com.bridgwater.models.Movie;
import com.bridgwater.respository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

    @GetMapping("/movies/{movieName}")
    public Movie getMoviesByMovie(@PathVariable String movieName) {
        Optional<Movie> movie = movieRepository.findMovieByName(movieName);
        return movie.orElse(null);
    }

    @PostMapping("/movies/movie")
    public Integer saveMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieRepository.save(movie);
        return savedMovie.getId();
    }

}
