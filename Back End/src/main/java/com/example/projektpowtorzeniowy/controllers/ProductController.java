package com.example.projektpowtorzeniowy.controllers;

import com.example.projektpowtorzeniowy.exceptions.ProduktNotFoundException;
import com.example.projektpowtorzeniowy.model.Product;
import com.example.projektpowtorzeniowy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class ProductController {


    ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }




    @GetMapping("/produkty")
    public Iterable<Product> getAllOfProducts()
    {
        return productService.getAllProducts();
    }


    @GetMapping("/produkty/{id}")
    public Product getProductById(@PathVariable Long id)
    {
        return productService.getProductById(id).orElseThrow(() -> new ProduktNotFoundException(id));
    }

    @PostMapping("/produkty/add")
    public void  addProductToDataBaseMemory(@RequestBody Product product)
    {
        productService.addProduct(product);
    }




    @DeleteMapping("/produkty/delete/{id}")
    public void  deleteProductToDataBaseMemory(@PathVariable Long id)
    {
        productService.deleteProduct(id);
    }



}
