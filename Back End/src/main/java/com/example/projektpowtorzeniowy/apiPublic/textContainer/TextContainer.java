package com.example.projektpowtorzeniowy.apiPublic.textContainer;

public class TextContainer {



    public static String text(int x, EnumText enumText)
    {
        return switch (enumText) {
            case TITLE ->
                    "ems-euro-mobile-product-medium-box.product-list__product-box:nth-child(" + x + ") > eui-box:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h4:nth-child(1)";
            case PRICE ->
                    "ems-euro-mobile-product-medium-box.product-list__product-box:nth-child(" + x + ") > eui-box:nth-child(1) > a:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > ems-price:nth-child(1) > div:nth-child(1) > div:nth-child(1)";
            case IMAGE ->
                    "ems-euro-mobile-product-medium-box.product-list__product-box:nth-child(" + x + ") > eui-box:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(4) > img:nth-child(1)";
        };
    }


}
