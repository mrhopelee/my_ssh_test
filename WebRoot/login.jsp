<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!--导入Struts 2 标签库-->
<style type="text/css">
* {
	font-size: 12px;
}
</style>
<html>
<body>
	<div style=" margin:30px 50px 20px 50px; text-align:center">
		<div style="font-size:14px; font-weight:bold">用户登录</div>
		<div>
			<s:form action="userinfoLogin" namespace="/">
			<s:fielderror fieldName="login"></s:fielderror>
				<s:textfield name="userinfo.userName" cssStyle="font-size:12px;width: 120px;"
					label="登录名称" />
				<s:password name="userinfo.userPassword"
					cssStyle="font-size:12px;width:120px;" label="登录密码" />
				<s:submit value=" 登录 " />
			</s:form>
			<a href="register.jsp">注册</a>
		</div>
	</div>
</body>
</html>
