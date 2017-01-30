<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>admin charge the consequence of select course page</title>
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
                
  <font color="red"> 
      <s:property value="message"/>
  </font>
  <h2>第一阶段选课结果计算</h2>
     <a href="bytime.action" class="b">按选课时间</a>
     <a href="byrandom.action" class="b">随机</a>
  <h2>第二,三阶段选课结果更新</h2>
     <a href="checkAdminLogintwo.action" class="b">更新选课结果</a>
     
     <h3>以下当前所有选课结果！</h3>
               <br/>
               <div id="download">
           <a href="downloadconse.action" class="b">下载选课结果</a>
           </div>
               <hr/><br/>
			<table class="b" width="765">
				<tr>
					<td>
						课程ID
					</td>
					<td>
						课程名称
					</td>
					<td>
						上课时间
					</td>
					<td>
						上课周期
					</td>
					<td>
						上课地点
					</td>
					<td>
						任课教师
					</td>
					<td>
						教师邮箱
					</td>
					<td>
						选课学生学号
					</td>
					<td>
						学生姓名
					</td>
					<td>
						选课时间
					</td>				
					<td>
						结果
					</td>
				</tr>
				<s:iterator value="cons">
					<tr>
						<td>
							<s:property value="courseID" />
						</td>
						<td>
							<s:property value="courseName" />
						</td>
						<td>
							<s:property value="timeForCourse" />
						</td>
						<td>
							<s:property value="weekday" />
						</td>
						<td>
							<s:property value="location" />
						</td>
						<td>
							<s:property value="teacherName" />
						</td>
						<td>
							<s:property value="teaEmail" />
						</td>
						<td>
						<s:property value="studentID" />
					</td>
					<td>
						<s:property value="studentName" />
					</td>
						<td>
							  <s:property value="pickUpTime"/>
						</td>
						<td><s:if test="pickUp == 1">选中</s:if>
						    <s:elseif test="pickUp == 0">未选中</s:elseif>					
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
