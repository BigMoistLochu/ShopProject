package com.example.projektpowtorzeniowy.apiPublic;

import com.example.projektpowtorzeniowy.model.contracts.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class ApiProviderData implements IApiProviderData{

    private RestTemplate restTemplate;
    private String Url = "https://fakestoreapi.com/products";

    public ApiProviderData()
    {
        restTemplate = new RestTemplate();
    }



    public List<ProductDto> getProductsFromPublicApi()
    {

        ResponseEntity<ProductDto[]> response = restTemplate.getForEntity(Url, ProductDto[].class);

        ProductDto[] arrayOfProductDto = response.getBody();

        return Arrays.stream(arrayOfProductDto).toList();

    }


}
