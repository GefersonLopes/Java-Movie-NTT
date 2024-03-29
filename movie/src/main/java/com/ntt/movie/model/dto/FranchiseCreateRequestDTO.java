package com.ntt.movie.model.dto;

public class FranchiseCreateRequestDTO {
  private String name;
  private Long genre_id;
  private Long studio_id;

  public FranchiseCreateRequestDTO() {
  }

  public FranchiseCreateRequestDTO(String name, Long genre_id, Long studio_id) {
    this.name = name;
    this.genre_id = genre_id;
    this.studio_id = studio_id;
  }
    
  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
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

}
