package com.hema.productservice.repo;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.WebApplicationContext;

import com.hema.productservice.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}
