package com.bbs.services;

import java.util.List;

import com.bbs.domain.Reply;

public interface ReplyService {
	public Reply insertReplyService(Reply reply);

	public Reply updateReplyService(Reply reply);

	public void deleteReplyService(Reply reply);

	public List<Reply> searchReplyService(String whereSql);
}
