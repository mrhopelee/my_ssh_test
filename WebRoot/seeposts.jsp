<%@ page language="java"
	import="java.util.*,com.bbs.domain.*,com.bbs.Replyaction.*,com.bbs.Postsaction.*,com.bbs.UserInfoaction.*,com.hsf.*"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'seeposts.jsp' starting page</title>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>

	<a href="index.jsp">主页</a>

	<s:if test="#session.user!=null">
		
		欢迎用户：<s:property value="#session.user.userName" />
		<a href="userinfo.jsp">个人信息</a>
		<s:form action="userinfoQuit" namespace="/">
			<s:submit value="退出 " />
		</s:form>
	</s:if>
	<s:else>
		<a href="register.jsp">注册</a>
		<a href="login.jsp">登陆</a>
		<br />
	</s:else>
	<s:iterator value="#session.postslist">
		<p>
			<%-- <s:if test="#session.user.userId!=null">
			<s:a href="seepostinfo?postsid=%{postsId}">
			
					<s:property value="postsTitle" />
				</s:a> </s:if>--%>
			标题:
			<s:property value="postsTitle" />
			<s:if test="#session.user.userType==1">
				<%-- <s:a href="deleteposts?postsid=%{postsId}">
						删除该帖
					</s:a> --%>
				<s:form action="postsDelete" namespace="/">
					<s:hidden name="posts.postsId" value="%{postsId}"></s:hidden>
					<s:submit value="删除该帖"></s:submit>
				</s:form>
			</s:if>
			<s:elseif test="#session.user.userId==userInfo.userId">
				<%-- <s:a href="deleteposts?postsid=%{postsId}">
						删除该帖
					</s:a> --%>
				<s:form action="postsDelete" namespace="/">
					<s:hidden name="posts.postsId" value="%{postsId}"></s:hidden>
					<s:submit value="删除该帖"></s:submit>
				</s:form>
			</s:elseif>
			<br />楼主:
			<s:property value="userInfo.userName" />
			<br />时间:
			<s:property value="postsTime" />
			<br />内容:
			<s:property value="postsContent" />
		</p>
		<hr />
	</s:iterator>
	<s:iterator value="#session.replylist" id="a" status="st">
		<p>
			<s:property value="(#st.count)+1" />
			楼
			<s:if test="#session.user.userType==1">
				<%-- <s:a
					href="deletereply?replyid=%{replyId}&postsid=%{#session.postsinfo.postsId}">
						删除评论
					</s:a> --%>
				<s:form action="replyDelete" namespace="/">
					<s:hidden name="posts.postsId" value="%{postsId}"></s:hidden>
					<s:hidden name="reply.replyId" value="%{replyId}"></s:hidden>
					<s:submit value="删除评论"></s:submit>
				</s:form>
			</s:if>
			<s:elseif test="#session.user.userId==#a.userInfo.userId">
				<%-- <s:a
					href="deletereply?replyid=%{replyId}&postsid=%{#session.postsinfo.postsId}">
						删除评论
					</s:a> --%>
				<s:form action="replyDelete" namespace="/">
					<s:hidden name="reply.posts.postsId" value="%{posts.postsId}"></s:hidden>
					<s:hidden name="reply.replyId" value="%{replyId}"></s:hidden>
					<s:submit value="删除评论"></s:submit>
				</s:form>
			</s:elseif>
			<br />用户:
			<s:property value="#a.userInfo.userName" />
			<br />时间:
			<s:property value="#a.replyTime" />
			<br />内容:
			<s:property value="#a.replyContent" />
		</p>
		<hr />
	</s:iterator>

	<s:form action="replyPublish" namespace="/">
		<s:a href="getUserInfo?user=%{#session.user}">
			<s:property value="#session.user.userName" />
		</s:a>

		<s:textarea name="reply.replyContent" label="评论内容" maxlength="150"
			wrap="true" cssStyle="font-size:12px; width:900px; height:100px;" />

		<s:submit value=" 评论" />
	</s:form>
</body>
</html>
