package com.thoughtworks.iamcoach.pos.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartItem{

    private Item item =null;
    private double num;
    private List<Promotion> promotionList = new ArrayList<Promotion>();

    public CartItem(Item item, double num, ArrayList<Promotion> promotionList) {
        this.item = item;
        this.num = num;
        this.promotionList = promotionList;
    }

    public Item getItem() {
        return item;
    }

    public double getNum() {
        return this.num;
    }

    public void setNum(double num) {
        this.num  = num;
    }

    public List<Promotion> getPromotionList() {
        return promotionList;
    }

    public double getSubtotal() {
        ArrayList<Double> allSubTotals = new ArrayList<Double>();

        Item item = new Item(getItem().getId(), getItem().getCategoryId(), getItem().getBarcode(), getItem().getName(), getItem().getUnit(), getItem().getPrice());

        for(int i=0; i<getPromotionList().size(); i++){
            allSubTotals.add(getPromotionList().get(i).calculate(item, num));
        }

        return Collections.min(allSubTotals);
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "item=" + item +
                ", num=" + num +
                ", promotionList=" + promotionList +
                '}';
    }
}
