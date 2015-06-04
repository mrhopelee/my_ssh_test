package com.bbs.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.daos.UserInfoDao;
import com.bbs.domain.UserInfo;

@Transactional
public class UserInfoServiceImpl implements UserInfoService {
	@Resource
	UserInfoDao userinfoDao;
	

	public UserInfo insertUserInfoService(UserInfo userinfo) {
		System.out.println("insertUserInfoService : " + userinfo.toString());
		userinfo.setUserId(null);
		userinfo.setUserType(0);
		return userinfoDao.insertUserInfoDao(userinfo);
	}

	public UserInfo updateUserInfoService(UserInfo userinfo) {
		System.out.println("updateUserInfoService");
		//user = userinfoDao.updateUserInfoDao(userinfo, user.getUserId());
		//hs.setAttribute("user", null);
		return userinfoDao.updateUserInfoDao(userinfo);
	}

	public void deleteUserInfoService(UserInfo userinfo) {
		userinfoDao.deleteUserInfoDao(userinfo);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<UserInfo> searchUserInfoService(String whereSql) {

		return userinfoDao.searchUserInfoDao(whereSql);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public UserInfo cheakUserInfoService(UserInfo userinfo) {
		System.out.println("cheakUserInfoService");
		String whereSql = "from UserInfo where userName=" + "'"
				+ userinfo.getUserName() + "'";
		List<UserInfo> list = userinfoDao.searchUserInfoDao(whereSql);

		if (list.size() > 0) {
			for (UserInfo userinfo1 : list) {
				if ((userinfo.getUserPassword()).equals(userinfo1
						.getUserPassword())) {
					return userinfo1;
				}
			}
		}
		return null;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public UserInfo quitService(UserInfo userinfo) {
		System.out.println("quitService");
		/*request = ServletActionContext.getRequest();
		hs = request.getSession(true);
		//hs.setAttribute("user", null);
		hs.removeAttribute("user");
		return (UserInfo) hs.getAttribute("user");*/
		return null;
	}

}
