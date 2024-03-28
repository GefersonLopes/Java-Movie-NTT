package com.ntt.movie.model.dto;

import java.util.List;

public class ActorDTO {
    private Long id;

    private String name;

    private List<MovieDTO> movies;

    public ActorDTO() {
    }

    public ActorDTO(String name, List<MovieDTO> movies) {
        this.id = this.getId();
        this.name = this.getName();
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

    public List<MovieDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }
}
