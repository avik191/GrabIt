package com.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Entity.Category;

@Repository
public class CategoryDAOImp implements CategoryDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	static List<Category> list = new ArrayList<>();
	
	
	
	@Override
	public List<Category> getActiveCategoryList() {
		// TODO Auto-generated method stub
		
		String sql = "From Category where isActive = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		query.setParameter("active",1);
		return query.list();
	}
	
	@Override
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		
		String sql = "From Category";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		return query.list();
	}

	@Override
	public Category getCategoryFromId(int id) {
		// TODO Auto-generated method stub
		try {
		Category c = (Category)sessionFactory.getCurrentSession().get(Category.class, id);
		return c;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

}
