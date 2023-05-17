package com.example.projektpowtorzeniowy.repository.repositories;

import com.example.projektpowtorzeniowy.model.Customer;
import com.example.projektpowtorzeniowy.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {

    @Query("select p from Customer p where :email = :email")
    List<Customer> findByXD(@Param("email") String email);
}
