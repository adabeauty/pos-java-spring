package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.Category;
import com.thoughtworks.iamcoach.pos.util.CategoryRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.util.ArrayList;

public class CategoryImpl implements CategoryDao{
    private SimpleJdbcTemplate simpleJdbcTemplate;
    private CategoryRowMapper categoryRowMapper;

    public CategoryImpl(SimpleJdbcTemplate simpleJdbcTemplate, CategoryRowMapper categoryRowMapper) {
        this.simpleJdbcTemplate = simpleJdbcTemplate;
        this.categoryRowMapper = categoryRowMapper;
    }

    public ArrayList<Category> getCategories() {
        String sql = "SELECT * FROM categories";
        return (ArrayList<Category>)simpleJdbcTemplate.query(sql, categoryRowMapper);
    }

    public Category getCategoryById(int id) {
        String sql = "SELECT * FROM categories WHERE id = ?";
        return (Category)simpleJdbcTemplate.queryForObject(sql, categoryRowMapper, id);
    }
}
