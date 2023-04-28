package com.example.projektpowtorzeniowy.apiPublic;

import com.example.projektpowtorzeniowy.apiPublic.textContainer.EnumText;
import com.example.projektpowtorzeniowy.apiPublic.textContainer.TextContainer;
import com.example.projektpowtorzeniowy.model.contracts.ProductDto;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class WebScrapperProviderData implements IWebScrapperProviderData{


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

        int startNumberFromSelector = 3;

        while(startNumberFromSelector<=29)
        {

            try {
                //wait for title selector
                page.waitForSelector(TextContainer.text(startNumberFromSelector,EnumText.TITLE));

                //get Title
                if(page.locator(TextContainer.text(startNumberFromSelector,EnumText.TITLE)).isVisible())
                {
                    temporaryTitle = page.locator(TextContainer.text(startNumberFromSelector,EnumText.TITLE))
                            .textContent();
                }

                //wait for image selector
                page.waitForSelector(TextContainer.text(startNumberFromSelector,EnumText.IMAGE));

                //get image
                if(page.locator(TextContainer.text(startNumberFromSelector,EnumText.IMAGE)).isVisible())
                {
                    temporaryImage = page.locator(TextContainer.text(startNumberFromSelector,EnumText.IMAGE)).getAttribute("src");
                }

                //wait for price selector
                page.waitForSelector(TextContainer.text(startNumberFromSelector,EnumText.PRICE));

                //get price
                if(page.locator(TextContainer.text(startNumberFromSelector,EnumText.PRICE)).isVisible())
                {
                    String temporaryString = page
                            .locator(TextContainer.text(startNumberFromSelector,EnumText.PRICE))
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
