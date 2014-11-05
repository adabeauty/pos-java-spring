package com.thoughtworks.iamcoach.pos.util;

import com.thoughtworks.iamcoach.pos.model.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper{
    private Category category;

    public CategoryRowMapper(Category category) {
        this.category = category;
    }

    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();
        category.setName(rs.getString("name"));
        category.setId(rs.getString("id"));
        return category;
    }
}
