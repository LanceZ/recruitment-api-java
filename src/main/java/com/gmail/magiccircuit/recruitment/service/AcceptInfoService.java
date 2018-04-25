package com.gmail.magiccircuit.recruitment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gmail.magiccircuit.recruitment.model.AcceptInfo;

public interface AcceptInfoService {
	public long count();

	public Page<AcceptInfo> findByUserId(Long userId, Pageable page);

	public Page<AcceptInfo> findByRecruitInfoId(Long recruitInfoId, Pageable page);

	public AcceptInfo save(AcceptInfo acceptInfo);
}
