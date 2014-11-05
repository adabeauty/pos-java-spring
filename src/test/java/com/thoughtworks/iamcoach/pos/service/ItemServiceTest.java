package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.ItemImple;
import com.thoughtworks.iamcoach.pos.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ItemServiceTest {
    ItemService itemService = null;

    @Before
    public void mock_ItemImpl(){
        ArrayList<Item> items = new ArrayList<Item>();
        Item item = new Item(null, 3,"TF1001", "juice", "can", 8.0);
        items.add(item);

        ArrayList<Promotion> promotions = new ArrayList<Promotion>();
        Promotion promotion = new BuyTwoOneFreePromotion(1, 1, "buy_two_one_free", 1.0);
        promotions.add(promotion);

        String barcode = "TF1001";
        int id = 1;
        Category category = new Category(null, "drink");

        ItemImple itemImple = mock(ItemImple.class);
        when(itemImple.getItems()).thenReturn(items);
        when(itemImple.getPromotions(id)).thenReturn(promotions);

        itemService = new ItemService(itemImple);
    }

    @Test
    public void can_get_all_items(){
        assertThat(itemService.getItems().size()).isEqualTo(1);
    }

    @Test
    public void can_get_promotions_of_item(){
        int id = 1;
        assertThat(itemService.getPromotions(id).size()).isEqualTo(1);
    }
}
