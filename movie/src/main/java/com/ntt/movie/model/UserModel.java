package com.ntt.movie.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ntt.movie.model.dto.UserDTO;
import com.ntt.movie.model.serializer.DirectorSerializer;
import com.ntt.movie.model.serializer.MovieSerializer;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "User")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Email is required")
    private String email;

    @JsonProperty(access = Access.WRITE_ONLY)
    @NotBlank(message = "Password is required")
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<RoleModel> roles;

    @JsonSerialize(using = MovieSerializer.class)
    @ManyToMany(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<MovieModel> favoritesMovies;

    @JsonSerialize(using = DirectorSerializer.class)
    @ManyToMany(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<DirectorModel> favoritesDirectors;

    public UserModel() {
    }

    public UserModel(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.username = userDTO.getUsername();
        this.password = userDTO.getPassword();
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
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleModel> roles) {
        this.roles = roles;
    }

    public List<MovieModel> getFavoritesMovies() {
        return favoritesMovies;
    }

    public void setFavoritesMovies(List<MovieModel> favoritesMovies) {
        this.favoritesMovies = favoritesMovies;
    }

    public List<DirectorModel> getFavoritesDirectors() {
        return favoritesDirectors;
    }

    public void setFavoritesDirectors(List<DirectorModel> favoritesDirectors) {
        this.favoritesDirectors = favoritesDirectors;
    }

    @PrePersist
    protected void hashPassword() {
        this.password = new BCryptPasswordEncoder().encode(this.password);
    }
}
