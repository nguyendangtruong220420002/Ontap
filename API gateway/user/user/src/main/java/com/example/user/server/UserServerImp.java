package com.example.user.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.entity.User;
import com.example.user.respository.UserRespository;

@Service
public class UserServerImp implements UserServer {
	@Autowired
	UserRespository userRespository;
	
	public List<User> findAllUser() {
		List<User> users= new ArrayList<>();
		users = userRespository.findAll();
		System.out.println(users);
		return users;
		// TODO Auto-generated method stub
		

	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userRespository.save(user);
	}
	
}
