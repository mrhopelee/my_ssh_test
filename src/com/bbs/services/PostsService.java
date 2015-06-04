package com.bbs.services;

import java.util.List;

import com.bbs.domain.Posts;

public interface PostsService {
	public Posts insertPostsService(Posts posts);

	public Posts updatePostsService(Posts posts);

	public void deletePostsService(Posts posts);

	public List<Posts> searchPostsService(String whereSql);
	
}
