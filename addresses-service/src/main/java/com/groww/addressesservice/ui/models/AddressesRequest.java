package com.groww.addressesservice.ui.models;

public class AddressesRequest {
    private String city;
    private int userId;
    private String country;

    public String getCity() {
        return city;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
