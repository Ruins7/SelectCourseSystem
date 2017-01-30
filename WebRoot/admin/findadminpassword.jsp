<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>find admin password page</title>
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
               
           <font color="red"> <s:property value="notFindPs" /></font><!-- 输入的管理员账号或管理员邮箱有误！请重新输入！ -->
		   <s:fielderror fieldName="adminidnull"></s:fielderror>
           <s:fielderror fieldName="adminemailnull"></s:fielderror>
           <s:fielderror fieldName="emailerror"></s:fielderror>
		<s:form action="findadminpassword.action" method="post">
    请输入管理员账号：<s:textfield id="1" name="admin.adminID" onblur="checknull(this)" />&nbsp;&nbsp;
    请输入管理员邮箱：<s:textfield id="2" name="admin.adminEmail" onblur="checknull(this)" />
         <s:submit value="管理员密码找回"></s:submit>
		</s:form>
		<a href="../admin/adminlogin.jsp" class="b">取消</a><br/>
         </div>
            <div id="contentright">
          
            </div> 
       </div>
   
   <hr />
    <div id="bottom">
     © 2013－2014 Ruins7.com, all rights reserved. ALL by Ruins7.
       </div>
   
   
   </div>
	
	
		<!--<script type="text/javascript">	
function checknull(obj){
        if(obj.value == ""){
        alert("该项不能为空！");
        var text = document.getElementById(obj.id);
        text.focus(); 
        }
}
      </script>
	--></body>
</html>
