package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.UserDAO;
import com.Entity.Address;
import com.Entity.Cart;
import com.Entity.User;

@Service @Transactional
public class UserServiceImp implements UserService{

	@Autowired
	UserDAO userDAO;
	
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.addUser(user);
	}

	@Override
	public boolean addAddress(Address address) {
		// TODO Auto-generated method stub
		return userDAO.addAddress(address);
	}

	@Override
	public boolean updateCart(Cart cart) {
		// TODO Auto-generated method stub
		return userDAO.UpdateCart(cart);
	}

	@Override
	public User getUserFromEmail(String email) {
		// TODO Auto-generated method stub
		return userDAO.getUserFromEmail(email);
	}

	@Override
	public Address getBillingAddressFromUserId(int id) {
		// TODO Auto-generated method stub
		return userDAO.getBillingAddressFromUserId(id);
	}

	@Override
	public List<Address> getShippingAddressesFromUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.getShippingAddressesFromUser(user);
	}

	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		return userDAO.addCart(cart);
	}

	@Override
	public Cart getCartFromUserId(int id) {
		// TODO Auto-generated method stub
		return userDAO.getCartFromUserId(id);
	}

}
