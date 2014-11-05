package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.*;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.sql.*;
import java.util.ArrayList;

public class PromotionImple implements PromotionDao {
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public PromotionImple(SimpleJdbcTemplate simpleJdbcTemplate) {
        this.simpleJdbcTemplate = simpleJdbcTemplate;
    }

    public Promotion getPromotionByType(int type) {
        String sql =  "SELECT * FROM promotions WHERE type = ?";
        return (Promotion)simpleJdbcTemplate.queryForObject(sql, new UserRowMapper(), type);
    }

    public ArrayList<Promotion> getPromotions() {
        String sql = "SELECT * FROM promotions";
        return ( ArrayList<Promotion>)simpleJdbcTemplate.query(sql, new UserRowMapper());
    }

    private static final class UserRowMapper implements RowMapper {
        public Promotion mapRow(ResultSet rs, int rowNum) throws SQLException {
            Promotion promotion = PromotionFactory.generatePromotion(rs.getInt("type"));
            promotion.setId(rs.getInt("id"));
            promotion.setType(rs.getInt("type"));
            promotion.setDescription(rs.getString("description"));
            promotion.setDiscount(rs.getDouble("discount"));
            return promotion;
        }
    }
}
