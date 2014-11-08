package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.*;
import com.thoughtworks.iamcoach.pos.util.PromotionRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PromotionImpl implements PromotionDao {
    private JdbcTemplate jdbcTemplate;

    public PromotionImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Promotion getPromotionByType(int type) {
        String sql =  "SELECT * FROM promotions WHERE type = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Promotion>() {
            public Promotion mapRow(ResultSet rs, int i) throws SQLException {
                Promotion promotion = PromotionFactory.generatePromotion(rs.getInt("type"));
                promotion.setId(rs.getInt("id"));
                promotion.setType(rs.getInt("type"));
                promotion.setDescription(rs.getString("description"));
                promotion.setDiscount(rs.getDouble("discount"));
                return promotion;
            }
        }, type);
    }

    public ArrayList<Promotion> getPromotions() {
        String sql = "SELECT * FROM promotions";
        return ( ArrayList<Promotion>)jdbcTemplate.query(sql, new RowMapper<Promotion>() {
            public Promotion mapRow(ResultSet rs, int i) throws SQLException {
                Promotion promotion = PromotionFactory.generatePromotion(rs.getInt("type"));
                promotion.setId(rs.getInt("id"));
                promotion.setType(rs.getInt("type"));
                promotion.setDescription(rs.getString("description"));
                promotion.setDiscount(rs.getDouble("discount"));
                return promotion;
            }
        });
    }
}
