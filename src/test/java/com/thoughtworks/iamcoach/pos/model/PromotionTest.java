package com.thoughtworks.iamcoach.pos.model;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class PromotionTest {
    @Test
    public void can_get_paraments(){
        int id = 1;
        int type = 1;
        String description = "buy_two_one_free";
        Promotion promotion = new BuyTwoOneFreePromotion(id, type, description, 1);

        assertThat(promotion.getId()).isEqualTo(1);
        assertThat(promotion.getType()).isEqualTo(1);
        assertThat(promotion.getDescription()).isEqualTo(description);
    }

    @Test
    public void can_transform_to_string(){
        int id = 1;
        int type = 1;
        String description = "buy_two_one_free";
        Promotion promotion = new BuyTwoOneFreePromotion(id, type, description, 1);
        String result = "Promotion{" +
                "id=" + id +
                ", type=" + type +
                ", description='" + description + '\'' +
                '}';
        assertThat(promotion.toString()).isEqualTo(result);
    }
}
