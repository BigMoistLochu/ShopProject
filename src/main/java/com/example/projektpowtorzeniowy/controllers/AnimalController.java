package com.example.projektpowtorzeniowy.controllers;

import com.example.projektpowtorzeniowy.model.Animal;
import com.example.projektpowtorzeniowy.services.AnimalService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class AnimalController {

    AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }


    @GetMapping("/animals")
    public List<Animal> ListOfAnimal()
    {
        return animalService.returnListOfAnimals();
    }


    @GetMapping("/ciastko")
    public String testXd(HttpServletRequest request, HttpServletResponse response)
    {

        Cookie cookie = new Cookie("nazwa_ciasteczka", "BylemNaStronieCiasdtko1");
        response.addCookie(cookie);
        return "ciastko?";
    }

    @GetMapping("/ciastko/dwa")
    public String testXd2(HttpServletRequest request, HttpServletResponse response)
    {

        Cookie cookie = new Cookie("nazwa_ciasteczka", "BylemNaStronieCiasdtko2");
        response.addCookie(cookie);
        return "ciastko?2";
    }

    @GetMapping("/ciastko/trzy")
    public String testXd3(HttpServletRequest request, HttpServletResponse response)
    {
        Cookie[] lista = request.getCookies();
        List<Cookie> listaOfCookie = Arrays.stream(lista).toList();
        List<Cookie> filtrowanko = listaOfCookie.stream().filter(cookie -> cookie.getValue().equals("BylemNaStronieCiasdtko2")||cookie.getValue().equals("BylemNaStronieCiasdtko1")).toList();
        for (Cookie cookie: filtrowanko) {
            System.out.println(cookie.getValue());

        }


        return "ciastko?3";
    }

}
