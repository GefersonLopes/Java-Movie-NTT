package com.ntt.movie.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ntt.movie.model.serializer.MovieSerializer;

@Entity
@Table(name = "Streaming")
public class StreamingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "URL is required")
    private String url;

    @JsonSerialize(using = MovieSerializer.class)
    @OneToMany(mappedBy = "streaming", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<MovieModel> movies;

    public StreamingModel() {
    }

    public StreamingModel(String name, String url, List<MovieModel> movies) {
        this.name = name;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MovieModel> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieModel> movies) {
        this.movies = movies;
    }
}
