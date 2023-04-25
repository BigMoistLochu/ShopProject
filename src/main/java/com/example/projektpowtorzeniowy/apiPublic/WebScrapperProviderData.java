package com.example.projektpowtorzeniowy.apiPublic;

import com.example.projektpowtorzeniowy.model.contracts.ProductDto;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WebScrapperProviderData {


    private Playwright playwright;
    private Browser browser;
    private Page page;

    private List<ProductDto> listOfProductsFromWeb = new ArrayList<>();

    public WebScrapperProviderData()
    {
        playwright = Playwright.create();
        browser = playwright.webkit().launch(); //jesli chcemy widziec przegladarke to do parametru launch(new BrowserType.LaunchOptions().setHeadless(false))
        page = browser.newPage();
    }

    public List<ProductDto> getProductsFromWebsite()
    {
        page.navigate("https://www.oleole.pl/komputery-stacjonarne-pc,komputer-dla-graczy!1.bhtml");

        //wyciagamy title
        //wyciagamy price
        //wyciagamy image


        System.out.println(page.locator("ems-euro-mobile-product-medium-box.product-list__product-box:nth-child(3) > eui-box:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(4)").getAttribute("src").toString());


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
