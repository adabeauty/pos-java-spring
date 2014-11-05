package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.*;
import com.thoughtworks.iamcoach.pos.util.PromotionRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.util.ArrayList;

public class PromotionImple implements PromotionDao {
    private SimpleJdbcTemplate simpleJdbcTemplate;
    private PromotionRowMapper promotionRowMapper;

    public PromotionImple(SimpleJdbcTemplate simpleJdbcTemplate, PromotionRowMapper promotionRowMapper) {
        this.simpleJdbcTemplate = simpleJdbcTemplate;
        this.promotionRowMapper = promotionRowMapper;
    }

    public Promotion getPromotionByType(int type) {
        String sql =  "SELECT * FROM promotions WHERE type = ?";
        return (Promotion)simpleJdbcTemplate.queryForObject(sql, promotionRowMapper, type);
    }

    public ArrayList<Promotion> getPromotions() {
        String sql = "SELECT * FROM promotions";
        return ( ArrayList<Promotion>)simpleJdbcTemplate.query(sql, promotionRowMapper);
    }
}
