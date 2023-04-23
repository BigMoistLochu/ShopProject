package com.example.projektpowtorzeniowy;

import com.example.projektpowtorzeniowy.apiPublic.ApiProviderData;
import com.example.projektpowtorzeniowy.mappers.MapperProvider;
import com.example.projektpowtorzeniowy.model.Product;
import com.example.projektpowtorzeniowy.repository.RepositoryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

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






        List<Product> listOFProductFiltered =  apiProviderData.getProductsFromPublicApi().stream()
                .map(productDto -> mapperProvider.getProductMapper().mapper(productDto))
                .filter(product -> product.getTitle()!=repositoryProvider.getProductRepository().getFirstByTitle(product.getTitle()).getTitle()).toList();


        listOFProductFiltered.stream().map(product -> repositoryProvider.getProductRepository()
                        .save(product))
                .toList();



//        jednoczesnie zamienia produktDto na produkt po czym go zwraca przez funkcje map i znowu produkt jest modyfikowany przez funkcje map ktora dodaje go do bazy danych



//        System.out.println(repositoryProvider.getProductRepository().findAll());







    }
}
