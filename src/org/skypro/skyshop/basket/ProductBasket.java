package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.search.Searchable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {

    private List<Product> productBasket = new LinkedList<>();

    public ProductBasket(){
        List<Product> productBasket = new LinkedList<>();
    }

    public void addProduct(Product product) {        
        productBasket.add(product);
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
        if (productBasket.get(0) == null) {
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
        if (productBasket.get(0) == null) {
            return false;
        }
        for (int i = 0; i < productBasket.size(); i++) {
            if (productBasket.get(i).getNameProduct().equals(product)) {
                return true;
            }

        }
        return false;
    }

    public void cleanBasket() {
        productBasket.clear();
    }

    public List<Product> deleteProduct(String name) {
        List<Product> deleted = new ArrayList<>();
        Iterator<Product> iterator = productBasket.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getNameProduct().equals(name)) {
                deleted.add(p);
                iterator.remove();
            }
        }
        if (deleted.isEmpty()){
            System.out.println("Список пуст");
        }
        return deleted;
    }

}
