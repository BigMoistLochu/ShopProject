package com.example.projektpowtorzeniowy.taskScheduler;

public interface IFilterProductTask {

    /**
     * Pobiera liste ProduktDto z publicznego api po czym mapuje je do Obiektow Product,
     * nastepnie przechodzi do filtracji ktora polega na odpytaniu bazy danych czy istnieje taki produkt
     * o tej nazwie, jesli istnieje to obiekt jest pomijany, w przeciwnym razie obiekt jest dodawany do bazy
     */
    void FilterProductFromPublicApiBeforeAddToDataBase();

    /**
     * Tworzony jest obiekt WebScrapper(nie jest wstrzykiwany jako bean zeby dzialal na odzielnym watku)
     *Po czym przechodzi filtracje czy czasem nie ma juz obiektow w bazie danych o podanej nazwie
     */
//    void FilterProductFromWebScrapperBeforeAddToDataBase();
}
