<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
		<title>admin change select course time page</title>
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
               
           <font color="red"> <s:property value="message" /> </font><br/>
		<!-- 是否设置成功 -->
		<s:if test="#application.level == null">
		当前还未设置选课时间段以及阶段！		
		</s:if>
		<s:elseif test="#application.level != null">
		     当前已设置的选课阶段为：<s:property value="#application.level"/><br/>
		     当前已设置的选课开始时间为：<s:property value="#application.by"/>年<s:property value="#application.bm"/>月<s:property value="#application.bd"/>日 <s:property value="#application.bh"/>时<s:property value="#application.bmin"/>分<s:property value="#application.bs"/>秒<br/>
		     当前已设置的选课结束时间为：<s:property value="#application.ey"/>年<s:property value="#application.em"/>月<s:property value="#application.ed"/>日 <s:property value="#application.eh"/>时<s:property value="#application.emin"/>分<s:property value="#application.es"/>秒<br/>
		</s:elseif>
		<br/><br/><br/>
		设置选课阶段及时间：
		<br/>
		<br/>
		<s:form action="selecttime.action" method="post">
                                  设置选课开始时间：<s:select id="1" list="{'2012','2013','2014','2015'}" name="time.by" />年
                           <s:select id="2" list="{'01','02','03','04','05','06','07','08','09','10','11','12'}" name="time.bm" />月
                           <s:select id="3" list="{'01','02','03','04','05','06','07','08','09','10','11','12','13','14','15','16','17','18','19','20','21','22','23','24','25','26','27','28','29','30','31'}" name="time.bd" />日
                           <s:select id="4" list="{'00','01','02','03','04','05','06','07','08','09','10','11','12','13','14','15','16','17','18','19','20','21','22','23'}" name="time.bh" />时
                           <s:select id="5" list="{'00','10','20','30','40','50'}" name="time.bmin" />分
                           <s:select id="6" list="{'00'}" name="time.bs" />秒
			<br />
			<br/>
                                  设置选课结束时间：<s:select id="7" list="{'2012','2013','2014','2015'}" name="time.ey" />年
                           <s:select id="8" list="{'01','02','03','04','05','06','07','08','09','10','11','12'}" name="time.em" />月
                           <s:select id="9" list="{'01','02','03','04','05','06','07','08','09','10','11','12','13','14','15','16','17','18','19','20','21','22','23','24','25','26','27','28','29','30','31'}" name="time.ed" />日
                           <s:select id="10" list="{'00','01','02','03','04','05','06','07','08','09','10','11','12','13','14','15','16','17','18','19','20','21','22','23'}" name="time.eh" />时
                           <s:select id="11" list="{'00','10','20','30','40','50'}" name="time.emin" />分
                           <s:select id="12" list="{'00'}" name="time.es" />秒
			<br />
			<br/>
			  选择选课阶段：<s:select id="3" list="{'第一阶段','第二阶段','第三阶段'}" name="time.level"/><br/>
			<s:if test="#application.level == null">
			<br />
			<br/>
			<s:submit value="提交选课时间段以及选课阶段"/>
			</s:if>
			<br />
			<br/>
			<s:elseif test="#application.level != null">
			<s:submit value="修改选课时间段以及选课阶段"/>
			</s:elseif>
		</s:form>
		<a href="cleartime.action" class="b">清除选课时间</a>
   
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
