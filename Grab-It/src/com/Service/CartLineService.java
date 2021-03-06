package com.Service;

import java.util.List;

import com.Entity.CartLine;

public interface CartLineService {

	public List<CartLine> list(int cartId);
	public CartLine get(int id);	
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean remove(CartLine cartLine);
	
	// fetch the CartLine based on cartId and productId
	public CartLine getByCartAndProduct(int cartId, int productId);		
	// list of available cartLine
	public List<CartLine> listAvailable(int cartId);
}
