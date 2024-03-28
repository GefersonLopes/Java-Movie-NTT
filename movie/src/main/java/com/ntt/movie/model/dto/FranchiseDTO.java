package com.ntt.movie.model.dto;

import java.util.List;

public class FranchiseDTO {

    private Long id;

    private String name;

    private GenreDTO genre;

    private StudioDTO studio;

    private List<MovieDTO> movies;

    public FranchiseDTO() {
    }

    public FranchiseDTO(String name, GenreDTO genre, StudioDTO studio, List<MovieDTO> movies) {
        this.id = this.getId();
        this.name = this.getName();
        this.genre = this.getGenre();
        this.studio = this.getStudio();
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

    public GenreDTO getGenre() {
        return genre;
    }

    public void setGenre(GenreDTO genre) {
        this.genre = genre;
    }

    public StudioDTO getStudio() {
        return studio;
    }

    public void setStudio(StudioDTO studio) {
        this.studio = studio;
    }

    public List<MovieDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }
}
