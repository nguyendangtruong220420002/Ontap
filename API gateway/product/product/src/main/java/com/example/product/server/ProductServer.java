package com.example.product.server;

import java.util.List;

import com.example.product.entity.Product;

public interface ProductServer {
	List<Product> findAllProducts();

    void addProducts(Product product);
}
