package com.hema.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hema.productservice.model.Product;
import com.hema.productservice.repo.ProductRepo;
import com.hema.productservice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
    public Product add(@RequestBody Product product) {
//        LOGGER.info("Department add: {}", product);
       Product prod=productService.addProduct(product);
       return prod;
    }
	
	@GetMapping("/get/{id}")
	public Product getById(@PathVariable int id)
	{
		return productService.getProductById(id);
	}
	@GetMapping("/get/price/{id}")
	public int getPriceById(@PathVariable int id)
	{
		Product prod= productService.getProductById(id);
		return prod.getProduct_price();
	}
	@GetMapping("/get")
	public List<Product> getAllProduct()
	{
		return productService.getAllProduct();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		Product prod=productService.deleteProduct(id);
		if(prod==null)
		{
			return "No such product";
		}
		
		return "Product "+id+" Deleted";
		
	}
	
	

}
