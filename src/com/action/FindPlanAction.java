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
import com.vo.Course;
import com.vo.Plan;

@ParentPackage("struts2_selectCourse")
public class FindPlanAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
    private ArrayList<Plan> plan;
    private ArrayList<Course> course;
    private  Map<String, Short> personNum;
    private String planCourse;//返回的提示
    private HttpServletRequest request;
    
	
	public Map<String, Short> getPersonNum() {
		return personNum;
	}
	public void setPersonNum(Map<String, Short> personNum) {
		this.personNum = personNum;
	}
	public String getPlanCourse() {
		return planCourse;
	}
	public void setPlanCourse(String planCourse) {
		this.planCourse = planCourse;
	}
	public ArrayList<Course> getCourse() {
		return course;
	}
	public void setCourse(ArrayList<Course> course) {
		this.course = course;
	}
	public ArrayList<Plan> getPlan() {
		return plan;
	}
	public void setPlan(ArrayList<Plan> plan) {
		this.plan = plan;
	}
	
	public FindPlanAction() {
		request = ServletActionContext.getRequest();
	}

	//按当前学号查找相应培养方案(按学生的专业和培养层次查询)
	@Action(value = "plan", 
			interceptorRefs = {
			@InterceptorRef(value="LoginCheck")},
			results = {@Result(name = "success", location="/student/plans.jsp")}
	)
	public String findPlan() throws Exception{
		Map<String, Object> session = ActionContext.getContext().getSession();
		System.out.println(session.get("major"));//session的是当前登陆的学生的信息
		System.out.println(session.get("eduLevel"));
		this.plan = new SelectCoursesService().findPlans((String)session.get("major"),(String)session.get("eduLevel"));
		return SUCCESS;
	}
	
	//查看某一培养计划下的课程并选课
	@Action(value = "courseofplan", 
			interceptorRefs = {
			@InterceptorRef(value="LoginCheck")},
			results = {@Result(name = "success", location="/student/planselecourse.jsp"),
	                   @Result(name = "error", location="/student/error.jsp")}
	)
	public String findCourseOfPlan() throws Exception{
		System.out.println(request.getParameter("id"));
		String sf = null;
		this.personNum = new SelectCoursesService().findCurrentNum();
		this.course = new SelectCoursesService().findCoursesOfPlan(request.getParameter("id"));
		for (int q = 0; q < this.course.size(); q++) {// 筛选出的课程
			for (String s : personNum.keySet()) {
				if (this.course.get(q).getCourseID().equals(s)) {
					this.course.get(q).setCurrentNum(personNum.get(s));
				}
			}
		}
		if (this.course == null) {
			planCourse = "本培养计划下暂无任何课程！";
			sf = ERROR;
		} else {
			sf = SUCCESS;
		}
		return sf;
	}
	
	//admin查找当前数据库中所有培养方案
	@Action(value = "adminfindAllPlans", 
			interceptorRefs = {
			@InterceptorRef(value="AdminLoginCheck")},
			results = {@Result(name = "success", location="/admin/allplans.jsp")}
	)
	public String findAllPlans() throws Exception{
		this.plan = new SelectCoursesService().findAllPlans();
		return SUCCESS;
	}
}
