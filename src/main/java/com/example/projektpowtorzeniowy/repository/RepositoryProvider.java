package com.example.projektpowtorzeniowy.repository;

import com.example.projektpowtorzeniowy.repository.repositories.AnimalRepository;
import com.example.projektpowtorzeniowy.repository.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryProvider implements IRepositoryProvider{

    AnimalRepository animalRepository;
    ProductRepository productRepository;

    @Autowired
    public RepositoryProvider(AnimalRepository animalRepository, ProductRepository productRepository) {
        this.animalRepository = animalRepository;
        this.productRepository = productRepository;
    }

    @Override
    public AnimalRepository getAnimalRepository() {
        return animalRepository;
    }

    @Override
    public ProductRepository getProductRepository() {
        return productRepository;
    }
}
