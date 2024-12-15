package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.article.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Product tequila = new SimpleProduct("Текила", 1500);
        Product salt = new SimpleProduct("Соль", 20);
        Product stickForHittingNettles = new DiscountedProduct("Палка для битья крапивы", 500, 20);
        Product lime = new FixPriceProduct("Лайм");
        Product woodenNails = new FixPriceProduct("Деревянные гвозди");
        Product blackCaviar = new SimpleProduct("Черная икра", 6500);
        Searchable nailsArticle = new Article("О пользе деревяных гвоздей",
                "Основная польза применения деревяных гвоздей в уменьшении массы изготавливаемого изделия. " +
                        "Если изделия окажется недостаточно долговечным, инженеров можно избить палкой...");
        Searchable stickWorkManual = new Article("Инструкция к палке для битья крапивы",
                "Ниже будут описаны все варианты применения палки для битья крапивы, а также подробная техника безопасности при эксплуатации: ...");

        try {
            Product redPants = new DiscountedProduct("Малиновые штаны", 1000, 146);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            Product gravicapa = new SimpleProduct("Гравицапа", -666);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            Product nothing = new FixPriceProduct("   ");
        } catch (Exception e) {
            System.out.println(e.toString());
        }


        SearchEngine searchEngine = new SearchEngine(7);
        searchEngine.add(tequila);
        searchEngine.add(salt);
        searchEngine.add(stickForHittingNettles);
        searchEngine.add(woodenNails);
        searchEngine.add(blackCaviar);
        searchEngine.add(nailsArticle);
        searchEngine.add(stickWorkManual);

        try {
            System.out.println(searchEngine.search("палк").toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            System.out.println(searchEngine.search("Что находится за ледяной стеной вокруг плоской земли?").toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

}