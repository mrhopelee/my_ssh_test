package com.bbs.actions;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bbs.domain.UserInfo;
import com.bbs.services.UserInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserInfo userinfo;
	@Resource
	private UserInfoService userinfoService;
	private String repassword = null;
	HttpServletRequest request = null;
	HttpSession hs = null;

	public String register() {
		UserInfo userinfo1;
		System.out.print("register action->");
		userinfo1 = userinfoService.insertUserInfoService(userinfo);
		if (userinfo1 != null) {
			return "success";
		} else {
			return "input";
		}
	}

	public void validateRegister() {
		this.clearFieldErrors();
		if (repassword == null || userinfo.getUserPassword() == null) {
			addFieldError("password", "密码与确认密码都不能为空，请输入不少于6位的密码");
		}
		if (repassword.length()<6 || userinfo.getUserPassword().length()<6) {
			addFieldError("password", "密码与确认密码都不能不少于6位");
		}
		if (!repassword.equals(userinfo.getUserPassword())) {
			addFieldError("password", "密码与确认密码不一致，请重新输入");
		}

		if (userinfo.getUserPassword().length() < 6) {
			addFieldError("username", "用户名不能少于6位数");
		}
		if (userinfo.getSex()==null) {
			addFieldError("sex", "请选择你的性别");
		}
		super.validate();
	}

	public String login() {
		UserInfo userinfo1;
		System.out.print("login action->");

		userinfo1 = (UserInfo) userinfoService.cheakUserInfoService(userinfo);

		if (userinfo1 != null) {
			request = ServletActionContext.getRequest();
			hs = request.getSession(true);
			hs.removeAttribute("user");
			hs.setAttribute("user", userinfo1);
			return "success";
		} else {
			addFieldError("login", "用户不存在或密码错误");
			return "input";
		}
	}

	/*
	 * public String getUI(){ UserInfo userinfo1; String whereSql =
	 * "from UserInfo where userName=" +"'"+ userinfo.getUserId()+"'";
	 * System.out.println("getUI action " + userinfo.getUserName() + " " +
	 * userinfo.getUserPassword()); userinfo1 = (UserInfo)
	 * userinfoService.searchUserInfoService(whereSql); if (userinfo1 != null) {
	 * return "success"; } else { return "input"; } }
	 */

	public String update() {
		System.out.print("update action->");
		request = ServletActionContext.getRequest();
		hs = request.getSession(true);
		UserInfo user = (UserInfo) (hs.getAttribute("user"));
		userinfo.setUserId(user.getUserId());
		userinfo.setUserPassword(user.getUserPassword());
		user = (UserInfo) userinfoService.updateUserInfoService(userinfo);

		if (user != null) {
			hs.removeAttribute("user");
			hs.setAttribute("user", user);
			user = (UserInfo) (hs.getAttribute("user"));
			return "success";
		} else {
			return "input";
		}
	}

	public String quit() {
		// UserInfo userinfo1;
		System.out.print("quit action->");
		request = ServletActionContext.getRequest();
		hs = request.getSession(true);
		hs.removeAttribute("user");
		// userinfo1 = (UserInfo) userinfoService.quitService(userinfo);
		if (hs.getAttribute("user") == null) {
			return "success";
		} else {
			return "input";
		}
	}

	public String saveUser() {
		return "success";
	}

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public UserInfoService getUserinfoService() {
		return userinfoService;
	}

	public void setUserinfoService(UserInfoService userinfoService) {
		this.userinfoService = userinfoService;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

}
