<%@ page language="java"
	import="java.util.*,com.bbs.domain.*,com.bbs.Postsaction.*,com.bbs.UserInfoaction.*,com.hsf.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!--导入Struts 2 标签库-->
<style type="text/css">
* {
	font-size: 12px;
}
</style>
<html>
<head>
<sx:head extraLocales="UTF-8" />
</head>
<body>
	<%-- <s:action name="getUserInfo" flush="true" namespace="/"
		executeResult="true">
		<s:param name="user" value="#session.user"></s:param>
	</s:action> --%>

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
	<div style=" margin:30px 50px 20px 50px; text-align:center">
		<div style="font-size:14px; font-weight:bold">用户信息</div>

		<s:form action="userinfoUpdate" namespace="/"
			cssStyle="margin:30 auto">

			<s:textfield name="userinfo.userName" label="用户名" readonly="true"
				cssStyle="font-size:12px;width: 120px;"
				value="%{#session.user.userName}" />

			<s:a href="userpassword.jsp">
			修改密码
			<s:param name="user" value="#session.user"></s:param>
			</s:a>

			<s:radio list="#{'男':'男','女':'女'}" name="userinfo.sex" label="性别"
				cssStyle="font-size:12px;width: 30px;" value="%{#session.user.sex}" />

			<sx:datetimepicker name="userinfo.birthday" label="出生日期"
				displayFormat="yyyy-M-dd" value="%{#session.user.birthday}" />

			<s:textfield name="userinfo.telephone" label="联系电话" maxlength="15"
				cssStyle="font-size:12px;width: 120px;"
				value="%{#session.user.telephone}" />

			<s:textfield name="userinfo.email" label="电子邮箱"
				cssStyle="font-size:12px;width: 120px;"
				value="%{#session.user.email}" />

			<s:textfield name="userinfo.address" label="地址"
				cssStyle="font-size:12px;width: 120px;"
				value="%{#session.user.address}" />

			<s:textarea name="userinfo.remark" label="个人描述" maxlength="50"
				cols="20" rows="5" cssStyle="font-size:12px;" wrap="true"
				value="%{#session.user.remark}" />

			<s:submit value=" 修改 " />
		</s:form>
	</div>
</body>
</html>
