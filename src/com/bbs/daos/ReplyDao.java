package com.bbs.daos;

import java.util.List;

import com.bbs.domain.Reply;

public interface ReplyDao {
	public Reply insertReplyDao(Reply reply);

	public Reply updateReplyDao(Reply reply, Integer integer);

	public void deleteReplyDao(Reply reply);

	public List<Reply> searchReplyDao(String whereSql);
}
