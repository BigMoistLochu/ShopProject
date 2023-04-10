package com.example.projektpowtorzeniowy;

import com.example.projektpowtorzeniowy.apiPublic.ApiProviderData;
import com.example.projektpowtorzeniowy.mappers.MapperProvider;
import com.example.projektpowtorzeniowy.repository.RepositoryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjektPowtorzeniowyApplication implements CommandLineRunner {


    ApiProviderData apiProviderData;

    RepositoryProvider repositoryProvider;


    MapperProvider mapperProvider;

    @Autowired
    public ProjektPowtorzeniowyApplication(ApiProviderData apiProviderData,RepositoryProvider repositoryProvider,MapperProvider mapperProvider)
    {

        this.apiProviderData = apiProviderData;
        this.repositoryProvider = repositoryProvider;
        this.mapperProvider = mapperProvider;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjektPowtorzeniowyApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

//        Animal animal1 = new Animal("Jacek",13);
//
//        //provider sluzy do bardziej elastycznego kodu, w tym momencie zamiast dodawac repozytoria do konstruktora gdzie moze byc ich z 20 mamy jedna klase ktora pluje nimi
//        repositoryProvider.getAnimalRepository().save(animal1);
//        System.out.println(repositoryProvider.getAnimalRepository().findAll());
//
//
//
//        System.out.println(apiProviderData.getProductsFromPublicApi());

        apiProviderData.getProductsFromPublicApi().stream()
                .map(productDto -> mapperProvider.getProductMapper().mapper(productDto))
                .map(product -> repositoryProvider.getProductRepository()
                        .save(product))
                .toList();
        //jednoczesnie zamienia produktDto na produkt po czym go zwraca przez funkcje map i znowu produkt jest modyfikowany przez funkcje map ktora dodaje go do bazy danych



        System.out.println(repositoryProvider.getProductRepository().findAll());







    }
}
