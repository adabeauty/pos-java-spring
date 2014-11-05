package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.*;
import com.thoughtworks.iamcoach.pos.util.*;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.util.ArrayList;

public class ItemImple implements ItemDao {
    private SimpleJdbcTemplate simpleJdbcTemplate;
    private ItemRowMapper itemRowMapper;
    public ItemImple(SimpleJdbcTemplate simpleJdbcTemplate, ItemRowMapper itemRowMapper) {
        this.simpleJdbcTemplate = simpleJdbcTemplate;
        this.itemRowMapper = itemRowMapper;
    }

    public ArrayList<Item> getItems() {
        String sql = "SELECT * FROM items";
        return  (ArrayList<Item>)simpleJdbcTemplate.query(sql, itemRowMapper);
    }

    public ArrayList<Promotion> getPromotions(int id) {
        String sql = "SELECT promotions.*, relationship.discount FROM promotions, relationship " +
                "WHERE relationship.itemId=? AND promotions.id=relationship.promotionId";
        return  (ArrayList<Promotion>)simpleJdbcTemplate.query(sql, new PromotionRowMapper(), id);
    }
}
