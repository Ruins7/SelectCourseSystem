<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>    
    <title>all courses page</title>
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
   <s:property value="errorAdd"/>
   <s:property value="message"/>
    </font>
    <table width="765" class="b">
    <tr>
                     <td>课程ID</td>        
                     <td>课程名称</td>        
                     <td>学分</td>        
                     <td>类别</td>        
                     <td>性质</td>        
                     <td>学时</td>        
                     <td>开课学院</td>        
                     <td>上课周期</td>        
                     <td>上课时间</td>        
                     <td>上课地点</td>        
                        
                     <td>任课教师姓名</td>              
                     <td>教师Email</td>        
                       
                     <td>针对专业</td>        
                     <td>课程最大容量</td>           
                             
                     <td>所属培养计划名称</td>           
                     <td>年级</td>           
                     <td>培养层次</td>           
                     <td>操作</td>           
                </tr>
    <s:iterator value="courses">           
				<tr>						    			
				   <td><s:property value="courseID"/></td>        
                   <td><s:property value="courseName"/></td>        
                   <td><s:property value="credit"/></td>        
                   <td><s:property value="classification"/></td>        
                   <td><s:property value="property"/></td>        
                   <td><s:property value="period"/></td>        
                   <td><s:property value="offerDepart"/></td>        
                   <td><s:property value="weekday"/></td>        
                   <td><s:property value="timeForCourse"/></td>        
                   <td><s:property value="location"/></td>                               
                   <td><s:property value="teacherName"/></td>        
                   <td><s:property value="teaEmail"/></td>                                              
                   <td><s:property value="majorName"/></td>              
                   <td><s:property value="max"/></td>                               
                   <td><s:property value="planName"/></td>        
                   <td><s:property value="grade"/></td>        
                   <td><s:property value="eduLevel"/></td>        
                   <td><s:form action="sendcourseid.action" method="post">
							<s:submit value="修改" />
							<input type="hidden" name="courseid"
								value="<s:property value= "courseID" /> " />
						</s:form></td>        
                   <td><s:form action="deletecourse.action" method="post">
							<s:submit value="删除"></s:submit>
							<input type="hidden" name="courseid" value="<s:property value="courseID" />" />
						</s:form></td>        
                   <td></td>        
			    </tr>
    </s:iterator>
    </table>
    <hr>
    	<a href="findDepTeaPlan.action" class="b">增加课程</a>
           
           
           
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
