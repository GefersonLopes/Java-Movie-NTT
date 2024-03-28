package com.ntt.movie.model.dto;

import java.util.List;

public class StreamingDTO {
    private Long id;

    private String name;

    private String url;

    private List<MovieDTO> movies;

    public StreamingDTO() {
    }

    public StreamingDTO(String name, String url, List<MovieDTO> movies) {
        this.name = this.getName();
        this.url = this.getUrl();
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MovieDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }
}
