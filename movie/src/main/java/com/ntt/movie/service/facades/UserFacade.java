package com.ntt.movie.service.facades;

import java.util.List;
import java.util.Optional;

import com.ntt.movie.model.dto.FavoritesMovieDirectorToUserDTO;
import com.ntt.movie.model.dto.UserDTO;

public interface UserFacade {
    UserDTO create(UserDTO user);

    List<UserDTO> getAll();

    Optional<UserDTO> getById(Long id);

    UserDTO updateById(Long id, UserDTO user);

    void delete(Long id);

    UserDTO setFavoritesMovies(Long id, FavoritesMovieDirectorToUserDTO itemsFavorite);
}
