package com.action;

import java.util.ArrayList;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.service.SelectCoursesService;
import com.vo.Course;

@ParentPackage("struts2_selectCourse")
public class FindAllCoursesAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ArrayList<Course> courses = null;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	// 主页selectALLCourses
	@Action(value = "findAllCourses", 
			results = { @Result(name = "success", location = "/student/allcourses.jsp"),
	                    @Result(name = "error", location = "/student/allcourses.jsp")}
	)
	public String execute() throws Exception {
		this.courses = new SelectCoursesService().findAllCourses();
		if(this.courses == null){
			message = "暂时没有任何课程！";
			return ERROR;
		}else{
			return SUCCESS;
		}
	}
	
	// admin查找所有课程
	@Action(value = "adminfindAllCourses",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", location = "/admin/allcourses.jsp"),
	                    @Result(name = "error", location = "/admin/allcourses.jsp")}
	)
	public String adminfindAllCourses() throws Exception {
		this.courses = new SelectCoursesService().findAllCourses();
		if(this.courses == null){
			message = "暂时没有任何课程！";
			return ERROR;
		}else{
			return SUCCESS;
		}
		
	}
}
