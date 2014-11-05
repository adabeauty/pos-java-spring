package com.thoughtworks.iamcoach.pos.util;

import com.thoughtworks.iamcoach.pos.model.Promotion;
import com.thoughtworks.iamcoach.pos.model.PromotionFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PromotionRowMapper implements RowMapper {
    public Promotion mapRow(ResultSet rs, int rowNum) throws SQLException {
        Promotion promotion = PromotionFactory.generatePromotion(rs.getInt("type"));
        promotion.setId(rs.getInt("id"));
        promotion.setType(rs.getInt("type"));
        promotion.setDescription(rs.getString("description"));
        promotion.setDiscount(rs.getDouble("discount"));
        return promotion;
    }
}
