package com.gmail.magiccircuit.recruitment.service.impl;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.magiccircuit.recruitment.common.BeanUtil;
import com.gmail.magiccircuit.recruitment.dao.UserRepository;
import com.gmail.magiccircuit.recruitment.model.User;
import com.gmail.magiccircuit.recruitment.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	UserRepository userRepository;

	@Override
	@Transactional
	public User save(User user) {
		if (user == null || user.getId() == null) {
			return null;
		}

		User old = userRepository.getOne(user.getId());
		BeanUtil.copyPropertiesIgnoreNull(user, old);

		return userRepository.saveAndFlush(old);
	}

	@Override
	public User findById(Long id) {
		Optional<User> u = userRepository.findById(id);

		return u.orElse(null);
	}

	@Override
	public User findByOpenId(String openId) {
		return userRepository.findByOpenId(openId);
	}

}
