package com.gmail.magiccircuit.recruitment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gmail.magiccircuit.recruitment.model.RecruitInfo;

public interface RecruitInfoService {
	public RecruitInfo findById(Long id);

	public Page<RecruitInfo> findAll(Pageable page);

	public Page<RecruitInfo> findByUserId(Long userId, Pageable page);

	public RecruitInfo save(RecruitInfo recruitInfo);
}
