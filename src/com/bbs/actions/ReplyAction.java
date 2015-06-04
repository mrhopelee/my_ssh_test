package com.bbs.actions;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bbs.domain.Posts;
import com.bbs.domain.Reply;
import com.bbs.domain.UserInfo;
import com.bbs.services.ReplyService;
import com.opensymphony.xwork2.ActionSupport;

public class ReplyAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest request = null;
	HttpSession hs = null;
	UserInfo userinfo;
	Posts posts;
	private Reply reply;
	@Resource
	private ReplyService replyService;
	
	@SuppressWarnings("unchecked")
	public String publish() {
		request = ServletActionContext.getRequest();
		hs = request.getSession(true);
		userinfo = (UserInfo) (hs.getAttribute("user"));
		System.out.println(userinfo.toString());
		List<Posts> postslist = (List<Posts>) (hs.getAttribute("postslist"));
		posts = postslist.get(0);
		System.out.println(posts.toString());
		Timestamp replytime = new Timestamp(System.currentTimeMillis());
		
		reply.setReplyId(null);
		reply.setPosts(posts);
		reply.setUserInfo(userinfo);
		reply.setReplyTime(replytime);

		replyService.insertReplyService(reply);
		setsession(posts.getPostsId());
		return "success";
	}

	public String setsession(Integer postsid) {
		String whereSql = "from Reply where posts.postsId=" + "'" + postsid
				+ "'" + "order by replyTime asc";
		List<Reply> replylist = replyService.searchReplyService(whereSql);
		request = ServletActionContext.getRequest();
		hs = request.getSession(true);
		hs.removeAttribute("replylist");
		hs.setAttribute("replylist", replylist);
		return "success";
	}

	public String delete() {

		System.out.println(reply.getReplyId());
		System.out.println(reply.getPosts().getPostsId());
		replyService.deleteReplyService(reply);
		setsession(posts.getPostsId());
		/*if (posts1 != null) {*/
		return "success";
		/*} else {
			return "input";
		}*/
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	public ReplyService getReplyService() {
		return replyService;
	}

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

}
