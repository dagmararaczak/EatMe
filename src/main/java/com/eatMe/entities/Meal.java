package com.eatMe.entities;



import javax.persistence.*;
import java.util.List;

@Entity
public class Meal {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;

    @ManyToOne
    private Menu menu;

    @OneToMany(mappedBy = "meal")
    private List<Ingredients> ingredients;

    private Meal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }
}
