package com.example.projektpowtorzeniowy.repository;

import com.example.projektpowtorzeniowy.repository.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryProvider implements IRepositoryProvider{


    ProductRepository productRepository;

    @Autowired
    public RepositoryProvider(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }



    @Override
    public ProductRepository getProductRepository() {
        return productRepository;
    }
}
