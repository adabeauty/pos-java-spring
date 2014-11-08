package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.*;
import com.thoughtworks.iamcoach.pos.util.PromotionRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.util.ArrayList;

public class PromotionImpl implements PromotionDao {
    private JdbcTemplate jdbcTemplate;
    private PromotionRowMapper promotionRowMapper;

    public PromotionImpl(JdbcTemplate jdbcTemplate, PromotionRowMapper promotionRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.promotionRowMapper = promotionRowMapper;
    }

    public Promotion getPromotionByType(int type) {
        String sql =  "SELECT * FROM promotions WHERE type = ?";
        return (Promotion)jdbcTemplate.queryForObject(sql, promotionRowMapper, type);
    }

    public ArrayList<Promotion> getPromotions() {
        String sql = "SELECT * FROM promotions";
        return ( ArrayList<Promotion>)jdbcTemplate.query(sql, promotionRowMapper);
    }
}
