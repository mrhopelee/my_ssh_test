package com.bbs.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.daos.ReplyDao;
import com.bbs.domain.Reply;

@Transactional
public class ReplyServiceImpl implements ReplyService {
	@Resource
	ReplyDao replyDao;
	
	public Reply insertReplyService(Reply reply) {
		
		return replyDao.insertReplyDao(reply);
	}

	
	public Reply updateReplyService(Reply reply) {
		
		return null;
	}

	
	public void deleteReplyService(Reply reply) {
		replyDao.deleteReplyDao(reply);

	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<Reply> searchReplyService(String whereSql) {
		
		return replyDao.searchReplyDao(whereSql);
	}

}
