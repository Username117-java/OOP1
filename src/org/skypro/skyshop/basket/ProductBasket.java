package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {


    private Map<String, List<Product>> productBasket = new TreeMap<>();

    public ProductBasket() {
        this.productBasket = new TreeMap<>();
    }

    public void addProduct(Product product) {
        productBasket.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Map.Entry<String, List<Product>> entry : productBasket.entrySet()) {
            for (Product product : entry.getValue()) {
                totalPrice += product.getPriceProduct();
            }
        }
        return totalPrice;
    }

    public void printProductBasket() {
        if (productBasket.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        int specialProducts = 0;
        for (Map.Entry<String, List<Product>> entry : productBasket.entrySet()) {
            for (Product product : entry.getValue()) {
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
        if (productBasket.isEmpty()) {
            return false;
        }

        for (Map.Entry<String, List<Product>> entry : productBasket.entrySet()) {
            for (Product p : entry.getValue()) {
                if (p.getName().equals(product)) {
                    return true;
                }
            }
        }

        return false;
    }

    public void cleanBasket() {
        productBasket.clear();
    }

    public List<List<Product>> deleteProduct(String name) {
        List<List<Product>> deleted = new ArrayList<>();
        if (productBasket.containsKey(name)) {
            deleted.add(productBasket.get(name));
            productBasket.remove(name);

        }

        if (deleted.isEmpty()) {
            System.out.println("Продуктов для удаления не нашлось");
        }
        return deleted;
    }

}
