package com.example.projektpowtorzeniowy.mappers;

import com.example.projektpowtorzeniowy.mappers.maps.ProductMapper;

public interface IMapperProvider {

    /**
     * zwraca mapper odpowiedzialny za konwertowanie ProduktuDto na Produkt
     * @return
     */

    ProductMapper getProductMapper();
}
