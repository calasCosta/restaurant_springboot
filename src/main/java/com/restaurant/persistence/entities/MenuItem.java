package com.restaurant.persistence.entities;

import jakarta.persistence.*;

@Entity
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    //No-args constructor (required by JPA)
    protected MenuItem(){}

    public MenuItem(String name, double price){
        this.name = name;
        this.price = price;
    }

    public Long getId(){ return id; }
    public String getName(){ return name; }
    public double price(){ return price; }
}
