package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String nameProduct;

    public Product(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public abstract int getPriceProduct();

    public boolean isSpecial(){
        return false;
    };

    @Override
    public String searchTerm() {
        return nameProduct;
    }

    @Override
    public String getTypeContent() {
        return "PRODUCT";
    }

}