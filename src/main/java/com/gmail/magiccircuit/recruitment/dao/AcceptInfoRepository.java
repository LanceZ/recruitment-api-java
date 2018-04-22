package com.gmail.magiccircuit.recruitment.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gmail.magiccircuit.recruitment.model.AcceptInfo;

public interface AcceptInfoRepository extends JpaRepository<AcceptInfo, Long> {
	Page<AcceptInfo> findByUserId(Long userId, Pageable page);

	Page<AcceptInfo> findByRecruitInfoId(Long recruitInfoId, Pageable page);
}
