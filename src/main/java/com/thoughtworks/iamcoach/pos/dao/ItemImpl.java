package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.*;
import com.thoughtworks.iamcoach.pos.util.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemImpl implements ItemDao {
    private JdbcTemplate jdbcTemplate;

    public ItemImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ArrayList<Item> getItems() {
        String sql = "SELECT * FROM items";
        return  (ArrayList<Item>)jdbcTemplate.query(sql, new RowMapper<Item>() {
            public Item mapRow(ResultSet rs, int i) throws SQLException {
                return new Item(rs.getString("id"), rs.getInt("categoryId"), rs.getString("barcode"),
                        rs.getString("name"), rs.getString("unit"), rs.getDouble("price"));
            }
        });
    }

    public ArrayList<Promotion> getPromotions(int id) {
        String sql = "SELECT promotions.*, relationship.discount FROM promotions, relationship " +
                "WHERE relationship.itemId=? AND promotions.id=relationship.promotionId";
        return (ArrayList<Promotion>)jdbcTemplate.query(sql, new RowMapper<Promotion>() {
            public Promotion mapRow(ResultSet rs, int i) throws SQLException {
                Promotion promotion = PromotionFactory.generatePromotion(rs.getInt("type"));
                promotion.setId(rs.getInt("id"));
                promotion.setType(rs.getInt("type"));
                promotion.setDescription(rs.getString("description"));
                promotion.setDiscount(rs.getDouble("discount"));
                return promotion;
            }
        }, id);
    }
}
