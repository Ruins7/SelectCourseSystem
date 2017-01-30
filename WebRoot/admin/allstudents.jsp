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
                <font>
      <s:property value="errorAdd"/> <!-- 删除是否成功 -->
   </font>
    <table class="b" width="765">
			<tr>
				<td>
					学号
				</td>
				<td>
					姓名
				</td>
				<td>
					性别
				</td>
				<td>
					学院
				</td>
				<td>
					专业
				</td>
				<td>
					入学年份
				</td>
				<td>
					班级
				</td>				
				<td>
					QQ号
				</td>
				<td>
					手机号
				</td>
				<td>
					电子邮箱
				</td>
				<td>
					身份证号
				</td>
				<td>
					生日
				</td>
				<td>
					培养层次
				</td>
				<td>
					头像
				</td>				
				<td>
					操作
				</td>				
			</tr>

			<s:iterator value="student">
				<tr>
					<td>
						<s:property value="studentID" />
					</td>
					<td>
						<s:property value="studentName" />
					</td>
					<td>
					    <s:property value="sex" />
					</td>
					<td>
						<s:property value="department" />
					</td>
					<td>
						<s:property value="major" />
					</td>
					<td>
						<s:property value="yearEnter" />
					</td>
					<td>
						<s:property value="classes" />
					</td>
					<td>
						<s:property value="qq" />
					</td>
					<td>
						<s:property value="stuTeleNum" />
					</td>
					<td>
						<s:property value="stuEmail" />
					</td>
					<td>
						<s:property value="idCardNum" />
					</td>
					<td>
					    <s:date name="birthday" format="yyyy-MM-dd" />
					</td>
					<td>
						<s:property value="eduLevel" />
					</td>
					<td>
						<img src="" width="60" height="60">
					</td>
					<td>
						<s:form action="deletestudent.action" method="post">
							<s:submit value="删除"></s:submit>
							<input type="hidden" name="studentid" value="<s:property value="studentID" />" />
						</s:form>
					</td>
				</tr>
			</s:iterator>
		</table>       
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
