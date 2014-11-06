package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.*;
import com.thoughtworks.iamcoach.pos.model.Promotion;

import java.util.ArrayList;

public class PromotionServiceImpl implements PromotionService {
    private PromotionDao promotionImple;

    public PromotionServiceImpl(PromotionDao promotionImple) {
        this.promotionImple = promotionImple;
    }

    public Promotion getPromotionByType(int type) {
        return promotionImple.getPromotionByType(type);
    }

    public ArrayList<Promotion> getPromotions() {
        return promotionImple.getPromotions();
    }
}
