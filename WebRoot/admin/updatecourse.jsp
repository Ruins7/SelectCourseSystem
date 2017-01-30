<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>admin update course page</title>
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
               
           <font color="red"> <s:property value="errorAdd" /> </font><!-- 修改失败！请重试！ -->
  <s:form action="updatecourse.action" method="post">
     课程名称：<s:textfield name="cou.courseName" id="1"/><br>
     学分：<s:textfield id="2" name="cou.credit"/><br/>
     课程类别：<s:radio id="3" list="{'专业课','非专业课'}" name="cou.classification" value="'专业课'"/><br/>
     课程性质：<s:radio id="4" list="{'必修课','选修课'}" name="cou.property" value="'必修课'"/><br/>
     学时：  <s:select id="5" list="{'16','24','32','64','72'}" name="cou.period" value="'32'"/><br/>
     开课单位：<s:select id="6" list="dep" listKey="depID" listValue="depName" name="cou.offerDepID" value="1"/><br/>  
    上课星期：<s:radio id="17" list="{'星期一','星期二','星期三','星期四','星期五'}" name="cou.weekday" value="'星期一'"/><br/>
     上课时间：<s:select id="7" list="{'8','10','14','16','18','20'}" name="timeForCourseHourB"/>: 
         <s:select id="8" list="{'00','20','45'}" name="timeForCourseMinB"/> ~ 
         <s:select id="9" list="{'9','11','15','17','19','21'}" name="timeForCourseHourE"/>:  
         <s:select id="10" list="{'00','20','45'}" name="timeForCourseMinE"/><br/> 
     上课地点：<s:textfield id="11" name="cou.location"/><br/>  
     任课教师：<s:select id="12" list="tea" listKey="teacherID" listValue="teacherName" name="cou.teacherID" value="1"/><br/>
     课程针对专业：<s:select id="12" list="maj" listKey="majID" listValue="majorName" name="cou.majID" value="1"/><br/>
     课程最大容纳学生数：<s:textfield id="13" name="cou.max"/><br/>
     所属培养方案：<s:select id="14" list="pla" listKey="planID" listValue="planName" name="cou.planID" value="1"/><br/>
     课程所属年级：<s:select id="15" list="{'一年级','二年级','三年级','四年级'}" name="cou.grade" value="'一年级'"/><br/>
   课程所属培养层次：<s:select id="16" list="{'本科','硕士','博士'}" name="cou.eduLevel" value="'本科'"/><br/>   
     <input type="hidden" name="cou.courseID" value="<s:property value="courseid"/>">
    <br/>    <s:submit value="修改课程"/><br>
  </s:form>
  <s:form action="adminfindAllCourses.action" method="post"><s:submit value="取消"/></s:form>
           
           
           
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
