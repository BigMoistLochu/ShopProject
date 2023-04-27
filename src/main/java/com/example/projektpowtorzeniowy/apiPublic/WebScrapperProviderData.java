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


    private final Playwright playwright;
    private final Browser browser;
    private final Page page;

    private List<ProductDto> listOfProductsFromWeb = new ArrayList<>();

    private String temporaryTitle;
    private String temporaryImage;
    private double temporaryPrice;



    public WebScrapperProviderData()
    {
        log.info("tworzy sie obiekt WebScrapper");
        playwright = Playwright.create();
        browser = playwright.webkit().launch(); //jesli chcemy widziec przegladarke to do parametru launch(new BrowserType.LaunchOptions().setHeadless(false))
        page = browser.newPage();

    }

    public List<ProductDto> getProductsFromWebsite()
    {
        page.navigate("https://www.oleole.pl/komputery-stacjonarne-pc,komputer-dla-graczy!1.bhtml");
        page.waitForLoadState();

        boolean xx = true;
        int startNumberFromSelector = 3;

        while(true)
        {



            try {
                //wait for load selector
                page.waitForSelector("ems-euro-mobile-product-medium-box.product-list__product-box:nth-child("+startNumberFromSelector+") > eui-box:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h4:nth-child(1)");

                //get Title
                if(page.locator("ems-euro-mobile-product-medium-box.product-list__product-box:nth-child("+startNumberFromSelector+") > eui-box:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h4:nth-child(1)").isVisible())
                {
                    temporaryTitle = page.locator("ems-euro-mobile-product-medium-box.product-list__product-box:nth-child("+startNumberFromSelector+") > eui-box:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h4:nth-child(1)").textContent();
                }
                else
                {
                    log.info("Koniec Sciagania Danych z Webscrappera");
                    break;
                }


                page.waitForSelector("ems-euro-mobile-product-medium-box.product-list__product-box:nth-child("+startNumberFromSelector+") > eui-box:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(4) > img:nth-child(1)");

                //get image
                if(page.locator("ems-euro-mobile-product-medium-box.product-list__product-box:nth-child("+startNumberFromSelector+") > eui-box:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(4) > img:nth-child(1)").isVisible())
                {
                    temporaryImage = page.locator("ems-euro-mobile-product-medium-box.product-list__product-box:nth-child("+startNumberFromSelector+") > eui-box:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(4) > img:nth-child(1)").getAttribute("src");
                }

                page.waitForSelector("ems-euro-mobile-product-medium-box.product-list__product-box:nth-child("+startNumberFromSelector+") > eui-box:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(4) > img:nth-child(1)");

                //get price
                if(page.locator("ems-euro-mobile-product-medium-box.product-list__product-box:nth-child("+startNumberFromSelector+") > eui-box:nth-child(1) > a:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > ems-price:nth-child(1) > div:nth-child(1) > div:nth-child(1)").isVisible())
                {
                    String temporaryString = page
                            .locator("ems-euro-mobile-product-medium-box.product-list__product-box:nth-child("+startNumberFromSelector+") > eui-box:nth-child(1) > a:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > ems-price:nth-child(1) > div:nth-child(1) > div:nth-child(1)")
                            .textContent().replaceAll("([a-zA-Zł])", "").replace(" ", "");
                    temporaryPrice = Double.parseDouble(temporaryString);
                }


                if(temporaryImage != "" && temporaryPrice != 0 && temporaryTitle != "")
                {
                    listOfProductsFromWeb
                        .add(createAProductDto(temporaryTitle,temporaryPrice,temporaryImage,new ProductDto()));
                }


            }
            catch (Exception ex)
            {
                log.info("Somethink wrong with WebScrapping");
            }



            System.out.println(startNumberFromSelector);
            startNumberFromSelector+=2;


        }



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
