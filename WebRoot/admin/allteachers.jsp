<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
    <head>
		<title>admin find all teacher </title>
		<link rel="stylesheet" type="text/css" href="admincss.css">
		<style type="text/css">
<!--
-->
</style>
	</head>
	<body>
	
	 <div id="all">
       <div id="top">天津理工大学教务选课系统后台控制系统
       </div>
       
        <div id="content">
            <div id="contentlift">
               
           		<font color="red"> <s:property value="homePageNotFound" /> 
		<!-- 是否添加添加成功 // 是否修改成功 // 是否删除成功-->
		<s:property value="errorAdd" /> </font>
		<!-- 是否添加添加成功 // 是否修改成功 // 是否删除成功-->
		<table class="b" width="765">
			<tr>
				<td>
					教师ID
				</td>
				<td>
					姓名
				</td>
				<td>
					性别
				</td>
				<td>
					学院
				</td>
				<td>
					职称
				</td>
				<td>
					手机号
				</td>
				<td>
					电子邮箱
				</td>
				<td>
					照片
				</td>
				<td>
					操作
				</td>
			</tr>

			<s:iterator value="teacher">
				<tr>
					<td>
						<s:property value="teacherID" />
					</td>
					<td>
						<s:property value="teacherName" />
					</td>
					<td>
						<s:property value="sex" />
					</td>
					<td>
						<s:property value="department" />
					</td>
					<td>
						<s:property value="position" />
					</td>
					<td>
						<s:property value="teaTeleNum" />
					</td>
					<td>
						<s:property value="teaEmail" />
					</td>
					<td>
						<img src="" width="60" height="60">
					</td>
					<td>
						<s:form action="sendteacherid.action" method="post">
							<s:submit value="修改" />
							<input type="hidden" name="teacherid"
								value="<s:property value= "teacherID" /> " />
						</s:form>
					</td>
					<td>
						<s:form action="deleteteacher.action" method="post">
							<s:submit value="删除" />
							<input type="hidden" name="teacherid"
								value="<s:property value= "teacherID" /> " />
						</s:form>
					</td>
				</tr>
			</s:iterator>
		</table>
		<hr/>
		<a href="findDepForAdmin.action" class="b">增加教师信息</a>
           
           
           
           </div>
            <div id="contentright">
            <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
         &nbsp;&nbsp;&nbsp;<a href="adminlogout.action" class="b">退出登录</a>&nbsp;&nbsp;<a href="../admin/adminhomepage.jsp" class="b">回到首页</a>
            </div> 
       </div>
   
   <hr />
    <div id="bottom">
     © 2013－2014 Ruins7.com, all rights reserved. ALL by Ruins7.
       </div>
   
   
   </div>


	</body>
</html>
