package com.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.mapper.LoginLogMapper;
import com.bbs.domain.LoginLog;

@Service
public class LoginLogServiceImpl implements LoginLogService {

	@Autowired
	private LoginLogMapper loginLogMapper;

	@Override
	public void insertLoginLog(LoginLog loginLog) {

		loginLogMapper.insertLoginLog(loginLog);

	}

}