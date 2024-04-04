package com.ntt.movie.service.facades;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ntt.movie.config.ModelMapperConfig;
import com.ntt.movie.handler.exception.ExceptionBadRequest;
import com.ntt.movie.handler.exception.ExceptionNotFound;
import com.ntt.movie.model.DirectorModel;
import com.ntt.movie.model.MovieModel;
import com.ntt.movie.model.UserModel;
import com.ntt.movie.model.dto.FavoritesMovieDirectorToUserDTO;
import com.ntt.movie.model.dto.UserDTO;
import com.ntt.movie.repository.DirectorRepository;
import com.ntt.movie.repository.MovieRepository;
import com.ntt.movie.repository.UserRepository;
import com.ntt.movie.service.Inter.UserService;

@Service
public class DefaultUserFacade implements UserFacade {
  
  private final UserService userService;
  private final UserRepository userRepository;
  private final MovieRepository movieRepository;
  private final DirectorRepository directorRepository;

  public DefaultUserFacade(
    UserService userService,
    UserRepository userRepository, 
    MovieRepository movieRepository,
    DirectorRepository directorRepository
    ) {
    this.userService = userService;
    this.userRepository = userRepository;
    this.movieRepository = movieRepository;
    this.directorRepository = directorRepository;
  }
  
  @Override
  public UserDTO create(UserDTO user) {
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

    UserModel userModel = new UserModel();

    userModel.setName(user.getName());
    userModel.setEmail(user.getEmail());
    userModel.setUsername(user.getUsername());
    userModel.setPassword(user.getPassword());

    populateUser(user, userModel);
    userService.create(userModel);

    return user;
  }

  @Override
  public List<UserDTO> getAll() {
    List<UserModel> users = userService.getAll();
    List<UserDTO> usersDTO = new ArrayList<>();

    for (UserModel user : users) {
        UserDTO userDTO = new UserDTO();
        populateUser(userDTO, user);
        usersDTO.add(userDTO);
    }

    return usersDTO;
  }

  @Override
  public Optional<UserDTO> getById(Long id) {
    Optional<UserModel> userRepo = userService.getById(id);
    UserModel user = userRepo.get();

    ModelMapperConfig mapperConfig = new ModelMapperConfig();
    UserDTO userDTO = mapperConfig.modelMapper().map(user, UserDTO.class);
    populateUser(userDTO, user);

    Optional<UserDTO> userDTOOptional = Optional.of(userDTO);
    return userDTOOptional;
  }

  @Override
  public UserDTO updateById(Long id, UserDTO user) {
    Optional<UserModel> userModel = userService.getById(id);
    UserModel userToUpdate = userModel.get();

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

    populateUser(user, userToUpdate);
    userService.updateById(id, userToUpdate);  

    return user;
  }

  @Override
  public void delete(Long id) {
    Optional<UserModel> userRepo = userService.getById(id);
    UserModel userToDelete = userRepo.get();
    userService.delete(userToDelete.getId());
  }

  @Override
  public UserDTO setFavoritesMovies(Long id, FavoritesMovieDirectorToUserDTO itemsFavorite) {
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
    
    UserDTO userDTO = new UserDTO();
    populateUser(userDTO, user);

    userRepository.save(user);

    return userDTO;
  }

  private void populateUser(UserDTO user, UserModel userModel) {
    user.setId(userModel.getId());
    user.setName(userModel.getName());
    user.setEmail(userModel.getEmail());
    user.setUsername(userModel.getUsername());
    user.setPassword(userModel.getPassword());
}
}
