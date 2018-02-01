package com.bbs.dao.mapper;

import com.bbs.domain.User;

public interface UserMapper {

	public Integer getMatchCount(User user);

	public User findUserByUserName(User user);

	public void updateLoginInfo(User user);

	public void insertUser(User user);

	public void updateUserInfo(User user);

}