package com.hema.productservice.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hema.productservice.model.Product;
import com.hema.productservice.repo.ProductRepo;

import ch.qos.logback.classic.Logger;
import jakarta.transaction.Transactional;

@Service
public class ProductService {
	
	public org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ProductRepo productRepo;

	@Transactional
	public Product addProduct(Product product)	 {

        return productRepo.save(product);
    }

	public Product getProductById(int id)
	{
		return productRepo.findById(id).orElse(null);
		
	}
	

	@Transactional
	public Product deleteProduct(int id)
	{
		Product prod=productRepo.findById(id).orElse(null);
		if(prod!=null)
		{
			productRepo.deleteById(id);
			return prod;
		}
		
		return null;
	}
	
	@Transactional
	public List<Product> getAllProduct()
	{
		
		List<Product> result=productRepo.findAll();
		return result;
	}
	
}
