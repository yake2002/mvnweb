package com.bbs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bbs.domain.LoginLog;

@Repository
public class LoginLogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertLoginLog(LoginLog loginLog) {

		String sqlString = "INSERT INTO t_login_log(user_id,ip,login_datetime)"

				+ "VALUE(?,?,?)";

		Object[] args = { loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate() };

		jdbcTemplate.update(sqlString, args);

	}

}