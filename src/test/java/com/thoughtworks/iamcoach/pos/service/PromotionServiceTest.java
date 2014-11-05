package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.*;
import com.thoughtworks.iamcoach.pos.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PromotionServiceTest {
    PromotionService promotionService;

    @Before
    public void mock_PromotionImpl(){
        int type = 1;
        Promotion promotion = new SeconHalfPromotion();

        ArrayList<Promotion> promotions = new ArrayList<Promotion>();
        promotions.add(promotion);

        PromotionDao promotionImple = mock(PromotionImple.class);
        when(promotionImple.getPromotionByType(type)).thenReturn(promotion);
        when(promotionImple.getPromotions()).thenReturn(promotions);

        promotionService = new PromotionService(promotionImple);
    }

    @Test
    public void can_get_promotion_by_type(){
        int type = 1;
        assertThat(promotionService.getPromotionByType(type) instanceof SeconHalfPromotion).isTrue();
    }

    @Test
    public void can_get_promotions(){
        assertThat(promotionService.getPromotions().size()).isEqualTo(1);
    }
}
