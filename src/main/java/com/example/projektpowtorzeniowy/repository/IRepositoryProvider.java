package com.example.projektpowtorzeniowy.repository;


import com.example.projektpowtorzeniowy.repository.repositories.CustomerRepository;
import com.example.projektpowtorzeniowy.repository.repositories.OrderRepository;
import com.example.projektpowtorzeniowy.repository.repositories.ProductRepository;

public interface IRepositoryProvider {

    ProductRepository getProductRepository();

    OrderRepository getOrderRepository();

    CustomerRepository getCustomerRepository();




}
