package com.example.product.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.product.entity.Product;
import com.example.product.responsitory.OrderResponsitory;
import com.example.product.responsitory.ProductResponsitory;
import com.example.product.server.ProductServer;
import com.example.user.entity.User;


@RestController
@RequestMapping("/api/v1")
public class ProductController {
//	@GetMapping("/product")
//	public String getHello() {
//		return "Product Xin Chào";
//	}
	@Autowired
	private ProductServer productServer;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private ProductResponsitory productReponsitory;

	// Lấy danh sách sản phẩm
	@GetMapping("/get")
	public List<Product> getAllProducts() {
		return productServer.findAllProducts();
	}

	// Thêm mới sản phẩm
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		productServer.addProducts(product);
		return product;
	}

	// Lấy thong tin người dùng và product
	@GetMapping("/orderproduct/{id}/{productId}")
	public ResponseEntity<OrderResponsitory> orderProductByUser(@PathVariable Integer id,
			@PathVariable Integer productId) {
		OrderResponsitory orderResponsitory = new OrderResponsitory();
		String url = "http://localhost:8802/api/v2/get/" + id;
		ResponseEntity<User> reponse = restTemplate.getForEntity(url, User.class);
		Optional<Product> optional = productReponsitory.findById(productId);
		Product product = null;
		if (optional.isPresent()) {
			product = optional.get();
		} else {
			new RuntimeException("Khong co user theo id này");
		}
		User user = reponse.getBody();
		orderResponsitory.setUser(user);
		orderResponsitory.setProduct(product);
		return new ResponseEntity<OrderResponsitory>(orderResponsitory, HttpStatus.OK);
	}
}
