<%@ page language="java"
	import="java.util.*,com.bbs.domain.*,com.bbs.Postsaction.*,com.bbs.UserInfoaction.*,com.hsf.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>

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
		<a href="publish.jsp">发帖</a>
		<hr />
		
		<s:action name="postsSetSession" flush="false" namespace="/">
		</s:action>

		<s:iterator value="#session.postslist">
			<p>
				<%-- <s:url id="idUrl" action="seepostinfo">
						<s:param name="postsid" value="postsId"></s:param>
					</s:url>
					<s:a href="%{idUrl}">
						<s:property value="postsTitle" />
					</s:a> --%>


				<%-- 标题:
				<s:a href="seepostinfo?postsid=%{postsId}">
					<s:property value="postsTitle" />
				</s:a> --%>
				<s:form action="postsSee" namespace="/">
					<s:hidden name="posts.postsId" value="%{postsId}"></s:hidden>
					标题:<s:submit cssStyle="display:inline;" value="%{postsTitle}"></s:submit>
				</s:form>

				<br />ID:
				<s:property value="postsId" />
				楼主:
				<s:property value="userInfo.userName" />
				时间:
				<s:property value="postsTime" />
				<%-- <br />内容:
				<s:property value="postsContent" /> --%>
				<s:if test="#session.user.userType==1">
					<%-- <s:a href="postsDelete?posts.postsId=%{postsId}">
						删除该帖
					</s:a> --%>
					<s:form action="postsDelete" namespace="/">
						<s:hidden name="posts.postsId" value="%{postsId}"></s:hidden>
						<s:submit value="删除该帖"></s:submit>
					</s:form>
				</s:if>
				<s:elseif test="#session.user.userId==userInfo.userId">
					<%-- <s:a href="postsDelete?posts.postsId=%{postsId}">
						删除该帖
					</s:a> --%>
					<s:form action="postsDelete" namespace="/">
						<s:hidden name="posts.postsId" value="%{postsId}"></s:hidden>
						<s:submit value="删除该帖"></s:submit>
					</s:form>
				</s:elseif>
			</p>
			<hr />
		</s:iterator>

	</s:if>
	<s:else>
		<a href="register.jsp">注册</a>
		<a href="login.jsp">登陆</a>
		<br />
	</s:else>
</body>
</html>
