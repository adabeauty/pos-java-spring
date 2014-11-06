package com.thoughtworks.iamcoach.pos.model;

import com.thoughtworks.iamcoach.pos.dao.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CartItemTest {
    @Test
    public void can_get_num(){
        CartItem cartItem = generateCartItem();
        double num  = 9.0;
        cartItem.setNum(num);
        assertThat(cartItem.getNum()).isEqualTo(9.0);
    }

    @Test
    public void can_get_subtotal(){
        CartItem cartItem = generateCartItem();
        assertThat(cartItem.getSubtotal()).isEqualTo(16);
    }

    private CartItem generateCartItem(){
        Item item = new Item(null, 3,"ITEM000001", "apple", "kg", 8.0);
        double num = 3.0;

        PromotionDao promotionImple = mock_PromotionImple();
        CartItem cartItem  = new CartItem(item, num, promotionImple.getPromotions());

        return cartItem;
    }

    private PromotionDao mock_PromotionImple(){

        ArrayList<Promotion> promotions = new ArrayList<Promotion>();
        promotions.add(new SeconHalfPromotion(2, 2, "second_half_half", 1.0));
        promotions.add(new BuyTwoOneFreePromotion(1, 1, "buy_two_one_free", 1.0));
        promotions.add(new DiscountPromotion(3, 3, "discount", 0.75));

        PromotionDao promotionImple = mock(PromotionImpl.class);
        when(promotionImple.getPromotions()).thenReturn(promotions);

        return promotionImple;
    }
}
