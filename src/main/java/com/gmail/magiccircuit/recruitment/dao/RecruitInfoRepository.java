package com.gmail.magiccircuit.recruitment.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gmail.magiccircuit.recruitment.model.RecruitInfo;

public interface RecruitInfoRepository extends JpaRepository<RecruitInfo, Long> {
	Page<RecruitInfo> findByUserId(Long userId, Pageable page);
}
