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
    private List<Ingriedients> ingriedients;

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

/*    public List<String> getIngriedients() {
        return ingriedients;
    }

    public void setIngriedients(List<String> ingriedients) {
        this.ingriedients = ingriedients;
    }*/
}
