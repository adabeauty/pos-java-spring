package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.model.Category;
import com.thoughtworks.iamcoach.pos.util.CategoryRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.util.ArrayList;

public class CategoryImple implements CategoryDao{
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public CategoryImple(SimpleJdbcTemplate simpleJdbcTemplate) {
        this.simpleJdbcTemplate = simpleJdbcTemplate;
    }

    public ArrayList<Category> getCategories() {
        String sql = "SELECT * FROM categories";
        return (ArrayList<Category>)simpleJdbcTemplate.query(sql, new CategoryRowMapper());
    }

    public Category getCategoryById(int id) {
        String sql = "SELECT * FROM categories WHERE id = ?";
        return (Category)simpleJdbcTemplate.queryForObject(sql, new CategoryRowMapper(), id);
    }
}
