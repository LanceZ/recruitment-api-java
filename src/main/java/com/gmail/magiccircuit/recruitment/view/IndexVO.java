package com.gmail.magiccircuit.recruitment.view;

import org.springframework.data.domain.Page;

import com.gmail.magiccircuit.recruitment.model.RecruitInfo;

public class IndexVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	Page<RecruitInfo> recruitInfoList;

	long acceptCount;

	public Page<RecruitInfo> getRecruitInfoList() {
		return recruitInfoList;
	}

	public void setRecruitInfoList(Page<RecruitInfo> recruitInfoList) {
		this.recruitInfoList = recruitInfoList;
	}

	public long getAcceptCount() {
		return acceptCount;
	}

	public void setAcceptCount(long acceptCount) {
		this.acceptCount = acceptCount;
	}
}
