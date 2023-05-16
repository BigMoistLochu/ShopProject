package com.example.projektpowtorzeniowy.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    private String email;

    public Customer(){}

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }


    @Builder
    public static Customer getInstance(String name,String email)
    {
        return new Customer(name,email);
    }


}
