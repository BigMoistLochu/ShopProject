package com.example.projektpowtorzeniowy;

import com.example.projektpowtorzeniowy.apiPublic.ApiProviderData;
import com.example.projektpowtorzeniowy.mappers.MapperProvider;
import com.example.projektpowtorzeniowy.model.Customer;
import com.example.projektpowtorzeniowy.model.Order;
import com.example.projektpowtorzeniowy.model.Product;
import com.example.projektpowtorzeniowy.repository.RepositoryProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@Slf4j
public class ProjektPowtorzeniowyApplication implements CommandLineRunner {


    ApiProviderData apiProviderData;

    RepositoryProvider repositoryProvider;


    MapperProvider mapperProvider;



    @Autowired
    public ProjektPowtorzeniowyApplication(ApiProviderData apiProviderData,RepositoryProvider repositoryProvider,MapperProvider mapperProvider)
    {

        this.apiProviderData = apiProviderData;
        this.repositoryProvider = repositoryProvider;
        this.mapperProvider = mapperProvider;

    }

    public static void main(String[] args) {
        SpringApplication.run(ProjektPowtorzeniowyApplication.class, args);
    }




    @Override
    public void run(String... args){
        log.info("Start Aplikacji");

//        Product product = Product.builder().title("Mlotek").price(40D).image("mlotek.png").build();
//        repositoryProvider.getProductRepository().save(product);
//
//        Customer customer = Customer.builder().name("Konrad").email("Konrad.Krok@wp.pl").build();
//        repositoryProvider.getCustomerRepository().save(customer);
//
//        Order order = new Order(customer,product);
//        repositoryProvider.getOrderRepository().save(order);


        System.out.println(repositoryProvider.getOrderRepository().findAll());


        //teraz pytanie za 100 punktow, jak zwrocic zamowienie(Order) w ktorym Customer ma email = ape@wp.pl


        //referencja to zmienna ktora przechowuje adres pamieci gdzie znajduje sie dany obiekt
        //referencja jest product i product1
        //== porowonuje 2 referencje i zadaje pytanie czy wskazuja na ten sam obiekt
        //equels domyslnie wskazuje na to samo bo ma this == object
        //dlatego sie go nadpisuje zeby porownac obiekty





    }
}
