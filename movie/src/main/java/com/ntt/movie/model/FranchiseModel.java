package com.ntt.movie.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ntt.movie.model.serializer.GenreSerializer;
import com.ntt.movie.model.serializer.MovieSerializer;
import com.ntt.movie.model.serializer.StudioSerializer;

@Entity
@Table(name = "Franchise")
public class FranchiseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @JsonSerialize(using = GenreSerializer.class)
    @NotNull(message = "Genre is required")
    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "genre_id")
    private GenreModel genre;

    @JsonSerialize(using = StudioSerializer.class)
    @NotNull(message = "Studio is required")
    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "studio_id")
    private StudioModel studio;

    @JsonSerialize(using = MovieSerializer.class)
    @OneToMany(mappedBy = "franchise", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
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
