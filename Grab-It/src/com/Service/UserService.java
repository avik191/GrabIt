package com.Service;

import java.util.List;

import com.Entity.Address;
import com.Entity.Cart;
import com.Entity.User;

public interface UserService {

	boolean addUser(User user);
	boolean addAddress(Address address);
	boolean updateCart(Cart cart);
	boolean addCart(Cart cart);
	User getUserFromEmail(String email);
	Address getBillingAddressFromUserId(int id);
	Cart getCartFromUserId(int id);
	List<Address> getShippingAddressesFromUser(User user);
}
