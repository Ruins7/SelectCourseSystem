<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>   
    <title>admin error page</title>
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
           
            <font color="red"> <s:property value="loginNotFound" /> </font>
		<!-- 管理员账号或密码错误！ -->
		<font color="red"> <s:property value="homePageNotFound" /> 
		<!-- 当前没有学生注册！ -->           
         </font>  
         
           </div>
            <div id="contentright">
            <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../admin/adminlogin.jsp" class="b">返回登陆</a>
            </div> 
       </div>
   
   <hr />
    <div id="bottom">
     © 2013－2014 Ruins7.com, all rights reserved. ALL by Ruins7.
       </div>
   
   
   </div>
  
  
  
  
  
  
   
  
		
  </body>
</html>
