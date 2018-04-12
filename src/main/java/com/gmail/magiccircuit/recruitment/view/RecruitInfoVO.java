package com.gmail.magiccircuit.recruitment.view;

import com.gmail.magiccircuit.recruitment.model.RecruitInfo;
import com.gmail.magiccircuit.recruitment.model.User;

public class RecruitInfoVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	RecruitInfo recruitInfo;

	public RecruitInfo getRecruitInfo() {
		return recruitInfo;
	}

	public void setRecruitInfo(RecruitInfo recruitInfo) {
		this.recruitInfo = recruitInfo;
	}

	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
