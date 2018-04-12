package com.gmail.magiccircuit.recruitment.view;

import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;

public class LoginInfoVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	WxMaUserInfo userInfo;

	public WxMaUserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(WxMaUserInfo userInfo) {
		this.userInfo = userInfo;
	}
}
