package com.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SelectCoursesService;
import com.vo.Conofselcou;

@ParentPackage("struts2_selectCourse")
public class MySelectedCourseAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private ArrayList<Conofselcou> conse;
	private String checkmessage;
	private int coursenum = 0;//课程总数
	private int credits = 0;//总学分
	private HttpServletRequest request;
		
		public MySelectedCourseAction() {
			request = ServletActionContext.getRequest();
		}
	public int getCoursenum() {
		return coursenum;
	}
	public void setCoursenum(int coursenum) {
		this.coursenum = coursenum;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getCheckmessage() {
		return checkmessage;
	}
	public void setCheckmessage(String checkmessage) {
		this.checkmessage = checkmessage;
	}
	public ArrayList<Conofselcou> getConse() {
		return conse;
	}
	public void setConse(ArrayList<Conofselcou> conse) {
		this.conse = conse;
	}

	//检查是否已选
	@Action(value = "checkselected",
			interceptorRefs = { @InterceptorRef(value = "LoginCheck") },
			results = {
			@Result(name = "success", location = "/student/myconsequence.jsp"),
			@Result(name = "error", location = "/student/myconsequence.jsp") }
	)
	public String checkSelected() throws Exception{
		System.out.println("checkSelected");
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.get("studentID");//session的是当前登陆的学生的信息
		session.get("studentName");
		session.get("department");
		session.get("major");
		session.get("yearEnter");
		session.get("classes");
		session.get("eduLevel");
		session.get("photo");
		session.get("direction");
		//查找该生所有已选课程结果
		checkmessage = null;
		this.conse = new SelectCoursesService().checkSelected((String)session.get("studentID"));
		
		if(this.conse == null){
			checkmessage = "您当前没有任何选课结果！";
			System.out.println(checkmessage);
			return ERROR;
		}else{
			//对所选课程的信息统计：
			coursenum = this.conse.size();//课程总数
		    for(int i = 0;i < this.conse.size();i++){
		    	credits += this.conse.get(i).getCredit();//总学分
		    }		
			for(int i = 0;i<this.conse.size();i++){
				System.out.println(this.conse.get(i).getCourseID());
				System.out.println(this.conse.get(i).getCourseName());
				System.out.println(this.conse.get(i).getCredit());
				System.out.println(this.conse.get(i).getTimeForCourse());//
				System.out.println(this.conse.get(i).getLocation());
				System.out.println(this.conse.get(i).getTeacherName());
				System.out.println(this.conse.get(i).getTeaEmail());
				System.out.println(this.conse.get(i).getStudentID());
				System.out.println(this.conse.get(i).getStudentName());
				System.out.println(this.conse.get(i).getPickUp());
				System.out.println(this.conse.get(i).getPickUpTime());//
				System.out.println(this.conse.get(i).getWeekday());//
				System.out.println("=======================");
			}
			
			return SUCCESS;
		}
		
		
	}
	
	//我的课表
	@Action(value = "mycoursetable",
			interceptorRefs = { @InterceptorRef(value = "LoginCheck") },
			results = {
			@Result(name = "success", location = "/student/mycoursetable.jsp"),
			@Result(name = "error", location = "/student/mycoursetable.jsp") }
	)
	public String myCourseTable() throws Exception{
		System.out.println("myCourseTable");
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.get("studentID");//session的是当前登陆的学生的信息
		//查找该生所有已选课程结果
		checkmessage = null;
		this.conse = new SelectCoursesService().checkSelected((String)session.get("studentID"));
		if(this.conse == null){
			checkmessage = "您当前没有任何选课结果！";
			System.out.println(checkmessage);
			return ERROR;
		}
		return SUCCESS;	
	}
	
	
	//下载课表
	@Action(value = "downloadcoursetable",
			interceptorRefs = { @InterceptorRef(value = "LoginCheck") },
			results = {
			@Result(name = "success",type="chain", location = "mycoursetable")}
	)
	public String downloadCourseTable() throws Exception{
		System.out.println("downloadCourseTable");
       new SelectCoursesService().downloadCourseTable(request.getParameter("id"));
		checkmessage = "下载成功！";
		return SUCCESS;	
	}
	
	
	//admin下载选课结果
	@Action(value = "downloadconse",
			interceptorRefs = { @InterceptorRef(value = "LoginCheck") },
			results = {
			@Result(name = "success",type="chain", location = "checkAdminLogintwo")}
	)
	public String downloadConse() throws Exception{
		System.out.println("downloadCourseTable");
        new SelectCoursesService().downloadConse();
		checkmessage = "下载成功！";
		return SUCCESS;	
	}
}
