<%@ page language="java"
	import="java.util.*,com.bbs.domain.*,com.bbs.Postsaction.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYpE HTML pUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSp 'publish.jsp' starting page</title>
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
	<!--posts_id int identity (1,1) primary key,
		posts_title varchar(100) Not Null,
		posts_content varchar(300) Not Null,
		posts_adminid int Not N ull,
		posts_time datetime -->
	<s:form action="postsPublish" namespace="/">
		<s:textfield name="posts.postsTitle" label="标题"
			cssStyle="font-size:12px;width: 120px;" />
		<%-- <s:textfield name="posts_adminid" label="发布者"
			cssStyle="font-size:12px;width: 120px;" />
		<s:textfield name="posts_time" label="发布时间" 
			cssStyle="font-size:12px;width: 120px;" />--%>
		<s:textarea name="posts.postsContent" label="内容" maxlength="150"
			wrap="true" cssStyle="font-size:12px; width:900px; height:100px;" />

		<s:submit value=" 发表" />
	</s:form>
</body>
</html>
