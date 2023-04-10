package com.example.projektpowtorzeniowy.controllers;

import com.example.projektpowtorzeniowy.model.Product;
import com.example.projektpowtorzeniowy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {


    ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/produkty")
    public List<Product> getAllOfProducts()
    {
        return productService.getAllProducts();
    }

}
