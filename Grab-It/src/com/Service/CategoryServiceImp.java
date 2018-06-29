package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.CategoryDAO;
import com.Entity.Category;

@Service @Transactional
public class CategoryServiceImp implements CategoryService{

	@Autowired
	CategoryDAO categoryDAO;
	
	@Override
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		return categoryDAO.getCategoryList();
	}

	@Override
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		try
		{
			return categoryDAO.addCategory(category);
			
		}catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDAO.updateCategory(category);
		return false;
	}

	@Override
	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category getCategoryFromId(int id) {
		// TODO Auto-generated method stub
		return categoryDAO.getCategoryFromId(id);
	}

}
