package com.thoughtworks.iamcoach.pos.util;

import com.thoughtworks.iamcoach.pos.model.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRowMapper implements RowMapper {
//    private Item item;
//
//    public ItemRowMapper(Item item) {
//        this.item = item;
//    }

    public Item mapRow(ResultSet rs, int rowNum) {
        Item item = new Item();
        try {
            item.setId(rs.getString("id"));
            item.setCategoryId(rs.getInt("categoryId"));
            item.setBarcode(rs.getString("barcode"));
            item.setName(rs.getString("name"));
            item.setUnit(rs.getString("unit"));
            item.setPrice(rs.getDouble("price"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }
}

