package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.model.Promotion;

import java.util.ArrayList;

/**
 * Created by wanghuan on 14-11-6.
 */
public interface PromotionService {
    Promotion getPromotionByType(int type);

    ArrayList<Promotion> getPromotions();
}
