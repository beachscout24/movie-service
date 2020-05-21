package com.bridgwater.controllers;

import com.bridgwater.accessor.Accessor;
import com.bridgwater.models.Movie;
import com.bridgwater.models.MovieSummary;
import com.bridgwater.respository.MovieRepository;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    Accessor accessor;

    @GetMapping("/movies")
    @ApiOperation(value = "Get complete list of movies",
            notes = "Retrieve the complete list of movies",
            response = List.class)
    public List<Movie> getMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

    @GetMapping("/movies/{movieId}")
    @ApiOperation(value = "Finds a movie by id",
            notes = "Provide an Id to look up a specific movie",
            response = Movie.class)
    public Movie getMoviesByMovie(@PathVariable String movieId) {
        log.info("Getting movie from themoviedb.org");
        MovieSummary movieSummary = restTemplate.getForObject(accessor.movieDBUrl + movieId + accessor.apiKey, MovieSummary.class);
        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview(), (movieSummary.getRating() == null) ? 5 : movieSummary.getRating());
    }

    @PostMapping("/movies/movie")
    @ApiOperation(value = "Save a given movie",
            notes = "Provide a specific movie and returns it's id",
            response = Integer.class)
    public Integer saveMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieRepository.save(movie);
        return savedMovie.getId();
    }
}
