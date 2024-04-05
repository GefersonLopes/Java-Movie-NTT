package com.ntt.movie.model.dto;

public class AddressRequestDTO {
    private Long user_id;
    private String zipCode;

    public AddressRequestDTO() {
    }

    public AddressRequestDTO(String zipCode) {
        this.user_id = this.getUser_id();
        this.zipCode = this.getZipCode();
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long id) {
        this.user_id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
