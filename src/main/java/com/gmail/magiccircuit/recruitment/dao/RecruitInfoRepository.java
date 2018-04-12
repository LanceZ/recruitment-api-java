package com.gmail.magiccircuit.recruitment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmail.magiccircuit.recruitment.model.RecruitInfo;

public interface RecruitInfoRepository extends JpaRepository<RecruitInfo, Long> {
	List<RecruitInfo> findByUserId(String userId);
}
