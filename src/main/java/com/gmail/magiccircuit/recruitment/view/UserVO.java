package com.gmail.magiccircuit.recruitment.view;

import com.gmail.magiccircuit.recruitment.model.User;

public class UserVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
