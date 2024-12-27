package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {


    private Map<String, List<Product>> productBasket = new TreeMap<>();

    public ProductBasket() {
        Map<String, List<Product>> productBasket = new TreeMap<>();
    }

    public void addProduct(Product product) {
        // Честно скажу, загуглил и не особо понимаю, что тут происходит.
        // Пытался добавлять сам, но у меня либо не компилируется, либо заменяется значение и при двух одинаковых
        // товарах, добавляется только один.
        // Как правильно сделать? У меня только один вариант сейчас в голове, это создавать временный лист,
        // запихивать в него величину по нужному ключу, добавлять к нему еще один такой же товар, а потом
        // этим листом заменять существующий, но это как-то громоздко, мне кажется должны быть способы легче.
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
