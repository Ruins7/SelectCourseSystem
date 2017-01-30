<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>signin page</title>
		<link rel="stylesheet" type="text/css" href="selectcoursesystem.css">
		<style type="text/css">
<!--
-->
</style>
	</head>
	<body>
		<div id="all">
			<div id="top">
				<div id="logo">
					天津理工大学教务选课系统
				</div>
				<div id="query">
					<s:form action="homePageQuery.action">
						<s:select list="{'同学','教师','课程'}" name="category" label=""></s:select>
						<s:textfield name="querycontent"></s:textfield>
						<br />
						<s:submit value="找找看"></s:submit>
					</s:form>
				</div>
			</div>
			<div id="middle">
				<ul>
					<li>
						<a href="findAllCourses.action" class="a">所有课程</a>
					</li>
					<li>
						<a href="plan.action" class="a">快速选课</a>
					</li>
					<li>
						<a href="findcoursebystu.action" class="a">自定义选课</a>
					</li>
					<li>
						<a href="checkselected.action" class="a">我的已选课程</a>
					</li>
					<li>
						<a href="mycoursetable.action" class="a">我的课表</a>
					</li>
					<li>
						<a href="mypage.action" class="a">我的主页</a>
					</li>
				</ul>
				<div id="login">
					<s:if test="#session.studentID == null">
						<s:form action="login.action" method="post">
    账号：<s:textfield id="17" name="stu.studentID" onblur="checknull(this)"
								size="12" />
							<a href="findDepMaj.action" class="a">注册</a>
							<br />
    密码：<s:password id="18" name="stu.password" onblur="checknull(this)"
								size="12" />
							<s:submit value="登陆" />
							<a href="../student/findpassword.jsp" class="a">忘记密码</a>
							<br />

						</s:form>
					</s:if>
					<s:elseif test="#session.studentID != null">
						<a href="../student/changepassword.jsp" class="a">更改密码</a>
						<a
							href="findDepMajForUp.action?id=<s:property value="#session.studentID"/>"
							class="a">修改个人信息</a>
						<br />
						<a
							href="findreplysuggmess.action?id=<s:property value="#session.studentID"/>"
							class="a">我的校邮</a>
						<a href="logout.action" class="a">退出登录</a>
						<br />
						<h4 id="welcome">
							学号为
							<s:property value="#session.studentID" />
							的同学，欢迎进入学生选课系统！
						</h4>
					</s:elseif>
				</div>
			</div>
			<div id="content">
				<div id="contentlift">
					<font color="red"> <s:property value="noLogin" /> <!-- 您还木有登陆！请您登陆后操作(已拦截) -->
						<s:property value="loginNotFound" /> <!-- 用户名或密码错误 --> 
						<s:property
							value="changeResult" /> <!-- 密码修改成功 --> <s:property
							value="haveBeenSign" /> <!-- 信息修改成功！ --> <s:property
							value="message" /> <!-- 反馈提交成功！ --> <s:property
							value="notInTime" /> <s:property value="addfriendmessage" />
					<s:property value="message" /> 
					  </font>
				    
				    
				
					
					*为必填
					<s:form action="signin.action" method="post">
					 
					
       学号*：<s:textfield id="1" name="stu.studentID"
							onblur="checknull(this)" />
							
						<br />
      密码*：<s:password id="2" name="stu.password" value="请输入密码"
							onfocus="ClearValue(this)" onblur="checknull(this)" />
						<br />
						<!-- 用js判断两次密码是否一致 -->
      密码确认*：<s:password id="3" name="repassword" value="请再次输入密码以确认"
							onblur="compare(this)" onfocus="ClearValue(this)" />
						<br />
      姓名*：<s:textfield id="4" name="stu.studentName"
							onblur="checknull(this)" />
						<br />
      性别*：<s:radio id="5" list="{'男','女'}" name="stu.sex" value="'男'" />
						<br />
						<!-- action中判断男0女1 -->
      学院*：<s:select id="6" name="stu.depID" list="dep" listKey="depID"
							listValue="depName" />
						<br />
						<!-- action动态 -->
      专业*：<s:select id="7" name="stu.majID" list="maj" listKey="majID"
							listValue="majorName" />
						<br>
						<!-- action动态 -->
      入学年份*：<s:select id="8" name="stu.yearEnter"
							list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000','1999','1998','1997'}" />
						<br />
      班级*：<s:select id="9" name="stu.classes"
							list="{'一班','二班','三班','四班','五班','六班'}" />
						<br />
						<!-- action动态 -->
      方向：<s:textfield id="10" name="stu.direction" />
						<br />
  QQ号码*：<s:textfield id="11" name="stu.qq" onblur="checknull(this)" />
						<br />
      手机号*：<s:textfield id="12" name="stu.stuTeleNum"
							onblur="checknull(this)" />
						<br />
      电子邮箱*：<s:textfield id="13" name="stu.stuEmail"
							onblur="checknull(this)" />
						<br />
      身份证号*：<s:textfield id="14" name="stu.idCardNum"
							onblur="checknull(this)" />
						<br />
     生日*： <s:textfield id="15" name="stu.birthday"
							onblur="checknull(this)" />
						<br />
      培养层次*：<s:select id="16" list="{'本科','硕士','博士'}"
							name="stu.eduLevel" />
						<s:submit value="注册"></s:submit>
					</s:form>
					<a href="homepage.action" class="a">取消</a>
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
    <script type="text/javascript">
    

function ClearValue(obj){
	 if(obj.value == obj.defaultValue){
		 obj.value = "";
		 }
}	
function checknull(obj){
        if(obj.value == ""){
        alert("该项不能为空！");
        var text = document.getElementById(obj.id);
        text.focus(); 
        }
}
     </script><!--
     function compare(obj){
          var i = document.forms[0].elements[1].value;
          var j = document.forms[0].elements[2].value;
          if(i!=j||j==""){
          alert("密码输入不一致！且不能为空！");
          i.value="";	
          j.value="";	
          var text = document.getElementById(obj.id);
          text.focus(); 	  
          }		  
}
	--></body>
</html>
