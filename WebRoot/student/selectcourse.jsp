<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
		<title>select courses</title>
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
						
						<s:property value="notInTime" />
				        <s:property value="addfriendmessage" />
				</font>
				<br />
               
               <s:if test="#application.level == null ">
		       <h3 class="a">当前不是选课时间!无法行进选课！</h3> 
		</s:if>
		<s:elseif test="#application.level != null">
	 当前已设置的选课阶段为：<s:property value="#application.level"/><br/><br/>
           当前已设置的选课开始时间为：<s:property value="#application.by"/>年<s:property value="#application.bm"/>月<s:property value="#application.bd"/>日 <s:property value="#application.bh"/>时<s:property value="#application.bmin"/>分<s:property value="#application.bs"/>秒<br/><br/>
           当前已设置的选课结束时间为：<s:property value="#application.ey"/>年<s:property value="#application.em"/>月<s:property value="#application.ed"/>日 <s:property value="#application.eh"/>时<s:property value="#application.emin"/>分<s:property value="#application.es"/>秒<br/><br/>
        <br/><br/>
        <hr/><br/>
        </s:elseif>

<s:if test="message != null">
     <font color="red">
  			<s:property value="message"/><!-- 信息修改成功！ -->
  		</font>
  </s:if>		
<s:elseif test="message == null">
 <font color="red">
            <s:property value="messagesele"/><!-- 信息修改成功！ -->
            <s:property value="messagetime"/><!-- 信息修改成功！ -->
            <s:property value="messagesuccess"/><!-- 信息修改成功！ -->
  			<s:property value="notInTime"/><!-- 非选课时间段！ -->
  			<s:property value="messagemax"/><!-- 非选课时间段！ -->
  			<s:property value="messagethird"/><!-- 第三阶段只能退课不能选课！ -->
  		</font>
<h3 class="a">以下是根据您的专业，年级和培养层次为您推荐的课程：</h3>
      <table class="a" width="750">
			<tr>
				<td>
					<h3>课程ID</h3>
				</td>
				<td>
					<h3>课程名称</h3>
				</td>
				<td>
					<h3>学分</h3>
				</td>
				<td>
					<h3>类别</h3>
				</td>
				<td>
					<h3>性质</h3>
				</td>
				<td>
					<h3>开设学院</h3>
				</td>
				<td>
					<h3>上课时间</h3>
				</td>
				<td>
					<h3>上课周期</h3>
				</td>
				<td>
					<h3>上课地点</h3>
				</td>
				<td>
					<h3>任课教师</h3>
				</td>
				<td>
					<h3>教师Email</h3>
				</td>
				<td>
					<h3>所属培养计划</h3>
				</td>
				<td>
					<h3>当前已选人数/课程最大容量</h3>
				</td>
				<td>
					<h3></h3>
				</td>
				
			</tr>

			<s:iterator value="course">
				<tr>
					<td>
						<s:property value="courseID" />
					</td>
					<td>
						<s:property value="courseName" />
					</td>
					<td>
						<s:property value="credit" />
					</td>
					<td>
						<s:property value="classification" />
					</td>
					<td>
						<s:property value="property" />
					</td>
					<td>
						<s:property value="offerDepart" />
					</td>
					<td>
					    <s:property value="timeForCourse"/>
					</td>
					<td>
					    <s:property value="weekday"/>
					</td>
					<td>
						<s:property value="location" />
					</td>
					<td>
						<s:property value="teacherName" />
					</td>
					<td>
						<s:property value="teaEmail" />
					</td>		
					<td>
						<s:property value="planName" />
					</td>
					<td>
						<s:if test="currentNum == null">0</s:if>
						<s:elseif test="currentNum != null"><s:property value="currentNum"/></s:elseif>
						/<s:property value="max" />
					</td>
					<td>
						<s:form action="addcourseid.action" method="post">
							<s:submit value="选课" />
							<input type="hidden" name="courseid"
								value="<s:property value= "courseID" /> " />
							<input type="hidden" name="time"
								value="<s:property value= "timeForCourse" /> " />
							<input type="hidden" name="level"
								value="<s:property value="#application.level"/> " />
							<input type="hidden" name="currentnum"
								value="<s:property value="currentNum"/> " />
							<input type="hidden" name="max"
								value="<s:property value="max"/> " />
						</s:form>
					</td>
					<td>
						<s:form action="deletecourseid.action" method="post">	
							<input type="hidden" name="courseid"
								value="<s:property value= "courseID" /> " />
								<s:submit value="退课" />
						</s:form>
					</td>
				</tr>
			</s:iterator>
		</table>
</s:elseif>
               
               
               
               
               
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
