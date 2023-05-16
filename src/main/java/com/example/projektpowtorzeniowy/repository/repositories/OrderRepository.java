package com.example.projektpowtorzeniowy.repository.repositories;

import com.example.projektpowtorzeniowy.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {

    public Order getFirstByCustomerEmailContains(String email);

    //select * from cart_items INNER JOIN customer ON customer.id = cart_items.customer_id

    List<Order> findByCustomer_EmailContaining(String email);






}
