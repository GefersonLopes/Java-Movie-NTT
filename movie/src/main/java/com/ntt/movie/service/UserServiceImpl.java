package com.ntt.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.movie.handler.exception.ExceptionBadRequest;
import com.ntt.movie.handler.exception.ExceptionNotFound;
import com.ntt.movie.model.DirectorModel;
import com.ntt.movie.model.MovieModel;
import com.ntt.movie.model.UserModel;
import com.ntt.movie.model.dto.FavoritesMovieDirectorToUserDTO;
import com.ntt.movie.repository.DirectorRepository;
import com.ntt.movie.repository.MovieRepository;
import com.ntt.movie.repository.UserRepository;
import com.ntt.movie.service.Inter.UserService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    @Transactional
    public UserModel create(@Valid @NotNull UserModel user) {
        if(user.getId() != null) {
            throw new ExceptionBadRequest("id not allowed.");
        }

        if(user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new ExceptionBadRequest("Email is required");
        }

        if(userRepository.existsByEmail(user.getEmail())){
            throw new ExceptionBadRequest("Email already exists");
        }

        if(user.getUsername() == null || user.getUsername().isEmpty()){
            throw new ExceptionBadRequest("Username is required");
        }

        if(userRepository.existsByUsername(user.getUsername())){
            throw new ExceptionBadRequest("Username already exists");
        }

        if(user.getName() == null || user.getName().isEmpty()) {
            throw new ExceptionBadRequest("Name is required");
        }

        if(user.getPassword() == null || user.getPassword().isEmpty()){
            throw new ExceptionBadRequest("Password is required");
        }

        return userRepository.save(user);
    }

    @Override
    public List<UserModel> getAll() {
        return userRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Optional<UserModel> getById(@Valid @NotNull Long id) {
        return Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("User not found with id: " + id)));
    }

    @SuppressWarnings("null")
    @Override
    public UserModel updateById(Long id, UserModel user) {
        UserModel userToUpdate = userRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("User not found with id: " + id));
        
        if (user.getName() == null || user.getName().isEmpty()) {
            user.setName(userToUpdate.getName());
        }

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            user.setEmail(userToUpdate.getEmail());
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            user.setPassword(userToUpdate.getPassword());
        }

        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            user.setUsername(userToUpdate.getUsername());
        }
        
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setUsername(user.getUsername());
        
        return userRepository.save(userToUpdate);
    }

    @SuppressWarnings("null")
    @Override
    public void delete(@Valid @NotNull Long id) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("User not found with id: " + id));
        userRepository.deleteById(user.getId());
    }

    @SuppressWarnings("null")
    @Override
    public UserModel setFavoritesMovies(Long id, FavoritesMovieDirectorToUserDTO itemsFavorite) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("User not found with id: " + id));
        MovieModel movie = movieRepository.findById(itemsFavorite.getFavorite_movie_id()).orElseThrow(() -> new ExceptionNotFound("Movie not found with id: " + itemsFavorite.getFavorite_movie_id()));
        DirectorModel director = directorRepository.findById(itemsFavorite.getFavorite_director()).orElseThrow(() -> new ExceptionNotFound("Director not found with id: " + itemsFavorite.getFavorite_director()));
        
        List<MovieModel> favoritesMovies = user.getFavoritesMovies();
        List<DirectorModel> favoritesDirectors = user.getFavoritesDirectors();

        if(favoritesMovies.contains(movie) || favoritesDirectors.contains(director)){
            throw new ExceptionBadRequest("Movie or Director already exists in favorites");
        }

        favoritesMovies.add(movie);
        favoritesDirectors.add(director);

        user.setFavoritesMovies(favoritesMovies);
        user.setFavoritesDirectors(favoritesDirectors);
        
        return userRepository.save(user);
    }        
}
