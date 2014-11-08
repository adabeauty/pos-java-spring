package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.Category;
import com.thoughtworks.iamcoach.pos.util.CategoryRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryImpl implements CategoryDao{
    private JdbcTemplate jdbcTemplate;

    public CategoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ArrayList<Category> getCategories() {
        String sql = "SELECT * FROM categories";

        return (ArrayList<Category>)jdbcTemplate.query(sql, new RowMapper<Category>() {
            public Category mapRow(ResultSet rs, int i) throws SQLException {
                return new Category(rs.getString("id"), rs.getString("name"));
            }
        });
    }

    public Category getCategoryById(int id) {
        String sql = "SELECT * FROM categories WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, new RowMapper<Category>() {
            public Category mapRow(ResultSet rs, int i) throws SQLException {
                return new Category(rs.getString("id"), rs.getString("name"));
            }
        }, id);
    }
}
