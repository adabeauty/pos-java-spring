package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.Category;
import com.thoughtworks.iamcoach.pos.model.Item;
import com.thoughtworks.iamcoach.pos.model.Promotion;
import com.thoughtworks.iamcoach.pos.model.PromotionFactory;
import com.thoughtworks.iamcoach.pos.util.ConnctionUlti;

import java.sql.*;
import java.util.ArrayList;

public class ItemImple implements ItemDao {
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private ConnctionUlti connctionUlti = new ConnctionUlti();

    public Item getItemByBarcode(String barcode) {
        String sql = "SELECT * FROM items WHERE barcode = ?";

        Item item = null;
        Connection conn = connctionUlti.getConnection();
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, barcode);
            rs = pstmt.executeQuery();
            rs.next();

            item = new Item(rs.getString("id"), rs.getInt("categoryId"), rs.getString("barcode"), rs.getString("name"), rs.getString("unit"), rs.getDouble("price"));

            closeAllConnrction();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    public ArrayList<Item> getItems() {
        ArrayList<Item> items = new ArrayList<Item>();
        String sql = "SELECT * FROM items";

        Item item = null;
        Connection conn = connctionUlti.getConnection();
        try{
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery(sql);
            while (rs.next()){
                item = new Item(rs.getString("id"), rs.getInt("categoryId"), rs.getString("barcode"), rs.getString("name"), rs.getString("unit"), rs.getDouble("price"));
                items.add(item);
            }

            closeAllConnrction();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
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

    public Category getCategory(int id) {
        String sql = "SELECT categories.name, items.* FROM categories, items "+
                "WHERE items.id = ? AND categories.id = items.categoryId" ;

        Category category = null;
        Connection connection = connctionUlti.getConnection();
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,id);

            rs = pstmt.executeQuery();
            rs.next();

            category = new Category(rs.getString("id"), rs.getString("name"));

            closeAllConnrction();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
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
}
