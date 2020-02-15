package com.cg.pms.service;

import java.util.List;
import java.util.Random;

import com.cg.pms.Dao.ProductDao;
import com.cg.pms.bean.Product;
import com.cg.pms.exception.ProductException;


public class ProductServiceImpl implements ProductService {
private ProductDao productDao;
	
	public ProductServiceImpl() {
		ProductServiceImpl productdao = new ProductServiceImpl();
	}
	public boolean validateName(String name) {
	 boolean flag = false;
	 flag = name.matches("[a-zA-Z]+");
		return flag;
	}

	public int addProduct(Product product) throws ProductException {
		
		String name = product.getProductName();
		boolean flag = validateName(name);
		if(! flag)
		{
			throw new ProductException("Name should contin only characters");
			
		}
		Random random = new Random();
		int id=random.nextInt(100)+1000;
		product.setProductId(id);
		id=productDao.addProduct(product);
		
		return id;
	}
	   
public Product findProductById(int productId) throws ProductException {
		String empid=String.valueOf(productId);
		boolean flag=empid.matches("[0-9]{4}");
		if(!flag) {
			throw new ProductException("Id should be 4 digit");
			
		}
		Product product=productDao.findProduct(productId);
		return product;
	}

	public Product deleteProductById(int productId) throws ProductException {
		
		return null;
	}

	public List<Product> findAllProduct() throws ProductException {

		return null;
	}
	


}
