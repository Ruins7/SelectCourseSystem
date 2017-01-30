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
  <s:form action="updatePlan.action" method="post">
     培养方案名称：<s:textfield name="plan.planName" id="1"/><br>
     方案类型：<s:radio list="{'主修','辅修'}" name="plan.type" id="2" value="'主修'"/><br>
     专业：<s:select id="3" name="plan.majID" list="maj" listKey="majID" listValue="majorName"/><br><!-- action动态 -->
     学位类型：<s:radio list="{'工学','理学','文学','法学','商学','医学'}" name="plan.degree" id="4" value="'工学'"/><br>
     培养层次：<s:radio list="{'本科','硕士','博士'}" name="plan.eduLevel" id="5" value="'本科'"/><br>
     方向：<s:textfield name="plan.direction" id="6"/><br>
     学分要求：<s:textfield name="plan.minCredit" id="7"/><br>
     <input type="hidden" name="plan.planID" value="<s:property value="planid"/>">
     <br><br><s:submit value="提交"/><br>
  </s:form>
  <s:form action="findAllPlans.action" method="post"><s:submit value="取消"/></s:form>
           
           
           
           
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
