package com.example.projektpowtorzeniowy.taskScheduler;

import com.example.projektpowtorzeniowy.apiPublic.ApiProviderData;
import com.example.projektpowtorzeniowy.apiPublic.WebScrapperProviderData;
import com.example.projektpowtorzeniowy.mappers.MapperProvider;
import com.example.projektpowtorzeniowy.model.Product;
import com.example.projektpowtorzeniowy.model.contracts.ProductDto;
import com.example.projektpowtorzeniowy.repository.RepositoryProvider;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class FilterProductTask implements IFilterProductTask{


    ApiProviderData apiProviderData;

    RepositoryProvider repositoryProvider;


    MapperProvider mapperProvider;


    @Scheduled(cron = "*/55 * * * * *")
    public void FilterProductFromPublicApiBeforeAddToDataBase()
    {
        apiProviderData.getProductsFromPublicApi().stream()
                .map(productDto -> mapperProvider.getProductMapper().mapper(productDto))
                .filter(product -> {
                    try {
                        return !product.getTitle().equals(repositoryProvider.getProductRepository().getFirstByTitle(product.getTitle()).getTitle());
                    }
                    catch(NullPointerException e)
                    {
                        log.info("Cos Poszlo Nie tak ");
                        return true;
                    }
                }).map(product -> repositoryProvider.getProductRepository()
                        .save(product)).toList();
        log.info("skonczylem filtrowac");
    }


    @Scheduled(cron = "*/20 * * * * *")
    public void FilterProductFromWebScrapperBeforeAddToDataBase()
    {
        WebScrapperProviderData webScrapperProviderData = new WebScrapperProviderData();

       webScrapperProviderData
               .getProductsFromWebsite()
               .stream()
               .map(productDto -> mapperProvider.getProductMapper().mapper(productDto))
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
               .map(product -> repositoryProvider.getProductRepository()
                       .save(product))
               .toList();
        log.info("skonczylem filtrowac");
       ;

    }



}
