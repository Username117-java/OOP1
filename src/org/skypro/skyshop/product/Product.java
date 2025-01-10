package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String nameProduct;

    public Product(String nameProduct) {
        if (nameProduct == null || nameProduct.isBlank()) {
            throw new IllegalArgumentException("Поле названия продукта не может быть пустым");
        }
        this.nameProduct = nameProduct;
    }

    @Override
    public String getName() {
        return nameProduct;
    }

    public abstract int getPriceProduct();

    public boolean isSpecial() {
        return false;
    }


    @Override
    public String searchTerm() {
        return nameProduct;
    }

    @Override
    public String getTypeContent() {
        return "PRODUCT";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameProduct);
    }
}