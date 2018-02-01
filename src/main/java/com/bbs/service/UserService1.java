package com.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.LoginLogDao;
import com.bbs.dao.UserDao;
import com.bbs.domain.LoginLog;
import com.bbs.domain.User;

@Service
public class UserService1 {

	@Autowired
	private UserDao userDao;

	@Autowired
	private LoginLogDao loginLogDao;

	public boolean hasMatchUser(String userName, String password) {

		int matchCount = userDao.getMatchCount(userName, password);

		return matchCount > 0;

	}

	public User findUserByUserName(String userName) {

		return userDao.findUserByUserName(userName);

	}

	public void loginSucess(User user) {

		user.setCredits(5 + user.getCredits());

		LoginLog loginLog = new LoginLog();

		loginLog.setUserId(user.getUserId());

		loginLog.setIp(user.getLastIp());

		loginLog.setLoginDate(user.getLastVisit());

		userDao.updateLoginInfo(user);

		loginLogDao.insertLoginLog(loginLog);

	}

}