package com.gmail.magiccircuit.recruitment.service.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.magiccircuit.recruitment.common.BeanUtil;
import com.gmail.magiccircuit.recruitment.dao.RecruitInfoRepository;
import com.gmail.magiccircuit.recruitment.model.RecruitInfo;

@Service
public class RecruitInfoServiceImpl implements com.gmail.magiccircuit.recruitment.service.RecruitInfoService {
	@Resource
	RecruitInfoRepository recruitInfoRepository;

	@Override
	public RecruitInfo findById(Long id) {
		return recruitInfoRepository.findById(id).orElse(null);
	}

	@Override
	public Page<RecruitInfo> findAll(Pageable page) {
		return recruitInfoRepository.findAll(page);
	}

	@Override
	public Page<RecruitInfo> findByUserId(Long userId, Pageable page) {
		return recruitInfoRepository.findByUserId(userId, page);
	}

	@Override
	@Transactional
	public RecruitInfo save(RecruitInfo recruitInfo) {
		if (recruitInfo == null || recruitInfo.getId() == null) {
			return null;
		}

		RecruitInfo old = recruitInfoRepository.getOne(recruitInfo.getId());
		BeanUtil.copyPropertiesIgnoreNull(recruitInfo, old);

		return recruitInfoRepository.saveAndFlush(old);
	}

}
