package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Tourist {
    @Id
    private Integer id;
    private String name;
    private String city;
    private double budget;

    public Tourist() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }
}
