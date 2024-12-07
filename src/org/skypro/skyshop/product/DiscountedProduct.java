package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrise;
    private int discount;


    public DiscountedProduct(String name, int basePrise, int discount) {
        super(name);
        if (basePrise < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательная");
        }
        this.basePrise = basePrise;

        if (discount < 0) {
            throw new IllegalArgumentException("Скидка не может быть отрицательная");
        }
        this.discount = discount;
    }

    @Override
    public int getPriceProduct() {
        return (int) (basePrise - ((basePrise * discount) / 100));
    }

    @Override
    public String toString() {
        return getNameProduct() + ": " + getPriceProduct() + " (" + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }


}
