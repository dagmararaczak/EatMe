package com.eatMe.entities;

import javax.persistence.*;

import java.util.Set;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  Id;
    @Column(unique = true,nullable = false)
    private String name;

    @Column(nullable = true)
    private String phoneNumber;
    @Column(nullable = true)
    private String email;
    @Column(nullable = true)
    private String googleMap;

    @OneToOne(mappedBy = "restaurant")
    private Adres adres;

    @ElementCollection(targetClass = MealType.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "restaurant_meal", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "meal_type", nullable = true)
    @Enumerated(EnumType.STRING)
   private Set<MealType> mealType;

    @ElementCollection(targetClass = Cuisine.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "restaurant_cuisine", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "cuisine", nullable = true)
    private Set<Cuisine> cuisine;

    @OneToOne(fetch = FetchType.EAGER)
    private Menu menu;


    private Restaurant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getId() {
        return Id;
    }

    public Set<Cuisine> getCuisine() {
        return cuisine;
    }

    public void setCuisine(Set<Cuisine> cuisine) {
        this.cuisine = cuisine;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Set<MealType> getMealType() {
        return mealType;
    }

    public String getGoogleMap() {
        return googleMap;
    }

    public void setGoogleMap(String googleMap) {
        this.googleMap = googleMap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMealType(Set<MealType> mealType) {
        this.mealType = mealType;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
}
