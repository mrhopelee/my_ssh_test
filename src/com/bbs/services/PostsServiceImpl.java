package com.bbs.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.daos.PostsDao;
import com.bbs.domain.Posts;

@Transactional
public class PostsServiceImpl implements PostsService {
	@Resource
	PostsDao postsDao;

	public Posts insertPostsService(Posts posts) {
		System.out.println("insertPostsService : " + posts.getPostsTitle());
		/*request = ServletActionContext.getRequest();
		hs = request.getSession(true);
		posts.setPostsId(null);
		UserInfo user = (UserInfo) hs.getAttribute("user");
		posts.setUserInfo(user);
		Timestamp poststime = new Timestamp(System.currentTimeMillis());
		posts.setPostsTime(poststime);*/
		
		Posts posts1 = postsDao.insertPostsDao(posts);
		return posts1;
	}

	public Posts updatePostsService(Posts posts) {
		
		return null;
	}

	public void deletePostsService(Posts posts) {
		System.out.println("deletePostsService : " + posts.getPostsId() + " "
				+ posts.getPostsTitle());
		postsDao.deletePostsDao(posts);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<Posts> searchPostsService(String whereSql) {
		System.out.println("searchPostsService ");
		/*request = ServletActionContext.getRequest();
		hs = request.getSession(true);
		hs.removeAttribute("postslist");
		hs.setAttribute("postslist", postsDao.searchPostsDao(whereSql));*/
		return postsDao.searchPostsDao(whereSql);
	}

}
