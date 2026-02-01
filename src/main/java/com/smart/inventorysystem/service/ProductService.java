package com.smart.inventorysystem.service;

import com.smart.inventorysystem.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
	Product create(Product product);
	
Product update(int id, Product product);

void disable(int id);

Page<Product> getAll(Pageable pageable, String keyword);

}
