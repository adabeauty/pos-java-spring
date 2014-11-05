package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.*;
import com.thoughtworks.iamcoach.pos.model.Promotion;

import java.util.ArrayList;

public class PromotionService {
    private PromotionDao promotionImple;

    public PromotionService(PromotionDao promotionImple) {
        this.promotionImple = promotionImple;
    }

    public Promotion getPromotionByType(int type) {
        return promotionImple.getPromotionByType(type);
    }

    public ArrayList<Promotion> getPromotions() {
        return promotionImple.getPromotions();
    }
}
