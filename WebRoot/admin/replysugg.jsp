<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>admin reply suggestion page</title>
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
               
           反馈学生学号：<s:property value="suggestion[0].studentID"/><br/><br/>
     反馈学生姓名：<s:property value="suggestion[0].studentName"/><br/><br/>
     反馈问题题目：<s:property value="suggestion[0].title"/><br/><br/>
     反馈内容：<s:property value="suggestion[0].suggContent"/><br/><br/>
     反馈时间：<s:property value="suggestion[0].timeOfSugg"/><br/><br/>
     <s:form action="replysugg.action" method="post">
                  反馈回复：<s:textarea id="1" name="sugg.replyContent" rows="10" cols="50"/><br/>
       <input type="hidden" name="sugg.suggestionID" value="<s:property value="suggestion[0].suggestionID" />" />
       <s:submit value="回复反馈"/>
     </s:form>
     <s:form action="adminfindAllSuggs.action" method="post"><s:submit value="取消"/></s:form>
           
           
           
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
