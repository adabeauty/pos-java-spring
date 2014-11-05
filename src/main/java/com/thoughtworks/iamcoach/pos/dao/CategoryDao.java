package com.thoughtworks.iamcoach.pos.dao;


import com.thoughtworks.iamcoach.pos.model.Category;
import java.util.ArrayList;

public interface CategoryDao {
    ArrayList<Category> getCategories();

    Category getCategoryById(int id);
}
