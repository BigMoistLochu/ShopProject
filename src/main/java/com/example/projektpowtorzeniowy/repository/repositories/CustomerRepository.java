package com.example.projektpowtorzeniowy.repository.repositories;

import com.example.projektpowtorzeniowy.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
}