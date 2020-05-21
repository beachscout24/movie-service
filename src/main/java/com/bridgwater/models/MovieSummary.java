package com.bridgwater.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

@Component
@ApiModel("Details of the Movie Summary Object")
public class MovieSummary {

    @ApiModelProperty("The title of a movie")
    private String title;
    @ApiModelProperty("The overview of a movie")
    private String overview;
    @ApiModelProperty("The rating of a movie")
    private Integer rating;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
