package com.thoughtworks.iamcoach.pos.model;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class DiscountPromotionTest {
    @Test
    public void can_get_DiscountPromotionTest(){
        Item item = new Item(null, 3, "TF1001", "apple", "kg", 8.00);
        double num = 1.0;

        DiscountPromotion discountPromotion = new DiscountPromotion(1, 1, "second_half_price",  0.75);
        assertThat(discountPromotion.calculate(item, num)).isEqualTo(6);
    }

}
