<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>admin find all suggestion page</title>
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
					<font color="red"> <s:property value="errorAdd" /> <!-- 是否有反馈   删除结果-->
						<s:property value="message" /> </font>
					<!-- 回复反馈是否成功-->
					<table class="b" width="765">

						<tr>
							<td>
								反馈题目
							</td>
							<td>
								反馈时间
							</td>
							<td>
								反馈学生学号
							</td>
							<td>
								学生姓名
							</td>
							<td>
								操作
							</td>
						</tr>
						<s:iterator value="sugg">
							<tr>
								<td>
									<a
										href="searchsugg.action?id=<s:property value="suggestionID" />" class="b"><s:property
											value="title" />
									</a>
								</td>
								<td>
									<s:property value="timeOfSugg" />
								</td>
								<td>
									<s:property value="studentID" />
								</td>
								<td>
									<s:property value="studentName" />
								</td>
								<td>
									<s:form action="deletesugg.action" method="post">
										<s:submit value="删除"></s:submit>
										<input type="hidden" name="suggid"
											value="<s:property value="suggestionID" />" />
									</s:form>
								</td>
							</tr>
						</s:iterator>
					</table>

					<hr />


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
