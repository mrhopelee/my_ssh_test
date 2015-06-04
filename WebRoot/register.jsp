<%@ page language="java"
	import="java.util.*,com.bbs.actions.UserInfoAction"
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


	<div>
		<div>用户注册</div>
		<div>
			<s:form action="userinfoRegister" namespace="/">

				<s:textfield name="userinfo.userName" label="用户名" />
				<s:fielderror fieldName="username"></s:fielderror>
				<s:password name="userinfo.userPassword" label="密码" />
				<s:fielderror fieldName="password"></s:fielderror>
				<s:password name="repassword" label="确认密码" />

				<s:radio list="#{'男':'男','女':'女'}" value="#{'男'} }"
					name="userinfo.sex" label="性别"
					cssStyle="font-size:12px;width: 30px;" />
				<s:fielderror fieldName="sex"></s:fielderror>
				<sx:datetimepicker name="userinfo.birthday" label="出生日期"
					displayFormat="yyyy-M-dd" value="%{'today'}" />

				<s:textfield name="userinfo.telephone" maxlength="15" label="联系电话" />

				<s:textfield name="userinfo.email" label="电子邮箱" />

				<s:textfield name="userinfo.address" label="地址" />

				<s:textarea name="userinfo.remark" label="个人描述" maxlength="50"
					cols="20" rows="5" wrap="true" />

				<s:submit value=" 注册 " />
			</s:form>
			<a href="index.jsp">主页</a> <a href="login.jsp">登陆</a>
		</div>
	</div>
</body>
</html>
