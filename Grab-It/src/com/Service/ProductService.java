package com.Service;

import java.util.List;

import com.Entity.Product;

public interface ProductService {

	public List<Product> getProductList();
	public Product getProductFromId(int id);
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(Product product);
	
	public List<Product> getActiveProductFromCategory(int category_id);
	public List<Product> getActiveProducts();
	public List<Product> getLatestActiveProducts(int count);
}
