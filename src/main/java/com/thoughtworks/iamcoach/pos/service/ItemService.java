package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.model.Item;
import com.thoughtworks.iamcoach.pos.model.Promotion;

import java.util.ArrayList;

/**
 * Created by wanghuan on 14-11-6.
 */
public interface ItemService {
    ArrayList<Item> getItems();

    ArrayList<Promotion> getPromotions(int id);
}
