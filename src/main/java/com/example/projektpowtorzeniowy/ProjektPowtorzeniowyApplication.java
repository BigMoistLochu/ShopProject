package com.example.projektpowtorzeniowy;

import com.example.projektpowtorzeniowy.apiPublic.ApiProviderData;
import com.example.projektpowtorzeniowy.mappers.MapperProvider;
import com.example.projektpowtorzeniowy.model.Customer;
import com.example.projektpowtorzeniowy.model.Order;
import com.example.projektpowtorzeniowy.model.Product;
import com.example.projektpowtorzeniowy.repository.RepositoryProvider;
import com.example.projektpowtorzeniowy.repository.repositories.OrderRepository;
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

        try {
            Customer customer = new Customer("Konrad","ape@wp.pl");
            repositoryProvider.getCustomerRepository().save(customer);
            Customer customer2 = new Customer("Daniel","XD@wp.pl");
            repositoryProvider.getCustomerRepository().save(customer2);


            Order order = new Order(customer);
            Order order2 = new Order(customer2);
            System.out.println("zara dodajemy:");

            repositoryProvider.getOrderRepository().save(order);
            repositoryProvider.getOrderRepository().save(order2);
        }
        catch (Exception e)
        {
            System.out.println("duplikacja");
        }



        //teraz pytanie za 100 punktow, jak zwrocic zamowienie(Order) w ktorym Customer ma email = ape@wp.pl
        System.out.println(repositoryProvider.getOrderRepository().getFirstByCustomerEmailContains("XD@wp.pl").getCustomer());

        //referencja to zmienna ktora przechowuje adres pamieci gdzie znajduje sie dany obiekt
        //referencja jest product i product1
        //== porowonuje 2 referencje i zadaje pytanie czy wskazuja na ten sam obiekt
        //equels domyslnie wskazuje na to samo bo ma this == object
        //dlatego sie go nadpisuje zeby porownac obiekty





    }
}
