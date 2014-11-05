package com.thoughtworks.iamcoach.pos.model;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ItemTest {
    @Test
    public void can_get_item_paraments(){
        Item item = new Item(null, 1,"TF10001", "apple", "kg", 8.00);

        assertThat(item.getCategoryId()).isEqualTo(1);
        assertThat(item.getBarcode()).isEqualTo("TF10001");
        assertThat(item.getName()).isEqualTo("apple");
        assertThat(item.getUnit()).isEqualTo("kg");
        assertThat(item.getPrice()).isEqualTo(8.00);
    }

    @Test
    public void can_transform_to_string(){
        Item item = new Item(null, 1,"TF10001", "apple", "kg", 8.00);
        String result =  "Item{" +
                "id=" + item.getId() +
                ", categoryId=" + item.getCategoryId() +
                ", barcode='" + item.getBarcode() + '\'' +
                ", name='" + item.getName() + '\'' +
                ", unit='" + item.getUnit() + '\'' +
                ", price=" + item.getPrice() +
                '}';

        assertThat(item.toString()).isEqualTo(result);
    }
}
