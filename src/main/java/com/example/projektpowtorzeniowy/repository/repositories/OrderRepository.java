package com.example.projektpowtorzeniowy.repository.repositories;

import com.example.projektpowtorzeniowy.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {

    public Order getFirstByCustomerEmailContains(String email);



}
