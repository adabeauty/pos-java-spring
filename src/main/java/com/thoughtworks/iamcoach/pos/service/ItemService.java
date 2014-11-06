package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.model.Item;
import com.thoughtworks.iamcoach.pos.model.Promotion;

import java.util.ArrayList;

public interface ItemService {
    ArrayList<Item> getItems();

    ArrayList<Promotion> getPromotions(int id);
}
