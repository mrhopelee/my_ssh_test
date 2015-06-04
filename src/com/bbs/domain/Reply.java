package com.bbs.domain;

import java.sql.Timestamp;

/**
 * Reply entity. @author MyEclipse Persistence Tools
 */

public class Reply implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long replyId;
	private UserInfo userInfo;
	private Posts posts;
	private String replyContent;
	private Timestamp replyTime;

	// Constructors

	/** default constructor */
	public Reply() {
	}

	/** minimal constructor */
	public Reply(UserInfo userInfo, Posts posts, String replyContent) {
		this.userInfo = userInfo;
		this.posts = posts;
		this.replyContent = replyContent;
	}

	/** full constructor */
	public Reply(UserInfo userInfo, Posts posts, String replyContent,
			Timestamp replyTime) {
		this.userInfo = userInfo;
		this.posts = posts;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
	}

	// Property accessors

	public Long getReplyId() {
		return this.replyId;
	}

	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Posts getPosts() {
		return this.posts;
	}

	public void setPosts(Posts posts) {
		this.posts = posts;
	}

	public String getReplyContent() {
		return this.replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Timestamp getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}

}