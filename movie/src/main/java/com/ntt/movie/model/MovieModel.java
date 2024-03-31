package com.ntt.movie.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ntt.movie.model.serializer.ActorSerializer;
import com.ntt.movie.model.serializer.DirectorSerializer;
import com.ntt.movie.model.serializer.FranchiseSerializer;
import com.ntt.movie.model.serializer.GenreSerializer;
import com.ntt.movie.model.serializer.StreamingSerializer;
import com.ntt.movie.model.serializer.StudioSerializer;

@Entity
@Table(name = "Movie")
public class MovieModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

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

    @JsonSerialize(using = FranchiseSerializer.class)
    @NotNull(message = "Franchise is required")
    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "franchise_id")
    private FranchiseModel franchise;

    @JsonSerialize(using = StreamingSerializer.class)
    @NotNull(message = "Streaming is required")
    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "streaming_id")
    private StreamingModel streaming;

    @JsonSerialize(using = DirectorSerializer.class)
    @ManyToMany(mappedBy = "movies", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<DirectorModel> directors;

    @JsonSerialize(using = ActorSerializer.class)
    @ManyToMany(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<ActorModel> actors;

    public MovieModel() {
    }

    public MovieModel(String title, GenreModel genre, StudioModel studio, FranchiseModel franchise, List<DirectorModel> directors, StreamingModel streaming, List<ActorModel> actors) {
        this.title = title;
        this.genre = genre;
        this.studio = studio;
        this.franchise = franchise;
        this.directors = directors;
        this.streaming = streaming;
        this.actors = actors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public FranchiseModel getFranchise() {
        return franchise;
    }

    public void setFranchise(FranchiseModel franchise) {
        this.franchise = franchise;
    }

    public List<DirectorModel> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorModel> directors) {
        this.directors = directors;
    }

    public StreamingModel getStreaming() {
        return streaming;
    }

    public void setStreaming(StreamingModel streaming) {
        this.streaming = streaming;
    }

    public List<ActorModel> getActors() {
        return actors;
    }

    public void setActors(List<ActorModel> actors) {
        this.actors = actors;
    }
}
