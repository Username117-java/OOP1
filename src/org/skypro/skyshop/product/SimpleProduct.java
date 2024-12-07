package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int priceProduct;

    public SimpleProduct(String name, int priceProduct) {
        super(name);
        if (priceProduct < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательная");
        }
        this.priceProduct = priceProduct;
    }

    @Override
    public int getPriceProduct() {
        return priceProduct;
    }

    @Override
    public String toString() {
        return getNameProduct() + ": " + getPriceProduct();
    }






}


