package com.gmail.magiccircuit.recruitment.service.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.magiccircuit.recruitment.common.BeanUtil;
import com.gmail.magiccircuit.recruitment.dao.AcceptInfoRepository;
import com.gmail.magiccircuit.recruitment.model.AcceptInfo;
import com.gmail.magiccircuit.recruitment.service.AcceptInfoService;

@Service
public class AcceptInfoServiceImpl implements AcceptInfoService {
	@Resource
	AcceptInfoRepository acceptInfoRepository;

	@Override
	public long count() {
		return acceptInfoRepository.count();
	}

	@Override
	public Page<AcceptInfo> findByUserId(Long userId, Pageable page) {
		return acceptInfoRepository.findByUserId(userId, page);
	}

	@Override
	@Transactional
	public AcceptInfo save(AcceptInfo acceptInfo) {
		if (acceptInfo == null || acceptInfo.getId() == null) {
			return null;
		}

		AcceptInfo old = acceptInfoRepository.getOne(acceptInfo.getId());
		BeanUtil.copyPropertiesIgnoreNull(acceptInfo, old);

		return acceptInfoRepository.saveAndFlush(old);
	}

	@Override
	public Page<AcceptInfo> findByRecruitInfoId(Long recruitInfoId, Pageable page) {
		return acceptInfoRepository.findByRecruitInfoId(recruitInfoId, page);
	}

}
