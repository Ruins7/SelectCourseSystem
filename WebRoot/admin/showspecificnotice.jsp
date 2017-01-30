<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>  
<head>
		<title> This is the notice content page.</title>
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
               
      
    <h1 > 公告编号：<s:property value="noticeID"/></h1><br/><br/>
    <s:property value="noticeContent"/>
    
    <br/><br/><br/><hr/><br/><br/>
    <a href="updatenotice.jsp?id=<s:property value="noticeID"/>"  class="b">修改公告</a>
           
           
           
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
