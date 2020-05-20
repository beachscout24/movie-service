package com.bridgwater.respository;

import com.bridgwater.models.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
    @Query(value = "SELECT * FROM movie m WHERE m.name = ?1",
            nativeQuery = true)
    Optional<Movie> findMovieByName(String name);
}
