package com.ntt.movie.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ntt.movie.model.serializer.MovieSerializer;

@Entity
@Table(name = "Studio")
public class StudioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Country is required")
    private String country;

    @JsonSerialize(using = MovieSerializer.class)
    @OneToMany(mappedBy = "studio", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<MovieModel> movies;

    public StudioModel() {
    }

    public StudioModel(String name, String country, List<MovieModel> movies) {
        this.name = name;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<MovieModel> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieModel> movies) {
        this.movies = movies;
    }
}
