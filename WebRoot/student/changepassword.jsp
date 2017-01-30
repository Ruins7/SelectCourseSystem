<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>   
    <title>change password page</title>
		
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
						<s:property value="haveBeenSign" /> <!-- 信息修改成功！ --> 
						<s:property value="message" /> <!-- 反馈提交成功！ --> 
						<s:property value="notInTime" />
				        <s:property value="addfriendmessage" />
				</font>
				 <font color="red"> <s:property value="changeResult" /> </font><!-- 输入的原密码有误，修改失败 -->
				 <s:fielderror fieldName="oldnull"></s:fielderror>
				 <s:fielderror fieldName="newnull"></s:fielderror>
				 <s:fielderror fieldName="final"></s:fielderror>
     <s:form action="changePassword.action" method="post">
        旧密码：<s:password name="oldpassword" id="1" onblur="checknull(this)"/><br/>
        新密码：<s:password name="newpassword" id="2" onblur="checknull(this)"/><br/>
        新密码确认：<s:password name="renewpassword" id="3" onblur="compare(this)"/><br/>
        <s:submit value="确认修改"></s:submit>
     </s:form>
     <a href="homepage.action" class="a">取消</a><br/>	
     </div>
      <div id="contentright">
         <a href="checkstulogin.action" class="a">意见反馈</a>
      </div>
  </div>
  <hr />
  <div id="bottom">
    © 2013－2014 Ruins7.com, all rights reserved. ALL by Ruins7.
  </div>
</div> 
 
     <script type="text/javascript">

function checknull(obj){
        if(obj.value == ""){
        alert("该项不能为空！");
        var text = document.getElementById(obj.id);
        text.focus(); 
        }
}
      </script><!--
      function compare(obj){
          var i = document.forms[2].elements[1].value;
          var j = document.forms[2].elements[2].value;
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
