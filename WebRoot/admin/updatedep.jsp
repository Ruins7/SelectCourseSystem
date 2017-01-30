<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>

		<title>admin update plan page</title>
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
                <font color="red"> <s:property value="errorAdd" /> </font><!-- 添加失败！请重试！ -->
  <s:form action="updateDep.action" method="post">
     学院名称：<s:textfield name="depart.depName" id="1"/><br>
     <input type="hidden" name="depart.depID" value="<s:property value="depid"/>">
    <br><br> <s:submit value="提交"/><br>
  </s:form>
  <s:form action="adminfindAllDeps.action" method="post"><s:submit value="取消"/></s:form>
           
           
           
           
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
