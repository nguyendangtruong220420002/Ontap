package com.example.user.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.entity.User;

public interface UserRespository extends JpaRepository<User, Integer> {

}
