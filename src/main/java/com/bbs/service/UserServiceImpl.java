package com.bbs.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.mapper.UserMapper;
import com.bbs.domain.LoginLog;
import com.bbs.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private LoginLogService loginLogService;

	@Override
	public Boolean hasMatchUser(User user) {

		Integer matchCount = userMapper.getMatchCount(user);
		
		if (matchCount > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public User findUserByUserName(User user) {

		return userMapper.findUserByUserName(user);

	}

	@Override
	public void loginSucess(User user) {

		user.setCredits(5 + user.getCredits());

		user.setLastVisit(new Date());

		LoginLog loginLog = new LoginLog();

		loginLog.setUserId(user.getUserId());

		loginLog.setIp(user.getLastIp());

		loginLog.setLoginDate(new Date());

		userMapper.updateLoginInfo(user);

		loginLogService.insertLoginLog(loginLog);

	}

	@Override
	public void insertUser(User user) {

		userMapper.insertUser(user);

	}

	@Override
	public void UpdateUser(User user) {

		userMapper.updateUserInfo(user);

	}

}