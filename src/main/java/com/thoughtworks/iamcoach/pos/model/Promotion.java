package com.thoughtworks.iamcoach.pos.model;

import com.thoughtworks.iamcoach.pos.model.Item;

public abstract class Promotion {

    private int id;
    private int type;
    private String description;
    private double discount;

    protected Promotion() {
    }

    public Promotion(int id, int type, String description, double discount) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", type=" + type +
                ", description='" + description + '\'' +
                '}';
    }

    public abstract double calculate(Item item, double num);
}
