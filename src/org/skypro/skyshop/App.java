package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        SimpleProduct tequila = new SimpleProduct("Текила", 1500);
        SimpleProduct salt = new SimpleProduct("Соль", 20);
        DiscountedProduct stickForHittingNettles = new DiscountedProduct("Палка для битья крапивы", 500, 20);
        FixPriceProduct lime = new FixPriceProduct("Лайм");
        FixPriceProduct woodenNails = new FixPriceProduct("Деревянные гвозди");
        SimpleProduct blackCaviar = new SimpleProduct("Черная икра", 6500);

        ProductBasket basket1 = new ProductBasket();
        basket1.addProduct(tequila);
        basket1.addProduct(salt);
        basket1.addProduct(stickForHittingNettles);
        basket1.addProduct(lime);
        basket1.addProduct(woodenNails);

        basket1.addProduct(blackCaviar);

        basket1.printProductBasket();

        System.out.println("Стоимость всей корзины: " + basket1.getTotalPrice());

        System.out.println("Проверка наличия в корзине деревянных гвоздей: " + basket1.findProduct("Деревянные гвозди"));

        System.out.println("Проверка наличия в корзине черной икры: " + basket1.findProduct("Черная икра"));

        basket1.cleanBasket();

        basket1.printProductBasket();

        System.out.println("Стоимость всей корзины: " + basket1.getTotalPrice());

        System.out.println("Проверка наличия в корзине деревянных гвоздей: " + basket1.findProduct("Деревянные гвозди"));
    }

}