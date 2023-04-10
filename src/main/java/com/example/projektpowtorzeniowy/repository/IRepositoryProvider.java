package com.example.projektpowtorzeniowy.repository;


import com.example.projektpowtorzeniowy.repository.repositories.AnimalRepository;
import com.example.projektpowtorzeniowy.repository.repositories.ProductRepository;

public interface IRepositoryProvider {

    AnimalRepository getAnimalRepository();
    ProductRepository getProductRepository();

}
