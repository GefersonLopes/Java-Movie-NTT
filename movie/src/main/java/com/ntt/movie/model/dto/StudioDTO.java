package com.ntt.movie.model.dto;

import java.util.List;

public class StudioDTO {

    private Long id;

    private String name;

    private String country;

    private List<MovieDTO> movies;

    public StudioDTO() {
    }

    public StudioDTO(String name, String country, List<MovieDTO> movies) {
        this.name = this.getName();
        this.country = this.getCountry();
        this.movies = this.getMovies();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<MovieDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }
}
