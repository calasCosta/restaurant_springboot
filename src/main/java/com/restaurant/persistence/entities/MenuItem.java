package com.restaurant.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Positive(message = "Price must be positive")
    private double price;

    //No-args constructor (required by JPA)
    protected MenuItem(){}

    public MenuItem(String name, double price){
        this.name = name;
        this.price = price;
    }

    public Long getId(){ return id; }
    public String getName(){ return name; }
    public double getPrice(){ return price; }

    // Setters (needed for updates)
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
}
