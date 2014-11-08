package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.Category;
import com.thoughtworks.iamcoach.pos.util.CategoryRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

public class CategoryImpl implements CategoryDao{
    private JdbcTemplate jdbcTemplate;
    private CategoryRowMapper categoryRowMapper;

    public CategoryImpl(JdbcTemplate jdbcTemplate, CategoryRowMapper categoryRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.categoryRowMapper = categoryRowMapper;
    }

    public ArrayList<Category> getCategories() {
        String sql = "SELECT * FROM categories";
        return (ArrayList<Category>)jdbcTemplate.query(sql, categoryRowMapper);
    }

    public Category getCategoryById(int id) {
        String sql = "SELECT * FROM categories WHERE id = ?";
        return (Category)jdbcTemplate.queryForObject(sql, categoryRowMapper, id);
    }
}
