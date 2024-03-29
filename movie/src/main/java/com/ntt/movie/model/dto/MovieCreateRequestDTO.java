package com.ntt.movie.model.dto;

public class MovieCreateRequestDTO {
    private String title;
    private Long franchise_id;
    private Long genre_id;
    private Long studio_id;
    private Long streaming_id;

    public MovieCreateRequestDTO() {
    }

    public MovieCreateRequestDTO(String title, Long franchise_id, Long genre_id, Long studio_id, Long streaming_id) {
        this.title = title;
        this.franchise_id = franchise_id;
        this.genre_id = genre_id;
        this.studio_id = studio_id;
        this.streaming_id = streaming_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getFranchise_id() {
        return franchise_id;
    }

    public void setFranchise_id(Long franchise_id) {
        this.franchise_id = franchise_id;
    }

    public Long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Long genre_id) {
        this.genre_id = genre_id;
    }

    public Long getStudio_id() {
        return studio_id;
    }

    public void setStudio_id(Long studio_id) {
        this.studio_id = studio_id;
    }

    public Long getStreaming_id() {
        return streaming_id;
    }

    public void setStreaming_id(Long streaming_id) {
        this.streaming_id = streaming_id;
    }

}