package com.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Entity.CartLine;

@Repository
public class CartLineDAOImp implements CartLineDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<CartLine> list(int cartId) {
		// TODO Auto-generated method stub
		String query = "FROM CartLine WHERE cartId = :cartId";
		return sessionFactory.getCurrentSession()
								.createQuery(query, CartLine.class)
									.setParameter("cartId", cartId)
										.getResultList();
	}

	@Override
	public CartLine get(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(CartLine.class, Integer.valueOf(id));

	}

	@Override
	public boolean add(CartLine cartLine) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(cartLine);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(CartLine cartLine) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(cartLine);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(CartLine cartLine) {
		// TODO Auto-generated method stub
		try {			
			sessionFactory.getCurrentSession().delete(cartLine);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {
		// TODO Auto-generated method stub
		String query = "FROM CartLine WHERE cartId = :cartId AND productId = :productId";
		try {
			
			return sessionFactory.getCurrentSession()
									.createQuery(query,CartLine.class)
										.setParameter("cartId", cartId)
										.setParameter("productId", productId)
											.getSingleResult();
			
		}catch(Exception ex) {
			return null;	
		}
	}

	@Override
	public List<CartLine> listAvailable(int cartId) {
		// TODO Auto-generated method stub
		String query = "FROM CartLine WHERE cartId = :cartId AND available = :available";
		return sessionFactory.getCurrentSession()
								.createQuery(query, CartLine.class)
									.setParameter("cartId", cartId)
									.setParameter("available", true)
										.getResultList();
	}

}
