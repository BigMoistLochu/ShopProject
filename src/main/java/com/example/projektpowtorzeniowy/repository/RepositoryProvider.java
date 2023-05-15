package com.example.projektpowtorzeniowy.repository;

import com.example.projektpowtorzeniowy.repository.repositories.CustomerRepository;
import com.example.projektpowtorzeniowy.repository.repositories.OrderRepository;
import com.example.projektpowtorzeniowy.repository.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryProvider implements IRepositoryProvider{


    ProductRepository productRepository;

    OrderRepository orderRepository;

    CustomerRepository customerRepository;

    @Autowired
    public RepositoryProvider(ProductRepository productRepository,OrderRepository orderRepository,CustomerRepository customerRepository) {

        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }



    @Override
    public ProductRepository getProductRepository() {
        return productRepository;
    }

    @Override
    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    @Override
    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }
}
