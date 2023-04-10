package com.example.projektpowtorzeniowy;

import com.example.projektpowtorzeniowy.model.Animal;
import com.example.projektpowtorzeniowy.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjektPowtorzeniowyApplication implements CommandLineRunner {

    AnimalRepository animalRepository;

    @Autowired
    public ProjektPowtorzeniowyApplication(AnimalRepository animalRepository)
    {
        this.animalRepository = animalRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjektPowtorzeniowyApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        Animal animal1 = new Animal("Jacek",13);

        animalRepository.save(animal1);

        System.out.println(animalRepository.findAll());



    }
}
