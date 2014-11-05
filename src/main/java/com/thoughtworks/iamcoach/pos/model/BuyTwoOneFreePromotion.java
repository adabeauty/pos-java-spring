package com.thoughtworks.iamcoach.pos.model;

public class BuyTwoOneFreePromotion extends Promotion {
    public BuyTwoOneFreePromotion() {
    }

    public BuyTwoOneFreePromotion(int id, int type, String description, double discount) {
        super(id, type, description, discount);
    }

    @Override
    public double calculate(Item item, double num) {
        double promotionNumber = ((int) num)/3;
        double actualNumber = num - promotionNumber;
        return actualNumber * item.getPrice();
    }
}
