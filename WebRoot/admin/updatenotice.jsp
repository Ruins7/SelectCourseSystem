<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>admin update notice page</title>
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
  <s:form action="updatenotice.action" method="post">
    公告题目：<s:textfield id="1" name="notice.title" /><br>
     公告内容：<s:textarea id="2" name="notice.content" rows="10" cols="50"/><br/>
      <input type="hidden" name="notice.noticeID" value="<%= request.getParameter("id") %>">
     <br><br><s:submit value="修改公告"/><br>
  </s:form>
  <s:form action="adminfindAllNots.action" method="post"><s:submit value="取消"/></s:form>
           
           
           
           
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
