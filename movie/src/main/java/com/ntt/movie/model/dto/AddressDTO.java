package com.ntt.movie.model.dto;

import com.ntt.movie.model.UserModel;

public class AddressDTO {
    private Long id;

    private String street;

    private String city;

    private String state;

    private String zipCode;

    private UserModel user;

    public AddressDTO() {
    }

    public AddressDTO(String street, String city, String state, String zipCode, UserModel user) {
        this.id = this.getId();
        this.street = this.getStreet();
        this.city = this.getCity();
        this.state = this.getState();
        this.zipCode = this.getZipCode();
        this.user = this.getUser();
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
