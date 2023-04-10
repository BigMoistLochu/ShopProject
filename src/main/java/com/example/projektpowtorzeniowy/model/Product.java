package com.example.projektpowtorzeniowy.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int idOfProduct;
    private String title;

    private double price;

    private String image;


    public Product() {

    }


    public Product(int idOfProduct, String title, double price, String image) {
        this.idOfProduct = idOfProduct;
        this.title = title;
        this.price = price;
        this.image = image;
    }


}
