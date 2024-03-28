package com.ntt.movie.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "Franchise")
public class FranchiseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Genre is required")
    @Valid
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreModel genre;

    @NotNull(message = "Studio is required")
    @Valid
    @ManyToOne
    @JoinColumn(name = "studio_id")
    private StudioModel studio;

    @NotNull(message = "Movies are required")
    @Valid
    @OneToMany(mappedBy = "franchise")
    private List<MovieModel> movies;

    public FranchiseModel() {
    }

    public FranchiseModel(String name, GenreModel genre, StudioModel studio, List<MovieModel> movies) {
        this.name = name;
        this.genre = genre;
        this.studio = studio;
        this.movies = movies;
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

    public GenreModel getGenre() {
        return genre;
    }

    public void setGenre(GenreModel genre) {
        this.genre = genre;
    }

    public StudioModel getStudio() {
        return studio;
    }

    public void setStudio(StudioModel studio) {
        this.studio = studio;
    }

    public List<MovieModel> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieModel> movies) {
        this.movies = movies;
    }
}
