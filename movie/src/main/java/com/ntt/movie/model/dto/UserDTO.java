package com.ntt.movie.model.dto;

import java.util.List;

import com.ntt.movie.model.UserModel;

public class UserDTO {
    private Long id;

    private String name;

    private String username;

    private String email;

    private List<RoleDTO> roles;

    private List<MovieDTO> favoritesMovies;

    public UserDTO() {
    }

    public UserDTO(UserModel userDto) {
        this.id = userDto.getId();
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.username = userDto.getUsername();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    public List<MovieDTO> getFavoritesMovies() {
        return favoritesMovies;
    }

    public void setFavoritesMovies(List<MovieDTO> favoritesMovies) {
        this.favoritesMovies = favoritesMovies;
    }
}
