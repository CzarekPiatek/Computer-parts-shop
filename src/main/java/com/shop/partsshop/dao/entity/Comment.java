package com.shop.partsshop.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String comment;

    public Comment(String comment) {
        this.comment = comment;
    }
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id")
    @JsonIgnoreProperties("comments")
    public Product product;

    public Product getProduct() {
        return product;
    }

    public Comment(String comment, Product product) {
        this.comment = comment;
        this.product = product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
