<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>my course table</title>
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
                
  				<div id="person">
                <h2>个人信息：</h2>
                
        <img src="${session.photo}" width="60" height="60" style="background-color: #FFF">
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
	
	
	
	
	
	
					<br />
					<s:if test="checkmessage != null ">
						<font color="red"><s:property value="checkmessage" /> </font>
					</s:if>
					<s:elseif test="checkmessage == null">
               
						<h2 class="a">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我的课表
						</h2>
						<br />
												
	 <s:iterator value="conse">
           <s:if test="timeForCourse == '08:20 ~ 09:45' && weekday == '星期一'"><s:set name="aa" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '08:20 ~ 09:45' && weekday == '星期二'"><s:set name="ba" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '08:20 ~ 09:45' && weekday == '星期三'"><s:set name="ca" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '08:20 ~ 09:45' && weekday == '星期四'"><s:set name="da" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '08:20 ~ 09:45' && weekday == '星期五'"><s:set name="ea" value="courseName"></s:set></s:if>
          
           <s:if test="timeForCourse == '10:20 ~ 11:45' && weekday == '星期一'"><s:set name="ab" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '10:20 ~ 11:45' && weekday == '星期二'"><s:set name="bb" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '10:20 ~ 11:45' && weekday == '星期三'"><s:set name="cb" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '10:20 ~ 11:45' && weekday == '星期四'"><s:set name="db" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '10:20 ~ 11:45' && weekday == '星期五'"><s:set name="eb" value="courseName"></s:set></s:if>
           
           <s:if test="timeForCourse == '12:00 ~ 13:45' && weekday == '星期一'"><s:set name="ac" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '12:00 ~ 13:45' && weekday == '星期二'"><s:set name="bc" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '12:00 ~ 13:45' && weekday == '星期三'"><s:set name="cc" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '12:00 ~ 13:45' && weekday == '星期四'"><s:set name="dc" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '12:00 ~ 13:45' && weekday == '星期五'"><s:set name="ec" value="courseName"></s:set></s:if>
           
           <s:if test="timeForCourse == '14:00 ~ 15:45' && weekday == '星期一'"><s:set name="ad" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '14:00 ~ 15:45' && weekday == '星期二'"><s:set name="bd" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '14:00 ~ 15:45' && weekday == '星期三'"><s:set name="cd" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '14:00 ~ 15:45' && weekday == '星期四'"><s:set name="dd" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '14:00 ~ 15:45' && weekday == '星期五'"><s:set name="ed" value="courseName"></s:set></s:if>
           
           <s:if test="timeForCourse == '16:00 ~ 17:45' && weekday == '星期一'"><s:set name="ae" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '16:00 ~ 17:45' && weekday == '星期二'"><s:set name="be" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '16:00 ~ 17:45' && weekday == '星期三'"><s:set name="ce" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '16:00 ~ 17:45' && weekday == '星期四'"><s:set name="de" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '16:00 ~ 17:45' && weekday == '星期五'"><s:set name="ee" value="courseName"></s:set></s:if>
          
           <s:if test="timeForCourse == '18:30 ~ 20:00' && weekday == '星期一'"><s:set name="af" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '18:30 ~ 20:00' && weekday == '星期二'"><s:set name="bf" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '18:30 ~ 20:00' && weekday == '星期三'"><s:set name="cf" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '18:30 ~ 20:00' && weekday == '星期四'"><s:set name="df" value="courseName"></s:set></s:if>
           <s:if test="timeForCourse == '18:30 ~ 20:00' && weekday == '星期五'"><s:set name="ef" value="courseName"></s:set></s:if>
      </s:iterator>					
						
						<table id="table" class="a" width="650" height="500" border="1px" bordercolor="#0094AF">
							<tr>
								<td class="td">
								</td>
								<td width="100" class="td">
									周一
								</td >
								<td width="100" class="td">
									周二
								</td>
								<td width="100" class="td">
									周三
								</td>
								<td width="100" class="td">
									周四
								</td>
								<td width="100" class="td">
									周五
								</td>
							</tr>
							<tr>
								<td class="td">
									第一，二节 (08:20 ~ 09:45)
								</td>
								<td class="td">
									<s:property value="#aa"/>
								</td>
								<td class="td">
                                    <s:property value="#ba"/>
								</td>
								<td class="td">
                                     <s:property value="#ca"/>
								</td>
								<td class="td">
                                   <s:property value="#da"/>
								</td>
								<td class="td">
                                   <s:property value="#ea"/>
								</td>
							</tr>
							<tr>
								<td class="td">
									第三，四节 (10:20 ~ 11:45)
								</td>
								<td class="td">
                                   <s:property value="#ab"/>                         
								</td>
								<td class="td">
                                   <s:property value="#bb"/>
								</td>
								<td class="td">
                                   <s:property value="#cb"/>
								</td>
								<td class="td">
                                   <s:property value="#db"/>
								</td>
								<td class="td">
                                   <s:property value="#eb"/>
								</td>
							</tr>
							<tr>
								<td class="td">
									第五，六节 (12:00 ~ 13:45)
								</td>
								<td class="td">
                                   <s:property value="#ac"/>
								</td>
								<td class="td">
                                   <s:property value="#bc"/>
								</td>
								<td class="td">
                                   <s:property value="#cc"/>
								</td>
								<td class="td">
                                   <s:property value="#dc"/>
								</td>
								<td class="td">
                                   <s:property value="#ec"/>
								</td>
							</tr>
							<tr>
								<td class="td">
									第七，八节 (14:00 ~ 15:45)
								</td>
								<td class="td">
                                   <s:property value="#ad"/>
								</td>
								<td class="td">
                                   <s:property value="#bd"/>
								</td>
								<td class="td">
                                   <s:property value="#cd"/>
								</td>
								<td class="td">
                                   <s:property value="#dd"/>
								</td>
								<td class="td">
                                   <s:property value="#ed"/>
								</td>
							</tr>
							<tr>
								<td class="td">
									第九，十节 (16:00 ~ 17:45)
								</td>
								<td class="td">
                                   <s:property value="#ae"/>
								</td>
								<td class="td">
                                   <s:property value="#be"/>
								</td>
								<td class="td">
                                   <s:property value="#ce"/>
								</td>
								<td class="td">
                                   <s:property value="#de"/>
								</td>
								<td class="td">
                                   <s:property value="#ee"/>
								</td>
							</tr>
							<tr>
								<td class="td">
									第十一，十二节 (18:30 ~ 20:00)
								</td>
								<td class="td">
                                   <s:property value="#af"/>
								</td>
								<td class="td">
                                   <s:property value="#bf"/>
								</td>
								<td class="td">
                                   <s:property value="#cf"/>
								</td>
								<td class="td">
                                   <s:property value="#df"/>
								</td>
								<td class="td">
                                   <s:property value="#ef"/>
								</td>
							</tr>
							
						</table>
						<div id="download" class="a">
						    <a href="downloadcoursetable.action?id=<s:property value="#session.studentID" />" class="a">下载课表</a>
						</div>
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
