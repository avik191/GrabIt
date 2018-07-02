package com.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Entity.Category;
import com.Entity.Product;

@Repository
public class ProductDAOImp implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		String sql = "From Product";
		Query query = sessionFactory.getCurrentSession().createQuery(sql,Product.class);
		return query.list();
	}

	@Override
	public Product getProductFromId(int id) {
		// TODO Auto-generated method stub
		try {
			Product c = (Product)sessionFactory.getCurrentSession().get(Product.class, id);
			return c;
			}catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}
	}

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().save(product);
			return true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> getActiveProductFromCategory(int category_id) {
		// TODO Auto-generated method stub
		String sql = "From Product where isActive = :active AND category_id = :cid";
		Query query = sessionFactory.getCurrentSession().createQuery(sql,Product.class);
		query.setParameter("active",1);
		query.setParameter("cid",category_id);
		return query.list();
	}

	@Override
	public List<Product> getActiveProducts() {
		// TODO Auto-generated method stub
		String sql = "From Product where isActive = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(sql,Product.class);
		query.setParameter("active",1);
		return query.list();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		// TODO Auto-generated method stub
		String sql = "From Product where isActive = :active ORDER BY id";
		Query query = sessionFactory.getCurrentSession().createQuery(sql,Product.class);
		query.setParameter("active",1);
		query.setFirstResult(0);
		query.setMaxResults(count);
		return query.list();

	}

}
