package com.example.projektpowtorzeniowy;

import com.example.projektpowtorzeniowy.apiPublic.ApiProviderData;
import com.example.projektpowtorzeniowy.mappers.MapperProvider;
import com.example.projektpowtorzeniowy.model.Product;
import com.example.projektpowtorzeniowy.repository.RepositoryProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
@Slf4j
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
    public void run(String... args){


        //Proste sprawdzenie czy obiektow ktore przyszly z publicznego api sa juz w bazie danych(jesli sa to ich nie dodaje, jesli nie ma to dodaje)

        List<Product> listOFProductBeforeFilter =  apiProviderData.getProductsFromPublicApi().stream()
                .map(productDto -> mapperProvider.getProductMapper().mapper(productDto))
                .toList();

        List<Product> listOfProductFiltered = listOFProductBeforeFilter.stream()
                .filter(product -> {
                    try {
                       return !product.getTitle().equals(repositoryProvider.getProductRepository().getFirstByTitle(product.getTitle()).getTitle());
                    }
                    catch(NullPointerException e)
                    {
                        log.info("Cos Poszlo Nie tak ");
                        return true;
                    }
                })
                .toList();

        addFilteredProductToDataBase(listOfProductFiltered);



    }



    public void addFilteredProductToDataBase(List<Product> productListAfterFiltered)
    {
        productListAfterFiltered.stream().map(product -> repositoryProvider.getProductRepository()
                        .save(product)).toList();
    }
}
