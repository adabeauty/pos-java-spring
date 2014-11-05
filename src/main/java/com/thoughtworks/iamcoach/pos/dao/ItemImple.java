package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.*;
import com.thoughtworks.iamcoach.pos.util.ItemRowMapper;
import com.thoughtworks.iamcoach.pos.util.PromotionRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.sql.*;
import java.util.ArrayList;

public class ItemImple implements ItemDao {
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public ItemImple(SimpleJdbcTemplate simpleJdbcTemplate) {
        this.simpleJdbcTemplate = simpleJdbcTemplate;
    }


    public ArrayList<Item> getItems() {
        String sql = "SELECT * FROM items";
        return  (ArrayList<Item>)simpleJdbcTemplate.query(sql, new ItemRowMapper());
    }

    public ArrayList<Promotion> getPromotions(int id) {
        String sql = "SELECT promotions.*, relationship.discount FROM promotions, relationship " +
                "WHERE relationship.itemId=? AND promotions.id=relationship.promotionId";
        return  (ArrayList<Promotion>)simpleJdbcTemplate.query(sql, new PromotionRowMapper(), id);
    }
}
