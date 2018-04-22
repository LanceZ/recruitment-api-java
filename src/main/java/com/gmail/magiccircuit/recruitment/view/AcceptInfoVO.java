package com.gmail.magiccircuit.recruitment.view;

import org.springframework.data.domain.Page;

import com.gmail.magiccircuit.recruitment.model.AcceptInfo;

public class AcceptInfoVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	AcceptInfo acceptInfo;

	public AcceptInfo getAcceptInfo() {
		return acceptInfo;
	}

	public void setAcceptInfo(AcceptInfo acceptInfo) {
		this.acceptInfo = acceptInfo;
	}

	Page<AcceptInfo> acceptInfoList;

	public Page<AcceptInfo> getAcceptInfoList() {
		return acceptInfoList;
	}

	public void setAcceptInfoList(Page<AcceptInfo> acceptInfoList) {
		this.acceptInfoList = acceptInfoList;
	}
}
