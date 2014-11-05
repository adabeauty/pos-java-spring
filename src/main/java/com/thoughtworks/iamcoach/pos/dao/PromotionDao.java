package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.Promotion;

import java.util.ArrayList;

public interface PromotionDao {
    Promotion getPromotionByType(int type);

    ArrayList<Promotion> getPromotions();
}
