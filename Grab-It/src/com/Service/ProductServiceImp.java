package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.ProductDAO;
import com.Entity.Product;

@Service @Transactional
public class ProductServiceImp implements ProductService{

	@Autowired
	ProductDAO productDAO;
	
	@Override
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return productDAO.getProductList();
	}

	@Override
	public Product getProductFromId(int id) {
		// TODO Auto-generated method stub
		return productDAO.getProductFromId(id);
	}

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.addProduct(product);
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.updateProduct(product);
	}

	@Override
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.deleteProduct(product);
	}

	@Override
	public List<Product> getActiveProductFromCategory(int category_id) {
		// TODO Auto-generated method stub
		return productDAO.getActiveProductFromCategory(category_id);
	}

	@Override
	public List<Product> getActiveProducts() {
		// TODO Auto-generated method stub
		return productDAO.getActiveProducts();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		// TODO Auto-generated method stub
		return productDAO.getLatestActiveProducts(count);
	}

}
