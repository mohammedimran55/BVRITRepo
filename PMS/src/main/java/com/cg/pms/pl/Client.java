package com.cg.pms.pl;

import java.util.List;
import java.util.Scanner;

import com.cg.pms.bean.Product;
import com.cg.pms.exception.ProductException;
import com.cg.pms.service.ProductService;
import com.cg.pms.service.ProductServiceImpl;


public class Client {

	public static void main(String[] args)  {

       Scanner scanner = new Scanner(System.in);
       ProductService productservice = new ProductServiceImpl();
       
       int choice = 0;
       Product product = null;
       List<Product> list = null;
       
       while(choice !=5)
       {
    	   System.out.println("1.ADD Product");
    	   System.out.println("2.Search Product");
    	   System.out.println("3.Delete Product");
    	   System.out.println("4.List all Products");
    	   System.out.println("5.Exit");
    	   System.out.println("Enter your Choice");
    	   choice = scanner.nextInt();
    	   switch(choice)
    	   {
    	   case 1 : System.out.println("Enter Name");
    	   scanner.nextLine();
    	   String name = scanner.nextLine();
    	   System.out.println("Enter Price");
    	   double price = scanner.nextDouble();
    	   product = new Product();
    	   product.setProductName(name);
    	   product.setPrice( price);
    	   try
    	   {
    	   
		int id = productservice.addProduct(product);
    	   System.out.println("Employee Id = "+id);
    	   }
    	   catch(ProductException e)
    	   {
    		   System.out.println(e.getMessage());
    		   
    	   }
    	   break;
    	   case 2 :
    		   System.out.println("Enter Product Id");
    		   int id = scanner.nextInt();
    		   try
    		   {
    			   product = productservice.findProductById(id);
    		   System.out.println(" Name = " +product.getProductName());
    		   System.out.println(" Price =" +product.getPrice());
    		   }catch(ProductException e)
    		   {
    			   System.err.println(e.getMessage());
    		   }
    		   break;
    	   case 3 : 
    		   
    		   break;
    	   case 4 :  try
    	   {
                       list = productservice.findAllProduct();
                       for(Product emp :list) {
                    	   id = emp.getProductId();
                    	   name = emp.getProductName();
                    	   price = emp.getPrice();
                    	   System.out.println(id+"  "+name+"  "+price);
                    			   
                       }
    	   }catch(ProductException e)
    	   {
    		   System.out.println(e.getMessage());
    	   }
    		   
    		  break;
    		   
    	   case 5 :
    	   System.out.println("Thank you take break");
    	   return;
    	   }
       }

	}


}
