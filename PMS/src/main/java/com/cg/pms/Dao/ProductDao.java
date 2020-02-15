package com.cg.pms.Dao;

import java.util.List;

import com.cg.pms.bean.Product;
import com.cg.pms.exception.ProductException;

public interface ProductDao {
	
	public int addProduct(Product product)throws ProductException;
	public Product findProduct(int productId)throws ProductException;
	public void deleteProductById(int productId)throws ProductException;
	public List<Product> findAllProducts()throws ProductException;

}
