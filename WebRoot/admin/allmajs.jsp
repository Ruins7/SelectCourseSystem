<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>admin all maj page</title>
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
		<table class="b" width="765">
		
			<tr>
				<td>
					专业编号
				</td>
				<td>
					专业名称
				</td>
				<td>
					所属学院编号
				</td>
				<td>
					所属学院名称
				</td>
				<td>
					操作
				</td>
			</tr>
			<s:iterator value="maj">
				<tr>
					<td>
						<s:property value="majID" />
					</td>
					<td>
						<s:property value="majorName" />
					</td>
					<td>
						<s:property value="depID" />
					</td>
					<td>
						<s:property value="depName" />
					</td>
					<td>
						<s:form action="sendmajid.action" method="post">
							<s:submit value="修改" />
							<input type="hidden" name="majid"
								value="<s:property value= "majID" /> " />
						</s:form>
					</td>
					<td>
						<s:form action="deletemaj.action" method="post">
							<s:submit value="删除"></s:submit>
							<input type="hidden" name="majid" value="<s:property value="majID" />" />
						</s:form>
					</td>
				</tr>
			</s:iterator>
		</table>
		<hr/>
		<a href="findDepForAdminAddMaj.action" class="b">增加专业</a>
           
           
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
