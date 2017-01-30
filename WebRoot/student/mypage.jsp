<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
		<title>my page</title>
				<link rel="stylesheet" type="text/css" href="selectcoursesystem.css">
		<style type="text/css">
<!--
-->
</style>
	</head>
	<body>
	
			<div id="all">
    <div id="top">
      <div id="logo">天津理工大学教务选课系统</div>
      <div id="query">
            <s:form action="homePageQuery.action">
						<s:select list="{'同学','教师','课程'}" name="category" label=""></s:select>
						<s:textfield name="querycontent"></s:textfield><br />
						<s:submit value="找找看"></s:submit>
					</s:form>
      </div>
    </div>
    <div id="middle">
      <ul>
         <li><a href="findAllCourses.action" class="a">所有课程</a></li>
         <li><a href="plan.action" class="a">快速选课</a></li>
         <li><a href="findcoursebystu.action" class="a">自定义选课</a></li>
         <li><a href="checkselected.action" class="a">我的已选课程</a></li>
         <li><a href="mycoursetable.action" class="a">我的课表</a></li>
         <li><a href="mypage.action" class="a">我的主页</a></li>
     </ul> 
     <div id="login">
       <s:if test="#session.studentID == null">
					<s:form action="login.action" method="post">
    账号：<s:textfield id="1" name="stu.studentID" onblur="checknull(this)" size="12" /><a href="findDepMaj.action" class="a">注册</a><br />
    密码：<s:password id="2" name="stu.password" onblur="checknull(this)" size="12"/><s:submit value="登陆" /><a href="../student/findpassword.jsp" class="a">忘记密码</a><br />
						
					</s:form>						
				</s:if>
                <s:elseif test="#session.studentID != null">	
								<a href="../student/changepassword.jsp" class="a">更改密码</a>
								<a href="findDepMajForUp.action?id=<s:property value="#session.studentID"/>" class="a">修改个人信息</a><br />
								<a href="findreplysuggmess.action?id=<s:property value="#session.studentID"/>" class="a">我的校邮</a>
								<a href="logout.action" class="a">退出登录</a><br />
								<h4 id="welcome">
					学号为<s:property value="#session.studentID" />的同学，欢迎进入学生选课系统！</h4>
				</s:elseif>
     </div>
    </div>
  <div id="content">
     <div id="contentlift">
         <font color="red"> 
				        <s:property value="noLogin" /> <!-- 您还木有登陆！请您登陆后操作(已拦截) -->
					    <s:property value="loginNotFound" /> <!-- 用户名或密码错误 --> 
					    <s:property value="changeResult" /> <!-- 密码修改成功 --> 
						<s:property value="haveBeenSign" /> <!-- 信息修改成功！ --> 
						<s:property value="message" /> <!-- 反馈提交成功！ --> 
						<s:property value="notInTime" />
				        <s:property value="addfriendmessage" />
				</font>
				<br />
                <s:property value="deletemessage"/>
		
		<s:property value="addsuccess"/>
		<div id="person">
                <h2>个人信息：</h2>
		
		<img src="${session.photo}" width="50" height="50">

		<h3>学号：</h3>
		<s:property value="#session.studentID" />
		
		<h3>姓名：</h3>
		<s:property value="#session.studentName" />
	
		<h3>学院：</h3>
		<s:property value="#session.department" />
		
		<h3>专业：</h3>
		<s:property value="#session.major" />
	
		<h3>年级：</h3>
		<s:property value="#session.yearEnter" />
	
		<h3>班级：</h3>
		<s:property value="#session.classes" />
		
		<h3>培养层次：</h3>
		<s:property value="#session.eduLevel" />
		
		
		</div>
		<div id="plan">
		<br>
		<br>
		 <a href="checkreuqest.action" class="a"><s:property value="requestmessage" /></a>
		 <br><br><br>
		 <hr/>
		<br>
        <h2 class="a">我的好友</h2><br/>
        <s:if test="fmessage == null">
           <s:iterator value="friends">
           <a href="gotofriendpage.action?id=<s:property value="friendID"/>" class="a"><s:property value="friendName"/></a>
        </s:iterator>
        </s:if>
        <s:elseif test="fmessage != null">
            <s:property value="fmessage"/>
        </s:elseif>
        <br><br><br>
        <hr>
        <br>
        <h2 class="a">留言板</h2><br/>
        
        <s:if test="messmessage != null">
            <s:property value="messmessage"/> 
        </s:if>
        <s:elseif test="messmessage == null">
        <s:iterator value="allmessage">
        
        <s:property value="fromStudentName"/>&nbsp;&nbsp;&nbsp;&nbsp;在
        <s:property value="timeOfLeaMes"/>&nbsp;&nbsp;&nbsp;对您说：&nbsp;&nbsp;&nbsp;
        <s:property value="content"/>&nbsp;&nbsp;&nbsp;
        <a href="replymess.action?id=<s:property value="fromStudentID"/>" class="a">回复</a>
        <a href="deletemess.action?id=<s:property value="messageID"/>" class="a">删除</a>
        <br/><br/>
        </s:iterator>
        </s:elseif>
        </div>
     </div>
      <div id="contentright">
         <a href="checkstulogin.action" class="a">意见反馈</a>
         <a href="homepage.action" class="a">回到首页</a>
      </div>
  </div>
  <hr />
  <div id="bottom">
    © 2013－2014 Ruins7.com, all rights reserved. ALL by Ruins7.
  </div>
</div>
	</body>
</html>
