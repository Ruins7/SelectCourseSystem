<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>admin add course page</title>
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
           <font color="red"> <s:property value="errorAdd" /> </font>
		<!-- 添加失败！请重试！ -->
		<s:form action="addteacher.action" method="post">
     教师姓名：<s:textfield name="teacher.teacherName" id="1" />
			<br>
     性别：<s:radio id="2" list="{'男','女'}" name="teacher.sex" value="'男'" />
			<br />
     所属学院：<s:select id="3" list="dep" listKey="depID"
				listValue="depName" name="teacher.depID" />
			<br />  
     职称： <s:select id="4" list="{'助教','讲师','副教授','教授','工程师'}" name="teacher.position" />
			<br />
     手机号：  <s:textfield id="5" name="teacher.teaTeleNum" />
			<br />
     电子邮箱：<s:textfield id="6" name="teacher.teaEmail" />
			<s:submit value="添加教师" />
			<br>
		</s:form>
		<br><hr><br>
		<s:form action="" method="">
		照片：
		<s:file name=""></s:file>
		</s:form>
		<s:form action="adminfindAllTeachers.action" method="post">
			<s:submit value="取消" />
		</s:form>
           
           
           
           
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
