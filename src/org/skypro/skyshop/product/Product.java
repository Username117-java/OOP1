package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

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


}