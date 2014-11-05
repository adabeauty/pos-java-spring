package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.util.ConnctionUlti;
import com.thoughtworks.iamcoach.pos.model.Category;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.sql.*;

import java.util.ArrayList;

public class CategoryImple implements CategoryDao{
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public CategoryImple(SimpleJdbcTemplate simpleJdbcTemplate) {
        this.simpleJdbcTemplate = simpleJdbcTemplate;
    }

    private ConnctionUlti connctionUlti = new ConnctionUlti();
    
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public ArrayList<Category> getCategories() {
        String sql = "SELECT * FROM categories";
        return (ArrayList<Category>)simpleJdbcTemplate.query(sql, new UserRowMapper());
//        ArrayList<Category> categories = new ArrayList<Category>();
//        Connection conn = connctionUlti.getConnection();
//        try{
//            preparedStatement = conn.prepareStatement(sql);
//
//            resultSet = preparedStatement.executeQuery(sql);
//            while (resultSet.next()){
//                Category category = new Category(resultSet.getString("id"), resultSet.getString("name"));
//                categories.add(category);
//            }
//
//            CloseAllConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return categories;
    }

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

    private static final class UserRowMapper implements RowMapper {
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            Category category = new Category();
            category.setName(rs.getString("name"));
            category.setId(rs.getString("id"));
            return category;
        }
    }
}
