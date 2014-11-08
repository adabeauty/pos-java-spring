package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.*;
import com.thoughtworks.iamcoach.pos.util.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

public class ItemImpl implements ItemDao {
    private JdbcTemplate jdbcTemplate;
    private ItemRowMapper itemRowMapper;
    private PromotionRowMapper promotionRowMapper;

    public ItemImpl(JdbcTemplate jdbcTemplate, ItemRowMapper itemRowMapper, PromotionRowMapper promotionRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.itemRowMapper = itemRowMapper;
        this.promotionRowMapper = promotionRowMapper;
    }

    public ArrayList<Item> getItems() {
        String sql = "SELECT * FROM items";
        return  (ArrayList<Item>)jdbcTemplate.query(sql, itemRowMapper);
    }

    public ArrayList<Promotion> getPromotions(int id) {
        String sql = "SELECT promotions.*, relationship.discount FROM promotions, relationship " +
                "WHERE relationship.itemId=? AND promotions.id=relationship.promotionId";
        return  (ArrayList<Promotion>)jdbcTemplate.query(sql, promotionRowMapper, id);
    }
}
