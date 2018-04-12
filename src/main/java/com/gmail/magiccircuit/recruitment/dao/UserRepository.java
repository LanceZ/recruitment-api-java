package com.gmail.magiccircuit.recruitment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmail.magiccircuit.recruitment.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByOpenId(String openId);
}
