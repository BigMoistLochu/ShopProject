package com.example.projektpowtorzeniowy.apiPublic;

import com.example.projektpowtorzeniowy.model.contracts.ProductDto;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class WebScrapperProviderData {


    private Playwright playwright;
    private Browser browser;
    private Page page;

    private List<ProductDto> listOfProductsFromWeb = new ArrayList<>();



    public WebScrapperProviderData()
    {
        log.info("tworzy sie obiekt");
        playwright = Playwright.create();
        browser = playwright.webkit().launch(); //jesli chcemy widziec przegladarke to do parametru launch(new BrowserType.LaunchOptions().setHeadless(false))
        page = browser.newPage();

    }

    public List<ProductDto> getProductsFromWebsite()
    {
        page.navigate("https://www.oleole.pl/komputery-stacjonarne-pc,komputer-dla-graczy!1.bhtml");

        String temporaryTitle = "";
        String temporaryImage = "";
        double temporaryPrice = 0;




        //we pull out a title

        //wyciagamy price
        //wyciagamy image


//        System.out.println(page.locator("ems-euro-mobile-product-medium-box.product-list__product-box:nth-child(3) > eui-box:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h4:nth-child(1)"));
        System.out.println(page.locator(".product-paginator__box-container > ems-euro-mobile-product-medium-box:nth-child(1) > eui-box:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(4)").getAttribute("src"));
        System.out.println(page.locator(".product-paginator__box-container > ems-euro-mobile-product-medium-box:nth-child(1) > eui-box:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(4) > img:nth-child(1)").getAttribute("src"));

        return listOfProductsFromWeb;
    }

    private ProductDto createAProductDto(String title,double price,String image,ProductDto productDto)
    {
        productDto.setPrice(price);
        productDto.setTitle(title);
        productDto.setImage(image);
        return productDto;
    }



}
