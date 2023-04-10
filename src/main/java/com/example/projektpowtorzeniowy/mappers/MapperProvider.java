package com.example.projektpowtorzeniowy.mappers;

import com.example.projektpowtorzeniowy.mappers.maps.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperProvider {


    ProductMapper productMapper;


    @Autowired
    public MapperProvider(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }


    public ProductMapper getProductMapper()
    {
        return productMapper;
    }
}
