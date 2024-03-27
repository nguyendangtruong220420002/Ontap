package com.example.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.entity.User;
import com.example.user.respository.UserRespository;
import com.example.user.server.UserServer;
import com.google.common.base.Optional;

@RestController
@RequestMapping("/api/v2")
public class Usercontroller {
//	@GetMapping("/user")
//	public String getHello() {
//		return "Hello cac ban nhe";
//	}
	@Autowired
	UserServer userServer;
	@Autowired
	UserRespository userRespository;


	@GetMapping("/get")
	public List<User> getAllUser() {
		return userServer.findAllUser();
	}
	// Thêm người dùng vào nhé
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		userServer.addUser(user);
		return user;
	}
	// Tim thong tin theo id
		@GetMapping("/get/{id}")
		public User findByIdUser(@PathVariable Integer id) {
			java.util.Optional<User> optional = userRespository.findById(id);
			User user = null;
			if (optional.isPresent()) {
				user = optional.get();
			} else {
				new RuntimeException("Khong co user theo id này");
			}

			return user;
		}
	
}
