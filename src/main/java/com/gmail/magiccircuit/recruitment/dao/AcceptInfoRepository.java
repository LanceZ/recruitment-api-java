package com.gmail.magiccircuit.recruitment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmail.magiccircuit.recruitment.model.AcceptInfo;

public interface AcceptInfoRepository extends JpaRepository<AcceptInfo, Long> {
	List<AcceptInfo> findByUserId(String userId);

	List<AcceptInfo> findByRecruitInfoId(String recruitInfoId);
}
