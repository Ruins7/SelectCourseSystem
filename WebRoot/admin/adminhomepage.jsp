<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
  <head>
    <title>admin homepage</title>	
				<link rel="stylesheet" type="text/css" href="admincss.css">
		<style type="text/css">
<!--
-->
</style>
  </head>
  <body>
  <div id="all">
       <div id="top">天津理工大学教务选课系统后台控制系统</div>
        <div id="content">
            
            <font color="red"> <s:property value="changeResult" /> <!-- 管理员密码修改成功! -->      
  			<s:property value="changeResult"/><!-- 密码修改成功 --></font>	
            
            <div id="contentlift">       
  	             <div class="c" id="aa"><a href="adminfindAllDeps.action" class="b">学院信息调整</a></div>
                 <div class="c" id="bb"><a href="adminfindAllMajs.action" class="b">专业信息调整</a></div>
                 <div class="c" id="cc"><a href="adminfindAllPlans.action" class="b">培养方案调整</a></div>
                 <div class="c" id="dd"><a href="adminfindAllCourses.action" class="b">课程信息调整</a></div>
                 <div class="c" id="ee"> <a href="adminfindAllTeachers.action" class="b">教师信息调整</a></div>
                
                 <hr />
                
                  <div class="c" id="ff"><a href="adminfindAllStudents.action" class="b">学生信息调整</a></div>
                  <div class="c" id="gg"><a href="adminfindAllNots.action" class="b">公告信息调整</a></div>
                  <div class="c" id="hh"><a href="adminfindAllSuggs.action" class="b">意见箱</a></div>
                  <div class="c" id="ii"><a href="checkAdminLogin.action" class="b">选课时间段调整</a></div>
                  <div class="c" id="jj"><a href="checkAdminLogintwo.action" class="b">选课结果统计</a></div>
           </div>  
            <div id="contentright">
            <s:if test="#session.adminID != null">
    <h4 class="b">账号为：<s:property value="#session.adminID"/>&nbsp;的管理员</h4>
           <h4 class="b">欢迎进入学生选课系统控制后台！</h4>
           
            <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
         &nbsp;&nbsp;&nbsp;<a href="adminlogout.action" class="b">退出登录</a>&nbsp;&nbsp;<a href="../admin/changeadminps.jsp" class="b">更改密码</a>    
            	</s:if>
            </div>
       </div> 
    <div id="bottom">
     © 2013－2014 Ruins7.com, all rights reserved. ALL by Ruins7.
       </div>
 </div> 
    </body>
</html>
