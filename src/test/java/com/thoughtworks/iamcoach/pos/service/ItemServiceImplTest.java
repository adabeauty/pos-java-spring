package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.ItemImpl;
import com.thoughtworks.iamcoach.pos.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ItemServiceImplTest {
    ItemServiceImpl itemServiceImpl = null;

    @Before
    public void mock_ItemImpl(){
        ArrayList<Item> items = new ArrayList<Item>();
        Item item = new Item(null, 3,"TF1001", "juice", "can", 8.0);
        items.add(item);

        ArrayList<Promotion> promotions = new ArrayList<Promotion>();
        Promotion promotion = new BuyTwoOneFreePromotion(1, 1, "buy_two_one_free", 1.0);
        promotions.add(promotion);

        int id = 1;

        ItemImpl itemImpl = mock(ItemImpl.class);
        when(itemImpl.getItems()).thenReturn(items);
        when(itemImpl.getPromotions(id)).thenReturn(promotions);

        itemServiceImpl = new ItemServiceImpl(itemImpl);
    }

    @Test
    public void can_get_all_items(){
        assertThat(itemServiceImpl.getItems().size()).isEqualTo(1);
    }

    @Test
    public void can_get_promotions_of_item(){
        int id = 1;
        assertThat(itemServiceImpl.getPromotions(id).size()).isEqualTo(1);
    }
}
