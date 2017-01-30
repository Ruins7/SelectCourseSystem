<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>   
    <title>change admin password page</title>
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
               
             <font color="red"> <s:property value="changeResult" /> </font><!-- 输入的原密码有误，修改失败 -->
    <s:fielderror fieldName="oldnull"></s:fielderror>
    <s:fielderror fieldName="newnull"></s:fielderror>
    <s:fielderror fieldName="final"></s:fielderror>
     <s:form action="changeAdminPassword.action" method="post">
        请输入旧密码：<s:password name="oldpassword" id="1" onblur="checknull(this)"/><br/>
        请输入新密码：<s:password name="newpassword" id="2" onblur="checknull(this)"/><br/>
        新密码确认：<s:password name="renewpassword" id="3" onblur="compare(this)"/><br/>
        <s:submit value="确认修改"></s:submit>
     </s:form>
     <a href="../admin/adminhomepage.jsp" class="b">取消</a><br/>
           
           
           
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



   
     <!--
     <script type="text/javascript">
function compare(obj){
          var i = document.forms[0].elements[1].value;
          var j = document.forms[0].elements[2].value;
          if(i!=j||j==""){
          alert("密码输入不一致！且不能为空！");
          i.value="";	
          j.value="";	
          var text = document.getElementById(obj.id);
          text.focus(); 	  
          }		  
}
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
