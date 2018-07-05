package com.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Entity.Address;
import com.Entity.Cart;
import com.Entity.User;

@Repository
public class UserDAOImp implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(address);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean UpdateCart(Cart cart) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getUserFromEmail(String email) {
		// TODO Auto-generated method stub
		String sql = "FROM User where email = :email";
		try {
			return sessionFactory.getCurrentSession().createQuery(sql,User.class).setParameter("email",email).getSingleResult();
			}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Address getBillingAddressFromUserId(int id) {
		// TODO Auto-generated method stub
		String sql = "FROM Address where userID = :id AND billing = :billing";
		try {
			return sessionFactory.getCurrentSession().createQuery(sql,Address.class).setParameter("id", id).setParameter("billing", 1).getSingleResult();
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Address> getShippingAddressesFromUser(User user) {
		// TODO Auto-generated method stub
		String sql = "FROM Address where user = :user AND shipping = :shipping";
		try {
			return sessionFactory.getCurrentSession().createQuery(sql,Address.class).setParameter("user", user).setParameter("shipping", 1).list();
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Cart getCartFromUserId(int id) {
		// TODO Auto-generated method stub
		String sql = "FROM Cart where userId = :id";
		try {
			return sessionFactory.getCurrentSession().createQuery(sql,Cart.class).setParameter("id", id).getSingleResult();
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
