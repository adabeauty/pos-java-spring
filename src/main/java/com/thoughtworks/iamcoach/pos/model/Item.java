package com.thoughtworks.iamcoach.pos.model;

public class Item {

    private String id;

    private int categoryId;
    private String barcode;
    private String name;
    private String unit;
    private double price;

    public Item(String id, int categoryId, String barcode, String name, String unit, double price) {
        this.id = id;
        this.categoryId = categoryId;
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", barcode='" + barcode + '\'' +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                '}';
    }
}
