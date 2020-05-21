package com.bridgwater.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ApiModel("Details of a Movie Object")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty("The id of a movie")
    private Integer id;
    @ApiModelProperty("The movieid of a movie")
    private String movieId;
    @ApiModelProperty("The name of a movie")
    private String name;
    @ApiModelProperty("The description of a movie")
    private String description;
    @ApiModelProperty("The rating of a movie")
    private Integer rating;

    public Movie() {
        super();
    }

    public Movie(String movieId, String title, String overview, Integer rating) {
        super();
        this.movieId = movieId;
        this.name = title;
        this.description = overview;
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
