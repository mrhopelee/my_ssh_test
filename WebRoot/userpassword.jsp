<%@ page language="java"
	import="java.util.*,com.bbs.domain.*,com.bbs.Postsaction.*,com.bbs.UserInfoaction.*,com.hsf.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'userpassword.jsp' starting page</title>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>

	<s:form action="updateuserpassword" namespace="/">
		<%-- <s:textfield name="userpassword1" label="密码"
			cssStyle="font-size:12px;width: 120px;"
			value="%{#session.user.getUserPassword()}" /> --%>
		<s:param name="user" value="#session.user"></s:param>
		<s:password name="up" label="旧密码"
			cssStyle="font-size:12px;width: 120px;" />
		<s:password name="newup" label="新密码"
			cssStyle="font-size:12px;width: 120px;" />
		<s:password name="newup2" label="确认新密码"
			cssStyle="font-size:12px;width: 120px;" />
		<s:submit value="修改密码" />
	</s:form>
</body>
</html>
