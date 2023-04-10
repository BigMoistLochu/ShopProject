package com.example.projektpowtorzeniowy.repository.repositories;

import com.example.projektpowtorzeniowy.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {

}
