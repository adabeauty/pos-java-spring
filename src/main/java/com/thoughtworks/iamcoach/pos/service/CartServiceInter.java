package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.model.CartItem;

import java.util.ArrayList;

/**
 * Created by wanghuan on 14-11-6.
 */
public interface CartServiceInter {
    ArrayList<CartItem> getCartInfo();

    double getTotalSum();

    double getActualSum();
}
