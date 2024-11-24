package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product tequila = new Product("Текила", 1500);
        Product salt = new Product("Соль", 20);
        Product stickForHittingNettles = new Product("Палка для битья крапивы", 500);
        Product lime = new Product("Лайм", 50);
        Product woodenNails = new Product("Деревянные гвозди", 120);
        Product blackCaviar = new Product("Черная икра", 6500);

        ProductBasket basket1 = new ProductBasket();
        basket1.addProduct(tequila);
        basket1.addProduct(salt);
        basket1.addProduct(stickForHittingNettles);
        basket1.addProduct(lime);
        basket1.addProduct(woodenNails);

        basket1.addProduct(blackCaviar);

        basket1.printProductBasket();

        System.out.println("Стоимость всей корзины: " + basket1.getTotalCost());

        System.out.println("Проверка наличия в корзине деревянных гвоздей: " + basket1.findProduct("Деревянные гвозди"));

        System.out.println("Проверка наличия в корзине черной икры: " + basket1.findProduct("Черная икра"));

        basket1.cleanBasket();

        basket1.printProductBasket();

        System.out.println("Стоимость всей корзины: " + basket1.getTotalCost());

        System.out.println("Проверка наличия в корзине деревянных гвоздей: " + basket1.findProduct("Деревянные гвозди"));
    }
}