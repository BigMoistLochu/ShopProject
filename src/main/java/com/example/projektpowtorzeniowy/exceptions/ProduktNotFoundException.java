package com.example.projektpowtorzeniowy.exceptions;

public class ProduktNotFoundException extends RuntimeException{


    public ProduktNotFoundException(long id)
    {
        super("Nie ma takiego Produktu o id:" + id);
    }
}
