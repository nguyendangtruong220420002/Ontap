package com.example.product.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product.entity.Product;


public interface UserRespository extends JpaRepository<Product, Integer> {

}
