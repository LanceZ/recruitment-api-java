package com.gmail.magiccircuit.recruitment.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gmail.magiccircuit.recruitment.model.User;
import com.gmail.magiccircuit.recruitment.service.UserService;
import com.gmail.magiccircuit.recruitment.view.BaseVO;
import com.gmail.magiccircuit.recruitment.view.UserVO;

@RestController
public class UserController {
	@Resource
	UserService userService;

	@RequestMapping(path = "/api/user", method = RequestMethod.GET)
	public UserVO getUser(HttpSession session) {
		UserVO vo = new UserVO();
		if (session == null || session.getAttribute("user") == null) {
			vo.setResCode(BaseVO.RES_CODE_ERR_SESSION_NULL);
			vo.setResMsg("can not get user session");
			return vo;
		}
		User user = (User) session.getAttribute("user");
		User u = userService.findById(user.getId());
		// 隐藏openId
		if (u != null) {
			u.setOpenId("");
		}
		vo.setResCode(BaseVO.RES_CODE_SUCC);
		vo.setUser(u);

		return vo;
	}

	@RequestMapping(path = "/api/user", method = RequestMethod.PUT)
	public UserVO saveUser(@RequestBody User user, HttpSession session) {
		UserVO vo = new UserVO();
		if (session == null || session.getAttribute("user") == null) {
			vo.setResCode(BaseVO.RES_CODE_ERR_SESSION_NULL);
			vo.setResMsg("can not get user session");
			return vo;
		}
		User login = (User) session.getAttribute("user");
		user.setId(login.getId());
		user = userService.save(user);

		vo.setResCode(BaseVO.RES_CODE_SUCC);
		User u = new User();
		u.setId(user.getId());
		vo.setUser(u);

		return vo;
	}
}
