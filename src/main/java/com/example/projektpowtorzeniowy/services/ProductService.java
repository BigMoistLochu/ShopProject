package com.example.projektpowtorzeniowy.services;

import com.example.projektpowtorzeniowy.model.Product;
import com.example.projektpowtorzeniowy.repository.RepositoryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private RepositoryProvider repositoryProvider;

    @Autowired
    public ProductService(RepositoryProvider repositoryProvider) {
        this.repositoryProvider = repositoryProvider;
    }


    public Iterable<Product> getAllProducts()
    {
        return repositoryProvider.getProductRepository().findAll();
    }

    public Optional<Product> getProductById(Long id)
    {
        return repositoryProvider.getProductRepository().findById(id);
    }

    public void addProduct(Product product)
    {
        repositoryProvider.getProductRepository().save(product);
    }

    public void deleteProduct(Long id)
    {
        repositoryProvider.getProductRepository().deleteById(id);
    }
}
