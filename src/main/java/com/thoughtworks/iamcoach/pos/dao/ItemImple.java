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

    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private ConnctionUlti connctionUlti = new ConnctionUlti();


    public ArrayList<Item> getItems() {
g        String sql = "SELECT * FROM items";
        return  (ArrayList<Item>)simpleJdbcTemplate.query(sql, new UserRowMapper());
    }

    public ArrayList<Promotion> getPromotions(int id) {
        ArrayList<Promotion> promotions = new ArrayList<Promotion>();
        String sql = "SELECT promotions.*, relationship.discount FROM promotions, relationship " +
                "WHERE relationship.itemId=? AND promotions.id=relationship.promotionId";

        Connection connection = connctionUlti.getConnection();
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,id);

            rs = pstmt.executeQuery();
            while(rs.next()){
                Promotion promotion = PromotionFactory.generatePromotion(rs.getInt("type"));

                promotion.setId(rs.getInt("id"));
                promotion.setId(rs.getInt("type"));
                promotion.setDescription(rs.getString("description"));
                promotion.setDiscount(rs.getDouble("discount"));

                promotions.add(promotion);
            }

            closeAllConnrction();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return promotions;
    }

    private void closeAllConnrction(){
        connctionUlti.closeConnection();
        try {
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
