package com.bbs.actions;

import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bbs.domain.Posts;
import com.bbs.domain.UserInfo;
import com.bbs.services.PostsService;
import com.opensymphony.xwork2.ActionSupport;

public class PostsAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Posts posts;
	@Resource
	private PostsService postsService;
	HttpServletRequest request = null;
	HttpSession hs = null;
	
	public String setsession(){
		System.out.println("setsession postsaction");
		
		request = ServletActionContext.getRequest();
		hs = request.getSession(true);
		hs.removeAttribute("postslist");
		String whereSql = "from Posts as p order by p.postsTime desc";
		hs.setAttribute("postslist", postsService.searchPostsService(whereSql));
		return "success";
		
	}
	
	public String publish(){
		System.out.println("publish postsaction");
		//
		request = ServletActionContext.getRequest();
		hs = request.getSession(true);
		UserInfo user = (UserInfo) hs.getAttribute("user");
		Timestamp poststime = new Timestamp(System.currentTimeMillis());
		posts.setPostsId(null);		
		posts.setUserInfo(user);
		posts.setPostsTime(poststime);
		Posts posts1 = postsService.insertPostsService(posts);
		if (posts1 != null) {
			return "success";
		} else {
			return "input";
		}
	}
	
	public String see(){
		System.out.println("see postsaction" + posts.getPostsId());
		
		//postsService.searchPostsService(whereSql);
		request = ServletActionContext.getRequest();
		hs = request.getSession(true);
		hs.removeAttribute("postslist");
		String whereSql = "from Posts as p where p.postsId=" + "'"
				+ posts.getPostsId() + "'";
		hs.setAttribute("postslist", postsService.searchPostsService(whereSql));
		if (hs.getAttribute("postslist") != null) {
			return "success";
		} else {
			return "input";
		}
	}
	
	public String delete(){
		System.out.println("delete postsaction" + posts.getPostsId());
		postsService.deletePostsService(posts);
		
		request = ServletActionContext.getRequest();
		hs = request.getSession(true);
		hs.removeAttribute("postslist");
		String whereSql = "from Posts as p order by p.postsTime desc";
		hs.setAttribute("postslist", postsService.searchPostsService(whereSql));
		/*if (posts1 != null) {*/
		return "success";
		/*} else {
			return "input";
		}*/
	}

	public Posts getPosts() {
		return posts;
	}

	public void setPosts(Posts posts) {
		this.posts = posts;
	}

	public PostsService getPostsService() {
		return postsService;
	}

	public void setPostsService(PostsService postsService) {
		this.postsService = postsService;
	}
	
}
