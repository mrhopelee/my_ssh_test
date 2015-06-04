package com.bbs.daos;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.bbs.domain.Posts;

public class PostsDaoImpl implements PostsDao {
	@Resource
	private SessionFactory sessionFactory;

	public Posts insertPostsDao(Posts posts) {
		System.out.println("insertPostsDao ");
		sessionFactory.getCurrentSession().clear();
		sessionFactory.getCurrentSession().persist(posts);
		return posts;
	}

	public Posts updatePostsDao(Posts posts, Integer integer) {

		return null;
	}

	public void deletePostsDao(Posts posts) {
		System.out.println("deletePostsDao ");
		sessionFactory.getCurrentSession().clear();
		posts= (Posts) sessionFactory.getCurrentSession().load(Posts.class, (Integer)posts.getPostsId());
		//System.out.println(posts1.toString());
		sessionFactory.getCurrentSession().delete(posts);
		
	}

	@SuppressWarnings("unchecked")
	public List<Posts> searchPostsDao(String whereSql) {
		System.out.println("searchPostsDao ");
		Query query = sessionFactory.getCurrentSession().createQuery(whereSql);
		List<Posts> postlist = (List<Posts>) query.list();
		return postlist;
	}

}
