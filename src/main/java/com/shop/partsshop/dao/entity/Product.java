package com.shop.partsshop.dao.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String name;
    private String category;
    private float price;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="product")
    public List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Product(String name, String category, float price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Product() {
    }
}
