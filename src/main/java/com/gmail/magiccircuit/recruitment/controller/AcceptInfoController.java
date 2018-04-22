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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gmail.magiccircuit.recruitment.dao.AcceptInfoRepository;
import com.gmail.magiccircuit.recruitment.model.AcceptInfo;
import com.gmail.magiccircuit.recruitment.model.User;
import com.gmail.magiccircuit.recruitment.view.AcceptInfoVO;
import com.gmail.magiccircuit.recruitment.view.BaseVO;

@RestController
public class AcceptInfoController {
	@Resource
	AcceptInfoRepository acceptInfoRepository;

	@RequestMapping(path = "/api/user/acceptinfo", method = RequestMethod.GET)
	public AcceptInfoVO getAcceptInfoListByUser(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "pageSize", defaultValue = "30") int pageSize, HttpSession session) {
		if (pageSize > 50) {
			pageSize = 50;
		}

		if (session == null || session.getAttribute("user") == null) {
			AcceptInfoVO vo = new AcceptInfoVO();
			vo.setResCode(BaseVO.RES_CODE_ERR_SESSION_NULL);
			vo.setResMsg("can not get user session");
			return vo;
		}

		User user = (User) session.getAttribute("user");

		Pageable p = PageRequest.of(page, pageSize, Sort.Direction.DESC, "createTime");
		Page<AcceptInfo> list = acceptInfoRepository.findByUserId(user.getId(), p);

		AcceptInfoVO vo = new AcceptInfoVO();
		vo.setResCode(BaseVO.RES_CODE_SUCC);
		vo.setAcceptInfoList(list);

		return vo;
	}

	@RequestMapping(path = "/api/acceptinfo", method = RequestMethod.POST)
	public AcceptInfoVO addAcceptInfo(@RequestBody @Validated AcceptInfo acceptInfo, BindingResult bindingResult,
			HttpSession session) {
		if (bindingResult.hasErrors()) {
			StringBuilder errMsg = new StringBuilder();
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				errMsg.append(fieldError.getDefaultMessage()).append(" ");
			}
			AcceptInfoVO vo = new AcceptInfoVO();
			vo.setResCode(BaseVO.RES_CODE_ERR_CHECK_PARAMS_FAILED);
			vo.setResMsg(errMsg.toString());
			return vo;
		}
		if (session == null || session.getAttribute("user") == null) {
			AcceptInfoVO vo = new AcceptInfoVO();
			vo.setResCode(BaseVO.RES_CODE_ERR_SESSION_NULL);
			vo.setResMsg("can not get user session");
			return vo;
		}
		AcceptInfoVO vo = new AcceptInfoVO();

		User user = (User) session.getAttribute("user");
		acceptInfo.setUserId(user.getId());
		acceptInfo.setCreateTime(new Date());

		acceptInfo = acceptInfoRepository.save(acceptInfo);
		vo.setAcceptInfo(acceptInfo);
		vo.setResCode(BaseVO.RES_CODE_SUCC);

		return vo;
	}
}
