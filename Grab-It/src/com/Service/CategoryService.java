package com.Service;

import java.util.List;

import com.Entity.Category;

public interface CategoryService {

	public List<Category> getCategoryList();
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(Category category);
	public Category getCategoryFromId(int id);

}
