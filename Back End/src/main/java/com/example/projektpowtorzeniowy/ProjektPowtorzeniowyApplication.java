package com.example.projektpowtorzeniowy;

import com.example.projektpowtorzeniowy.apiPublic.ApiProviderData;
import com.example.projektpowtorzeniowy.apiPublic.IWebScrapperProviderData;
import com.example.projektpowtorzeniowy.apiPublic.WebScrapperProviderData;
import com.example.projektpowtorzeniowy.mappers.MapperProvider;
import com.example.projektpowtorzeniowy.model.Product;
import com.example.projektpowtorzeniowy.model.contracts.ProductDto;
import com.example.projektpowtorzeniowy.repository.RepositoryProvider;
import com.example.projektpowtorzeniowy.taskScheduler.FilterProductTask;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.startup.WebAnnotationSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
@EnableScheduling
@Slf4j
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
    public void run(String... args){
        log.info("Start Aplikacji");

        Product product = new Product("Mens Cotton Jacket",44,"ddd.png");

        repositoryProvider.getProductRepository().save(product);
    }
}
