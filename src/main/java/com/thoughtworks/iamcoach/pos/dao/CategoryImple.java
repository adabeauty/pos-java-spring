package com.thoughtworks.iamcoach.pos.dao;

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

    public ArrayList<Category> getCategories() {
        String sql = "SELECT * FROM categories";
        return (ArrayList<Category>)simpleJdbcTemplate.query(sql, new UserRowMapper());
    }

    public Category getCategoryById(int id) {
        String sql = "SELECT * FROM categories WHERE id = ?";
        return (Category)simpleJdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
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
