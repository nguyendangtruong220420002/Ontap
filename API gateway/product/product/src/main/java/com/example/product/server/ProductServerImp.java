package com.example.product.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.entity.Product;
import com.example.product.responsitory.ProductResponsitory;

@Service
public class ProductServerImp implements ProductServer {
	
	@Autowired
	ProductResponsitory productReponsitory;
	
	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<>();
		products = productReponsitory.findAll();
		return products;
	}

	@Override
	public void addProducts(Product product) {
		// TODO Auto-generated method stub
		productReponsitory.save(product);

	}

}
