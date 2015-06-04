package com.bbs.daos;

import java.util.List;

import com.bbs.domain.UserInfo;


public interface UserInfoDao {
	public UserInfo insertUserInfoDao(UserInfo userinfo);

	public UserInfo updateUserInfoDao(UserInfo userinfo);

	public void deleteUserInfoDao(UserInfo userinfo);

	public List<UserInfo> searchUserInfoDao(String whereSql);
}
