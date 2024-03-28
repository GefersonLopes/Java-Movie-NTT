package com.ntt.movie.model.dto;

import java.util.List;

public class MovieDTO {
    private Long id;

    private String title;

    private GenreDTO genre;

    private StudioDTO studio;

    private FranchiseDTO franchise;

    private List<DirectorDTO> directors;

    private StreamingDTO streaming;

    private List<ActorDTO> actors;

    public MovieDTO() {
    }

    public MovieDTO(String title, GenreDTO genre, StudioDTO studio, FranchiseDTO franchise, List<DirectorDTO> directors, StreamingDTO streaming, List<ActorDTO> actors) {
        this.id = this.getId();
        this.title = this.getTitle();
        this.genre = this.getGenre();
        this.studio = this.getStudio();
        this.franchise = this.getFranchise();
        this.directors = this.getDirectors();
        this.streaming = this.getStreaming();
        this.actors = this.getActors();
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

    public FranchiseDTO getFranchise() {
        return franchise;
    }

    public void setFranchise(FranchiseDTO franchise) {
        this.franchise = franchise;
    }

    public List<DirectorDTO> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorDTO> directors) {
        this.directors = directors;
    }

    public StreamingDTO getStreaming() {
        return streaming;
    }

    public void setStreaming(StreamingDTO streaming) {
        this.streaming = streaming;
    }

    public List<ActorDTO> getActors() {
        return actors;
    }

    public void setActors(List<ActorDTO> actors) {
        this.actors = actors;
    }
}
