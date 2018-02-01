package com.bbs.dao;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowCallbackHandler;

import org.springframework.stereotype.Repository;

import com.bbs.domain.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int getMatchCount(String userName, String password) {

		String sqlString = "SELECT count(*) FROM t_user "

				+ "WHERE user_name=? and password=?";

		return jdbcTemplate.queryForObject(sqlString, new Object[] { userName, password }, java.lang.Integer.class);

	}

	public User findUserByUserName(final String userName) {

		String sqlString = "SELECT user_id,user_name,credits "

				+ "FROM t_user WHERE user_name=?";

		final User user = new User();

		jdbcTemplate.query(sqlString, new Object[] { userName },

				new RowCallbackHandler() {

					public void processRow(ResultSet rs) throws SQLException {

						// TODO Auto-generated method stub
						user.setUserId(rs.getInt("user_id"));
						user.setUserName(userName);
						user.setCredits(rs.getInt("credits"));

					}

				});

		return user;

	}

	public void updateLoginInfo(User user) {

		String sqlString = "UPDATE t_user SET last_visit=?,last_ip=?,credits=?"

				+ "WHERE user_id=?";

		jdbcTemplate.update(sqlString,
				new Object[] { user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId() });

	}

}