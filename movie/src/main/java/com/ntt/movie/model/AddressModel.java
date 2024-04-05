package com.ntt.movie.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ntt.movie.model.serializer.UserSerializer;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Address")
public class AddressModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String street;

  private String city;

  private String state;

  private String zipCode;

  @JsonSerialize(using = UserSerializer.class)
  @NotNull(message = "User is required")
  @Valid
  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserModel user;

  public AddressModel() {
  }

  public AddressModel(String street, String city, String state, String zipCode, UserModel user) {
    this.street = street;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
    this.user = user;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public UserModel getUser() {
    return user;
  }

  public void setUser(UserModel user) {
    this.user = user;
  }
}
