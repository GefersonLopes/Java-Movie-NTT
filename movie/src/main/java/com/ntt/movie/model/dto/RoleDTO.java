package com.ntt.movie.model.dto;

public class RoleDTO {
  private Long id;

  private String name;

  public RoleDTO() {}
  
  public RoleDTO(Long id, String name) {
    this.id = this.getId();
    this.name = this.getName();
  };

  public String getName() {
    return name;
  }

  public Long getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(Long id) {
    this.id = id;
  }
}