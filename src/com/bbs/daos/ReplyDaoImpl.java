package com.bbs.daos;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.bbs.domain.Reply;

public class ReplyDaoImpl implements ReplyDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public Reply insertReplyDao(Reply reply) {
		sessionFactory.getCurrentSession().persist(reply);
		return reply;
	}

	
	public Reply updateReplyDao(Reply reply, Integer integer) {
		
		return null;
	}

	
	public void deleteReplyDao(Reply reply) {
		sessionFactory.getCurrentSession().delete(reply);

	}

	
	@SuppressWarnings("unchecked")
	public List<Reply> searchReplyDao(String whereSql) {
		
		return  (List<Reply>)sessionFactory.getCurrentSession().createQuery(whereSql).list();
	}

}
