package com.example.projektpowtorzeniowy.services;

import com.example.projektpowtorzeniowy.model.Product;
import com.example.projektpowtorzeniowy.repository.RepositoryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    RepositoryProvider repositoryProvider;

    @Autowired
    public ProductService(RepositoryProvider repositoryProvider) {
        this.repositoryProvider = repositoryProvider;
    }


    public List<Product> getAllProducts()
    {
        return repositoryProvider.getProductRepository().findAll();
    }
}
