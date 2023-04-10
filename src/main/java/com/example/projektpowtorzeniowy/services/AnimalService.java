package com.example.projektpowtorzeniowy.services;

import com.example.projektpowtorzeniowy.model.Animal;
import com.example.projektpowtorzeniowy.repository.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    AnimalRepository animalRepository;



    @Autowired
    public AnimalService(AnimalRepository animalRepository)
    {
        this.animalRepository = animalRepository;
    }


    public List<Animal> returnListOfAnimals()
    {
        return animalRepository.findAll();
    }


}
