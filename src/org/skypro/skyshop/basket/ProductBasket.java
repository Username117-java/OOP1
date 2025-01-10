package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProductBasket {

    private Map<String, List<Product>> productBasket;

    public ProductBasket() {
        this.productBasket = new TreeMap<>();
    }

    public void addProduct(Product product) {
        productBasket.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);
    }

    public int getTotalPrice() {
        return productBasket.values().stream().flatMap(Collection::stream)
                .flatMapToInt(x -> IntStream.of(x.getPriceProduct()))
                .sum();
    }

    public void printProductBasket() {
        if (productBasket.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        productBasket.values().stream().flatMap(Collection::stream).forEach(System.out::println);

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    private long getSpecialCount() {
        return productBasket.values().stream().flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public boolean findProduct(String product) {
        return productBasket.values().stream().flatMap(Collection::stream).anyMatch(x -> x.getName().equals(product));
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
