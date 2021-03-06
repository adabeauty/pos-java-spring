package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.ItemImpl;
import com.thoughtworks.iamcoach.pos.model.*;

import java.util.ArrayList;

public class ItemServiceImpl implements ItemService {
    private ItemImpl itemImpl;

    public ItemServiceImpl(ItemImpl itemImpl) {
        this.itemImpl = itemImpl;
    }

    public ArrayList<Item> getItems() {
        return itemImpl.getItems();
    }

    public ArrayList<Promotion> getPromotions(int id) {
        return itemImpl.getPromotions(id);
    }
}
