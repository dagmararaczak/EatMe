package com.eatMe.entities;


import javax.persistence.*;

@Entity
public class Adres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String city;

    private String houseNumber;

    private String postCode;

    @OneToOne
    private Restaurant restaurant;

    public Adres(String street, String city, String houseNumber, String postCode) {
        this.street = street;
        this.city = city;
        this.houseNumber = houseNumber;
        this.postCode = postCode;
    }

    public Adres() {
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

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
