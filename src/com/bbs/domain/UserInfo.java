package com.bbs.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String userName;
	private String userPassword;
	private String sex;
	private Date birthday;
	private String telephone;
	private String email;
	private String address;
	private String remark;
	private Integer userType;
	private Set<?> postses = new HashSet<Object>(0);
	private Set<?> replies = new HashSet<Object>(0);

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(String userName, String userPassword, String sex) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.sex = sex;
	}

	/** full constructor */
	public UserInfo(String userName, String userPassword, String sex,
			Date birthday, String telephone, String email, String address,
			String remark, Integer userType, Set<?> postses, Set<?> replies) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.sex = sex;
		this.birthday = birthday;
		this.telephone = telephone;
		this.email = email;
		this.address = address;
		this.remark = remark;
		this.userType = userType;
		this.postses = postses;
		this.replies = replies;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Set<?> getPostses() {
		return this.postses;
	}

	public void setPostses(Set<?> postses) {
		this.postses = postses;
	}

	public Set<?> getReplies() {
		return this.replies;
	}

	public void setReplies(Set<?> replies) {
		this.replies = replies;
	}


	public String toString() {
		return "UserInfo [userName=" + userName + ", userPassword="
				+ userPassword + ", sex=" + sex + ", birthday=" + birthday
				+ ", telephone=" + telephone + ", email=" + email
				+ ", address=" + address + ", remark=" + remark + "]";
	}

}