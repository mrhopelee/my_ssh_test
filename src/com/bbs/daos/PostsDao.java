package com.bbs.daos;

import java.util.List;

import com.bbs.domain.Posts;

public interface PostsDao {
	public Posts insertPostsDao(Posts posts);

	public Posts updatePostsDao(Posts posts, Integer integer);

	public void deletePostsDao(Posts posts);

	public List<Posts> searchPostsDao(String whereSql);
}
