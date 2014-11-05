package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.util.ConnctionUlti;
import com.thoughtworks.iamcoach.pos.model.Promotion;
import com.thoughtworks.iamcoach.pos.model.PromotionFactory;

import java.sql.*;
import java.util.ArrayList;

public class PromotionImple implements PromotionDao {
    private ConnctionUlti connctionUlti = new ConnctionUlti();

    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;

    @Override
    public Promotion getPromotionByType(int type) {
        String sql =  "SELECT * FROM promotions WHERE type = ?";
        Connection connection = connctionUlti.getConnection();
        Promotion promotion = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, type);

            result = preparedStatement.executeQuery();
            result.next();

            promotion = setPromotion(result);

            closeAllConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return promotion;
    }

    @Override
    public ArrayList<Promotion> getPromotions() {
        ArrayList<Promotion> promotions = new ArrayList<Promotion>();
        String sql = "SELECT * FROM promotions";

        Promotion promotion = null;
        Connection conn = connctionUlti.getConnection();
        try{
            preparedStatement = conn.prepareStatement(sql);

            result = preparedStatement.executeQuery(sql);
            while (result.next()){
                promotion = setPromotion(result);
                promotions.add(promotion);
            }
            closeAllConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promotions;
    }

    private void closeAllConnection(){
        connctionUlti.closeConnection();
        try {
            preparedStatement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Promotion setPromotion(ResultSet rs){
        Promotion promotion = null;
        try {
            promotion  =  PromotionFactory.generatePromotion(rs.getInt("type"));

            promotion.setId(rs.getInt("id"));
            promotion.setId(rs.getInt("type"));
            promotion.setDescription(rs.getString("description"));
            if(rs.getInt("type") == 3){
                promotion.setDiscount(result.getDouble("discount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return promotion;
    }
}
