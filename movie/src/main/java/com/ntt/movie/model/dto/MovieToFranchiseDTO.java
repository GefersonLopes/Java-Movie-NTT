package com.ntt.movie.model.dto;

public class MovieToFranchiseDTO {
  private Long movie_id;
  
  private Long franchise_id;

  public MovieToFranchiseDTO() {
  }

  public MovieToFranchiseDTO(Long movie_id, Long franchise_id) {
      this.movie_id = this.getMovie_id();
      this.franchise_id = this.getFranchise_id();
  }

  public Long getMovie_id() {
      return movie_id;
  }

  public void setMovie_id(Long movie_id) {
      this.movie_id = movie_id;
  }

  public Long getFranchise_id() {
      return franchise_id;
  }

  public void setFranchise_id(Long franchise_id) {
      this.franchise_id = franchise_id;
  } 
}
