<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>admin all deps page</title>
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
		
		<table  width="769" class="b">
			<tr>
				<td>
					学院名称
				</td>
				<td>
					学院编号
				</td>
				<td>
					操作
				</td>
			</tr>
			<s:iterator value="dep">
				<tr>
					<td>
						<s:property value="depName" />
					</td>
					<td>
						<s:property value="depID" />
					</td>
					<td>
						<s:form action="senddepid.action" method="post">
							<s:submit value="修改" />
							<input type="hidden" name="depid"
								value="<s:property value= "depID" /> " />
						</s:form>
					</td>
					<td>
						<s:form action="deletedep.action" method="post">
							<s:submit value="删除"></s:submit>
							<input type="hidden" name="depid" value="<s:property value="depID" />" />
						</s:form>
					</td>
				</tr>
			</s:iterator>
		</table>
		<hr/>
		<a href="../admin/adddep.jsp" class="b">增加学院</a>
           
           
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
