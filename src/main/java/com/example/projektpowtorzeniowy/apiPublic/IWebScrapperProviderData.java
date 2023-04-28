package com.example.projektpowtorzeniowy.apiPublic;

import com.example.projektpowtorzeniowy.model.contracts.ProductDto;

import java.util.List;

public interface IWebScrapperProviderData {

    /**
     * zwraca liste ProductDto sciagnietych ze strony https://www.oleole.pl/komputery-stacjonarne-pc,komputer-dla-graczy!1.bhtml
     * @return
     */
    List<ProductDto> getProductsFromWebsite();
}
