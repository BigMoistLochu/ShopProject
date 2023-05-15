package com.example.projektpowtorzeniowy.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Builder;
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
    @Column(unique = true)
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

    public Product(String title, double price, String image) {
        this.title = title;
        this.price = price;
        this.image = image;
    }

    @Builder
    public static Product getInstance(String title,double price,String image)
    {
        return new Product(title,price,image);
    }




}
