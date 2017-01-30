<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>admin add maj page</title>
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

					<font color="red"> <s:property value="errorAdd" /> </font>
					<!-- 添加失败！请重试！ -->
					<s:form action="addmaj.action" method="post">
     专业名称：<s:textfield name="major.majorName" id="1" />
						<br>
     所属学院： <s:select id="2" list="dep" listKey="depID"
							listValue="depName" name="major.depID" />
						<br />
						<s:submit value="添加专业" />
						<br>
					</s:form>
					<s:form action="adminfindAllMajs.action" method="post">
						<s:submit value="取消" />
					</s:form>



				</div>
				<div id="contentright">
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					&nbsp;&nbsp;&nbsp;
					<a href="adminlogout.action" class="b">退出登录</a>&nbsp;&nbsp;
					<a href="../admin/adminhomepage.jsp" class="b">回到首页</a>
				</div>
			</div>

			<hr />
			<div id="bottom">
				© 2013－2014 Ruins7.com, all rights reserved. ALL by Ruins7.
			</div>

		</div>





	</body>
</html>
