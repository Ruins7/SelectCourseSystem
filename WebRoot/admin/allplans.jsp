<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>admin all plans page</title>
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
               	<font color="red"> <s:property value="errorAdd" /> </font>
		<!-- 是否添加添加成功 // 是否修改成功 // 是否删除成功-->
		<font color="red"> <s:property value="haveBeenSign" /> </font>
		<!-- 没有必要的专业信息-->
		<table class="b" width="765">
			
			<tr>
				<td>
					方案名称
				</td>
				<td>
					修读类型
				</td>
				<td>
					专业
				</td>
				<td>
					学位类型
				</td>
				<td>
					培养层次
				</td>
				<td>
					方向
				</td>
				<td>
					学分要求
				</td>
				<td>
					方案定制时间
				</td>
				<td>
					操作
				</td>
			</tr>
			<s:iterator value="plan">
				<tr>
					<td>
						<s:property value="planName" />
					</td>
					<td>
						<s:property value="type" />
					</td>
					<td>
						<s:property value="major" />
					</td>
					<td>
						<s:property value="degree" />
					</td>
					<td>
						<s:property value="eduLevel" />
					</td>
					<td>
						<s:property value="direction" />
					</td>
					<td>
						<s:property value="minCredit" />
					</td>
					<td>
						<s:date name="timeForPlan" format="yyyy-MM-dd" />
					</td>
					<td>
						<s:form action="sendplanid.action" method="post">
							<s:submit value="修改" />
							<input type="hidden" name="planid"
								value="<s:property value= "planID" /> " />
						</s:form>
					</td>
					<td>
						<s:form action="deleteplan.action" method="post">
							<s:submit value="删除"></s:submit>
							<input type="hidden" name="planid" value="<s:property value="planID" />" />
						</s:form>
					</td>
				</tr>
			</s:iterator>
		</table>
		<hr/>
		<a href="findDepMajForAdmin.action" class="b">增加培养方案</a>
   
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
