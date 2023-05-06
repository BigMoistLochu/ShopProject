package com.example.projektpowtorzeniowy.repository;


import com.example.projektpowtorzeniowy.repository.repositories.ProductRepository;

public interface IRepositoryProvider {

    ProductRepository getProductRepository();

}
