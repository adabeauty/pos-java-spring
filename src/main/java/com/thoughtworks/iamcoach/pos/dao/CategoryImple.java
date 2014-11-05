package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.util.ConnctionUlti;
import com.thoughtworks.iamcoach.pos.model.Category;

import java.sql.*;

import java.util.ArrayList;

public class CategoryImple implements CategoryDao{
    private ConnctionUlti connctionUlti = new ConnctionUlti();
    
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    @Override
    public ArrayList<Category> getCategories() {
        String sql = "SELECT * FROM categories";

        ArrayList<Category> categories = new ArrayList<Category>();
        Connection conn = connctionUlti.getConnection();
        try{
            preparedStatement = conn.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()){
                Category category = new Category(resultSet.getString("id"), resultSet.getString("name"));
                categories.add(category);
            }

            CloseAllConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getCategoryById(int id) {
        String sql = "SELECT * FROM categories WHERE id = ?";

        Category category = null;
        Connection conn = connctionUlti.getConnection();
        try{
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            category = new Category(resultSet.getString("id"), resultSet.getString("name"));

            CloseAllConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    private void CloseAllConnection(){
        connctionUlti.closeConnection();
        try {
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
