package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.*;

import java.util.ArrayList;

public interface ItemDao {
//    ArrayList<Item> getItems();
//
//    ArrayList<Promotion> getPromotions(int id);
    Item getItemByBarcode(String barcode);

    ArrayList<Item> getItems();

    ArrayList<Promotion> getPromotions(int id);

    Category getCategory(int id);
}
