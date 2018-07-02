package com.DAO;

import java.util.List;

import com.Entity.Category;

public interface CategoryDAO {

	public List<Category> getCategoryList();
	public List<Category> getActiveCategoryList();
	public Category getCategoryFromId(int id);
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(Category category);
}
