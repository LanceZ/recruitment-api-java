package com.gmail.magiccircuit.recruitment.service;

import com.gmail.magiccircuit.recruitment.model.User;

public interface UserService {
	public User findById(Long id);

	public User findByOpenId(String openId);

	public User save(User user);
}
