package com.example.projektpowtorzeniowy.controllers;

import com.example.projektpowtorzeniowy.model.Animal;
import com.example.projektpowtorzeniowy.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalController {

    AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }


    @GetMapping("/animals")
    public List<Animal> ListOfAnimal()
    {
        return animalService.returnListOfAnimals();
    }
}
