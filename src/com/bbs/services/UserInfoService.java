package com.bbs.services;

import java.util.List;

import com.bbs.domain.UserInfo;

public interface UserInfoService {
	public UserInfo insertUserInfoService(UserInfo userinfo);

	public UserInfo updateUserInfoService(UserInfo userinfo);

	public void deleteUserInfoService(UserInfo userinfo);

	public List<UserInfo> searchUserInfoService(String whereSql);

	public UserInfo cheakUserInfoService(UserInfo userinfo);
	
	public UserInfo quitService(UserInfo userinfo);
	
}
