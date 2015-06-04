package com.bbs.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Posts entity. @author MyEclipse Persistence Tools
 */

public class Posts implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer postsId;
	private UserInfo userInfo;
	private String postsTitle;
	private String postsContent;
	private Timestamp postsTime;
	private Set<?> replies = new HashSet<Object>(0);

	// Constructors

	/** default constructor */
	public Posts() {
	}

	/** minimal constructor */
	public Posts(UserInfo userInfo, String postsTitle, String postsContent) {
		this.userInfo = userInfo;
		this.postsTitle = postsTitle;
		this.postsContent = postsContent;
	}

	/** full constructor */
	public Posts(UserInfo userInfo, String postsTitle, String postsContent,
			Timestamp postsTime, Set<?> replies) {
		this.userInfo = userInfo;
		this.postsTitle = postsTitle;
		this.postsContent = postsContent;
		this.postsTime = postsTime;
		this.replies = replies;
	}

	// Property accessors

	public Integer getPostsId() {
		return this.postsId;
	}

	public void setPostsId(Integer postsId) {
		this.postsId = postsId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getPostsTitle() {
		return this.postsTitle;
	}

	public void setPostsTitle(String postsTitle) {
		this.postsTitle = postsTitle;
	}

	public String getPostsContent() {
		return this.postsContent;
	}

	public void setPostsContent(String postsContent) {
		this.postsContent = postsContent;
	}

	public Timestamp getPostsTime() {
		return this.postsTime;
	}

	public void setPostsTime(Timestamp postsTime) {
		this.postsTime = postsTime;
	}

	public Set<?> getReplies() {
		return this.replies;
	}

	public void setReplies(Set<?> replies) {
		this.replies = replies;
	}


	public String toString() {
		return "Posts [postsId=" + postsId + ", postsTitle=" + postsTitle
				+ ", postsContent=" + postsContent + ", postsTime=" + postsTime
				+ "]";
	}

}