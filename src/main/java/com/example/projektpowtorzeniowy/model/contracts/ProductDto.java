package com.example.projektpowtorzeniowy.model.contracts;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ProductDto {


    private int id;
    private String title;

    private double price;

    private String image;

}
