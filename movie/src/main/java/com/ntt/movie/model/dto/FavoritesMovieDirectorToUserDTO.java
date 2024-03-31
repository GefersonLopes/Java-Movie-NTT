package com.ntt.movie.model.dto;

public class FavoritesMovieDirectorToUserDTO {
  private Long favorite_movie_id;
  
	private Long favorite_director;

  public FavoritesMovieDirectorToUserDTO() {
  }

  public FavoritesMovieDirectorToUserDTO(Long favorite_movie_id, Long favorite_director) {
      this.favorite_movie_id = this.getFavorite_movie_id();
      this.favorite_director = this.getFavorite_director();
  }

  public Long getFavorite_movie_id() {
      return favorite_movie_id;
  }

  public void setFavorite_movie_id(Long favorite_movie_id) {
      this.favorite_movie_id = favorite_movie_id;
  }

  public Long getFavorite_director() {
      return favorite_director;
  }

  public void setFavorite_director(Long favorite_director) {
      this.favorite_director = favorite_director;
  }

}
