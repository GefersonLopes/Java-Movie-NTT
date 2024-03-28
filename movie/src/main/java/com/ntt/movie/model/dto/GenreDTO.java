package com.ntt.movie.model.dto;

public class GenreDTO {
    private Long id;

    private String name;

    public GenreDTO() {
    }

    public GenreDTO(String name) {
        this.id = this.getId();
        this.name = this.getName();
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
}
