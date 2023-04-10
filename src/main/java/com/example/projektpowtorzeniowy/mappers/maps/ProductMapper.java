package com.example.projektpowtorzeniowy.mappers.maps;


import com.example.projektpowtorzeniowy.model.Product;
import com.example.projektpowtorzeniowy.model.contracts.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product mapper(ProductDto productDto)
    {
        return mapper(productDto,new Product());
    }

    private Product mapper(ProductDto productDto,Product product)
    {
        product.setIdOfProduct(productDto.getId());
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        product.setImage(productDto.getImage());
        return product;
    }

}
