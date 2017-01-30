<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>admin login page</title>
		<link rel="stylesheet" type="text/css" href="admincss.css">
		<style type="text/css">
<!--
-->
</style>
	</head>

	<body>


		<div id="all">
			<div id="top">
				天津理工大学教务选课系统后台控制系统
			</div>

			<div id="content">
				<div id="contentlift">
					<div id="center">
						<font color="red"> <s:property value="loginNotFound" /> <!-- 管理员账号或密码错误！ -->
							<s:property value="noLogin" /> <!-- 您还木有登陆！请您登陆！ --> <s:property
								value="notFindPs" /> </font>
						<!-- 密码已发送至该登陆账号的注册邮箱中，请查看后登陆。 -->
						<s:form action="adminLogin.action" method="post"> 
    管理员账号：<s:textfield name="admin.adminID" id="1" /><br/>
    管理员密码：<s:password name="admin.password" id="2" />
							<br/><s:submit value="登陆" />
						</s:form>
						<a href="../admin/findadminpassword.jsp" class="b">忘记密码</a>
						
					</div>
				</div>
				<div id="contentright">

				</div>
			</div>

			<hr />
			<div id="bottom">
				© 2013－2014 Ruins7.com, all rights reserved. ALL by Ruins7.
			</div>


		</div>


	</body>
</html>
