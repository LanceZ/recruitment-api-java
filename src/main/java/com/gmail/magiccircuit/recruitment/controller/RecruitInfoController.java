package com.gmail.magiccircuit.recruitment.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gmail.magiccircuit.recruitment.model.RecruitInfo;
import com.gmail.magiccircuit.recruitment.model.User;
import com.gmail.magiccircuit.recruitment.service.AcceptInfoService;
import com.gmail.magiccircuit.recruitment.service.RecruitInfoService;
import com.gmail.magiccircuit.recruitment.view.BaseVO;
import com.gmail.magiccircuit.recruitment.view.IndexVO;
import com.gmail.magiccircuit.recruitment.view.RecruitInfoVO;

@RestController
public class RecruitInfoController {
	@Resource
	RecruitInfoService recruitInfoService;

	@Resource
	AcceptInfoService acceptInfoService;

	@RequestMapping(path = "/api/recruitinfo/{id}", method = RequestMethod.GET)
	public RecruitInfoVO getRecruitInfo(@PathVariable Long id, HttpSession session) {
		RecruitInfo ri = recruitInfoService.findById(id);
		RecruitInfoVO vo = new RecruitInfoVO();
		if (ri == null) {
			vo.setResCode(BaseVO.RES_CODE_ERR_DATA_NOT_FOUND);
			vo.setResMsg("没有找到招聘信息");
			return vo;
		} else {
			vo.setResCode(BaseVO.RES_CODE_SUCC);
			vo.setRecruitInfo(ri);
			User u = (User) session.getAttribute("user");
			if (u != null) {
				u.setOpenId("");
				vo.setUser(u);
			}
		}
		return vo;
	}

	@RequestMapping(path = "/api/recruitinfo", method = RequestMethod.GET)
	public IndexVO getRecruitInfoList(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "pageSize", defaultValue = "30") int pageSize) {
		if (pageSize > 50) {
			pageSize = 50;
		}

		Pageable p = PageRequest.of(page, pageSize, Sort.Direction.DESC, "createTime");
		Page<RecruitInfo> list = recruitInfoService.findAll(p);

		long acceptCount = acceptInfoService.count();

		IndexVO vo = new IndexVO();
		vo.setResCode(BaseVO.RES_CODE_SUCC);
		vo.setRecruitInfoList(list);
		vo.setAcceptCount(acceptCount);

		return vo;
	}

	@RequestMapping(path = "/api/recruitinfo", method = RequestMethod.POST)
	public RecruitInfoVO addRecruitInfo(@RequestBody @Validated RecruitInfo recruitInfo, BindingResult bindingResult,
			HttpSession session) {
		if (bindingResult.hasErrors()) {
			StringBuilder errMsg = new StringBuilder();
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				errMsg.append(fieldError.getDefaultMessage()).append(" ");
			}
			RecruitInfoVO vo = new RecruitInfoVO();
			vo.setResCode(BaseVO.RES_CODE_ERR_CHECK_PARAMS_FAILED);
			vo.setResMsg(errMsg.toString());
			return vo;
		}
		if (session == null || session.getAttribute("user") == null) {
			RecruitInfoVO vo = new RecruitInfoVO();
			vo.setResCode(BaseVO.RES_CODE_ERR_SESSION_NULL);
			vo.setResMsg("can not get user session");
			return vo;
		}
		RecruitInfoVO vo = new RecruitInfoVO();

		User user = (User) session.getAttribute("user");
		recruitInfo.setUserId(user.getId());
		recruitInfo.setStatus(RecruitInfo.STATUS_OPENING);
		recruitInfo.setCreateTime(new Date());

		recruitInfo = recruitInfoService.save(recruitInfo);
		vo.setRecruitInfo(recruitInfo);
		vo.setResCode(BaseVO.RES_CODE_SUCC);

		return vo;
	}

	@RequestMapping(path = "/api/user/recruitinfo", method = RequestMethod.GET)
	public RecruitInfoVO getRecruitInfoListByUser(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "pageSize", defaultValue = "30") int pageSize, HttpSession session) {
		if (pageSize > 50) {
			pageSize = 50;
		}

		if (session == null || session.getAttribute("user") == null) {
			RecruitInfoVO vo = new RecruitInfoVO();
			vo.setResCode(BaseVO.RES_CODE_ERR_SESSION_NULL);
			vo.setResMsg("can not get user session");
			return vo;
		}

		User user = (User) session.getAttribute("user");

		Pageable p = PageRequest.of(page, pageSize, Sort.Direction.DESC, "createTime");
		Page<RecruitInfo> list = recruitInfoService.findByUserId(user.getId(), p);

		RecruitInfoVO vo = new RecruitInfoVO();
		vo.setResCode(BaseVO.RES_CODE_SUCC);
		vo.setRecruitInfoList(list);

		return vo;
	}
}
