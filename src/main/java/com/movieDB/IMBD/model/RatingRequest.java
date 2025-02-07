package com.movieDB.IMBD.model;

import lombok.Data;

@Data
public class RatingRequest {
    private String name;
    private double stars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }
}
