package com.gmail.magiccircuit.recruitment.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gmail.magiccircuit.recruitment.dao.UserRepository;
import com.gmail.magiccircuit.recruitment.model.User;
import com.gmail.magiccircuit.recruitment.view.BaseVO;
import com.gmail.magiccircuit.recruitment.view.LoginInfoVO;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import me.chanjar.weixin.common.exception.WxErrorException;

@RestController
public class LoginController {
	@Resource
	UserRepository userRepository;

	@Resource
	private WxMaService wxService;

	@RequestMapping(path = "/api/login", method = RequestMethod.GET)
	public String getRecruitInfo(@RequestParam String code, HttpSession session) {
		String sessionId = "";

		if (StringUtils.isEmpty(code)) {
			return sessionId;
		}

		try {
			WxMaJscode2SessionResult result = wxService.getUserService().getSessionInfo(code);
			String openId = result.getOpenid();

			User user = userRepository.findByOpenId(openId);
			if (user == null) {
				user = new User();
				user.setOpenId(openId);
				user = userRepository.save(user);
			}

			session.setAttribute("user", user);
			session.setAttribute("wxSession", result);

			sessionId = session.getId();
		} catch (WxErrorException e) {
			e.printStackTrace();
		}

		return sessionId;
	}

	/**
	 * <pre>
	 * 获取用户信息接口
	 * </pre>
	 */
	@RequestMapping(value = "/api/loginInfo", method = RequestMethod.GET)
	public LoginInfoVO getLoninInfo(String signature, String rawData, String encryptedData, String iv,
			HttpSession session) {
		if (session == null || session.getAttribute("wxSession") == null) {
			LoginInfoVO vo = new LoginInfoVO();
			vo.setResCode(BaseVO.RES_CODE_ERR_SESSION_NULL);
			vo.setResMsg("can not get user session");
			return vo;
		}
		WxMaJscode2SessionResult result = (WxMaJscode2SessionResult) session.getAttribute("wxSession");
		String sessionKey = result.getSessionKey();
		// 用户信息校验
		if (!this.wxService.getUserService().checkUserInfo(sessionKey, rawData, signature)) {
			LoginInfoVO vo = new LoginInfoVO();
			vo.setResCode(BaseVO.RES_CODE_ERR_CHECK_USER_FAILED);
			vo.setResMsg("user check failed");
			return vo;
		}

		// 解密用户信息
		WxMaUserInfo userInfo = this.wxService.getUserService().getUserInfo(sessionKey, encryptedData, iv);

		LoginInfoVO vo = new LoginInfoVO();
		vo.setResCode(BaseVO.RES_CODE_SUCC);
		vo.setUserInfo(userInfo);

		return vo;
	}
}
