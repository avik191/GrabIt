package com.DAO;

import java.util.List;

import com.Entity.Address;
import com.Entity.Cart;
import com.Entity.User;

public interface UserDAO {

	boolean addUser(User user);
	boolean addAddress(Address address);
	boolean UpdateCart(Cart cart);
	boolean addCart(Cart cart);
	User getUserFromEmail(String email);
	Cart getCartFromUserId(int id);
	Address getBillingAddressFromUserId(int id);
	List<Address> getShippingAddressesFromUser(User user);
}
