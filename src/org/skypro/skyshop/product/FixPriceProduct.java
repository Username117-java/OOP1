package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 69;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPriceProduct() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return getNameProduct() + ": Фиксированная цена " + getPriceProduct();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}
