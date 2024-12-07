package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private Product[] productBasket = new Product[5];

    public void addProduct(Product product) {
        if (productBasket[4] != null) {
            System.out.println("Невозможно добавить продукт " + product.getNameProduct());
            return;
        }
        for (int i = 0; i < productBasket.length; i++) {
            if (productBasket[i] == null) {
                productBasket[i] = product;
                break;
            }
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Product product : productBasket) {
            if (product != null) {
                totalPrice += product.getPriceProduct();
            }
        }
        return totalPrice;
    }

    public void printProductBasket() {
        if (productBasket[0] == null) {
            System.out.println("В корзине пусто");
            return;
        }
        int specialProducts = 0;
        for (Product product : productBasket) {
            if (product != null) {
                if (product.isSpecial()) {
                    specialProducts++;
                }
                System.out.println(product);
            }

        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialProducts);
    }

    public boolean findProduct(String product) {
        if (productBasket[0] == null) {
            return false;
        }
        for (int i = 0; i < productBasket.length; i++) {
            if (productBasket[i].getNameProduct().equals(product)) {
                return true;
            }

        }
        return false;
    }

    public void cleanBasket() {
        for (int i = 0; i < productBasket.length; i++) {
            productBasket[i] = null; // очистка массива?
        }

    }

}
