package com.bbs.daos;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.bbs.domain.UserInfo;

public class UserInfoDaoImpl implements UserInfoDao {
	@Resource
	private SessionFactory sessionFactory;

	public UserInfo insertUserInfoDao(UserInfo userinfo) {
		
		sessionFactory.getCurrentSession().persist(userinfo);
		return userinfo;
	}

	public UserInfo updateUserInfoDao(UserInfo newuserinfo) {
		System.out.println("updateUserInfoDao ");
		sessionFactory.getCurrentSession().clear();
		sessionFactory.getCurrentSession().merge(newuserinfo);
		/*UserInfo ui = (UserInfo) sessionFactory.getCurrentSession().load(UserInfo.class, id);
		if (!ui.getUserPassword().equals(newuserinfo.getUserPassword())) {
			ui.setUserPassword(newuserinfo.getUserPassword());
		}
		if (!ui.getSex().equals(newuserinfo.getSex())) {
			ui.setSex(newuserinfo.getSex());
		}
		if (!ui.getBirthday().equals(newuserinfo.getBirthday())) {
			ui.setBirthday(newuserinfo.getBirthday());
		}
		if (!ui.getTelephone().equals(newuserinfo.getTelephone())) {
			ui.setTelephone(newuserinfo.getTelephone());
		}
		if (!ui.getEmail().equals(newuserinfo.getEmail())) {
			ui.setEmail(newuserinfo.getEmail());
		}
		if (!ui.getAddress().equals(newuserinfo.getAddress())) {
			ui.setAddress(newuserinfo.getAddress());
		}
		if (!ui.getRemark().equals(newuserinfo.getRemark())) {
			ui.setRemark(newuserinfo.getRemark());
		}*/
		return newuserinfo;
	}

	public void deleteUserInfoDao(UserInfo userinfo) {
		sessionFactory.getCurrentSession().delete(userinfo);
	}

	@SuppressWarnings("unchecked")
	public List<UserInfo> searchUserInfoDao(String whereSql) {
		System.out.println("searchUserInfoDao ");
		Query query = sessionFactory.getCurrentSession().createQuery(whereSql);
		List<UserInfo> userinfolist = (List<UserInfo>) query.list();
		return userinfolist;
	}

}
