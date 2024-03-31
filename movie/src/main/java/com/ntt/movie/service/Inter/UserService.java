package com.ntt.movie.service.Inter;

import java.util.List;
import java.util.Optional;

import com.ntt.movie.model.UserModel;
import com.ntt.movie.model.dto.FavoritesMovieDirectorToUserDTO;

public interface UserService {
    UserModel create(UserModel user);

    List<UserModel> getAll();

    Optional<UserModel> getById(Long id);

    UserModel updateById(Long id, UserModel user);
    
    void delete(Long id);

    UserModel setFavoritesMovies(Long id, FavoritesMovieDirectorToUserDTO itemsFavorite);
}
