package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.service.SelectCoursesService;
import com.vo.Suggestion;

@ParentPackage("struts2_selectCourse")
public class StuMessAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private ArrayList<Suggestion> sugg;
	private String message;
    
	public StuMessAction() {
		request = ServletActionContext.getRequest();
	} 
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<Suggestion> getSugg() {
		return sugg;
	}
	public void setSugg(ArrayList<Suggestion> sugg) {
		this.sugg = sugg;
	}

	// 学生查收反馈
	@Action(value = "findreplysuggmess",
			interceptorRefs = { @InterceptorRef(value = "LoginCheck") }, 
			results = { @Result(name = "success", location = "/student/myschoolmess.jsp"),
			            @Result(name = "error", location = "/student/myschoolmess.jsp")}
	)
	public String checkreplysugg() throws Exception{
		System.out.println(request.getParameter("id"));
		//检查suggestion的回复
		this.sugg = new SelectCoursesService().checkReplySugg(request.getParameter("id"));
		if(this.sugg == null){
			message = "暂时没有您的反馈回复！";
			return ERROR;
		}else{
			return SUCCESS;
		}
		
	}
	
}
