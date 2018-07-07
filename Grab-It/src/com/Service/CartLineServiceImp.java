package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.CartLineDAO;
import com.Entity.CartLine;


@Service @Transactional
public class CartLineServiceImp implements CartLineService{

	@Autowired 
	CartLineDAO cartLineDAO;
	
	@Override
	public List<CartLine> list(int cartId) {
		// TODO Auto-generated method stub
		return cartLineDAO.list(cartId);
	}

	@Override
	public CartLine get(int id) {
		// TODO Auto-generated method stub
		return cartLineDAO.get(id);
	}

	@Override
	public boolean add(CartLine cartLine) {
		// TODO Auto-generated method stub
		return cartLineDAO.add(cartLine);
	}

	@Override
	public boolean update(CartLine cartLine) {
		// TODO Auto-generated method stub
		return cartLineDAO.update(cartLine);
	}

	@Override
	public boolean remove(CartLine cartLine) {
		// TODO Auto-generated method stub
		return cartLineDAO.remove(cartLine);
	}

	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {
		// TODO Auto-generated method stub
		return cartLineDAO.getByCartAndProduct(cartId, productId);
	}

	@Override
	public List<CartLine> listAvailable(int cartId) {
		// TODO Auto-generated method stub
		return cartLineDAO.listAvailable(cartId);
	}

}
