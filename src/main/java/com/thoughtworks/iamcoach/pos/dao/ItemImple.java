package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.*;
import com.thoughtworks.iamcoach.pos.util.ConnctionUlti;
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
        return  (ArrayList<Item>)simpleJdbcTemplate.query(sql, new UserRowMapper());
    }

    public ArrayList<Promotion> getPromotions(int id) {
        String sql = "SELECT promotions.*, relationship.discount FROM promotions, relationship " +
                "WHERE relationship.itemId=? AND promotions.id=relationship.promotionId";

        return (ArrayList<Promotion>)simpleJdbcTemplate.query(sql, new RowMapper<Promotion>() {
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

    private static final class UserRowMapper implements RowMapper {

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
}
