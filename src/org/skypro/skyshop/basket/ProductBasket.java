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


    public int getTotalCost() {
        int totalCost = 0;
        if (productBasket[0] == null) {
            System.out.println("В корзине пусто");
            return totalCost;
        }
        for (Product product : productBasket) {
            if (product != null) {
                totalCost += product.getCostProduct();
            }
        }
        return totalCost;
    }

    public void printProductBasket() {
        for (Product product : productBasket) {
            if (product != null) {
                System.out.println(product.toString());
            }

        }
        System.out.println("Итого: " + getTotalCost());

    }

    public boolean findProduct(String product) {
        if (productBasket[0] == null) {
            System.out.println("В корзине пусто");
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
