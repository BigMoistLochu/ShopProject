package com.example.projektpowtorzeniowy.apiPublic;

import com.example.projektpowtorzeniowy.model.contracts.ProductDto;

import java.util.List;

public interface IApiProviderData {

    /**
     * zwraca liste produktow z publicznego Api dostepnych na stronie: https://fakestoreapi.com/products
     * @return
     */

    List<ProductDto> getProductsFromPublicApi();





}
