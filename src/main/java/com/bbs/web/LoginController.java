package com.bbs.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.domain.User;
import com.bbs.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login")
	public String toLoginPage() {

		return "login";

	}
	
	@RequestMapping(value = "/checkLogin")
	public String loginPage(HttpServletRequest request, User user) {

		Boolean loginSucess = userService.hasMatchUser(user);

		if (loginSucess) {
			userService.loginSucess(userService.findUserByUserName(user));
			request.getSession().setAttribute("Info", "");
			return "welcome";
		} else {
			request.getSession().setAttribute("Info", "请重新输入!!");
			return "redirect:/login.do";
		}

	}

}