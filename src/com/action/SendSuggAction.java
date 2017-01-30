package com.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
public class SendSuggAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
    private Suggestion sugg;
    private ArrayList<Suggestion> suggestion;
    private String message;
    private HttpServletRequest request;
    	
    public SendSuggAction() {
		request = ServletActionContext.getRequest();
	}    
	public ArrayList<Suggestion> getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(ArrayList<Suggestion> suggestion) {
		this.suggestion = suggestion;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Suggestion getSugg() {
		return sugg;
	}
	public void setSugg(Suggestion sugg) {
		this.sugg = sugg;
	}

	//验证  学生提交反馈
	public void validateStudentSendSugg(){
		System.out.println("验证  学生提交反馈");
		System.out.println(this.sugg.getTitle().trim());
		System.out.println(this.sugg.getSuggContent());
		if(this.sugg.getTitle().trim().equals(null) || this.sugg.getTitle().trim().equals("") || this.sugg.getSuggContent().equals(null) || this.sugg.getSuggContent().equals("")){
			  addFieldError("errors", "反馈的题目和内容不能为空");
		}
	}
	
	
	// 学生提交反馈
	@Action(value = "sendsugg",
			interceptorRefs = { @InterceptorRef(value = "LoginCheck") }, 
			results = { @Result(name = "success",type="chain", location = "homepage"),
			            @Result(name = "error", location = "/student/sendsugg.jsp"),
			            @Result(name = "input", location = "/student/sendsugg.jsp")}
	)
	public String studentSendSugg() throws Exception{
		System.out.println("sendSugg");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 获得当前系统时间
		String time = sdf.format(new Date());// 转换为String
		//获取suggestionID(14位)
		this.sugg.setSuggestionID(time.substring(0, 4) + time.substring(5, 7)
				+ time.substring(8, 10)+time.substring(11, 13)+time.substring(14, 16)+time.substring(17, 19));
		//获取timeOfSugg
		this.sugg.setTimeOfSugg(time);
		boolean boo = false;
		boo = new SelectCoursesService().studentSendSugg(this.sugg);
		if(boo == true){
			message = "提交成功！";
			return SUCCESS;
		}else{
			message = "提交失败！";
			return ERROR;
		}	
	}
	
	// admin查找某一个反馈的信息
	@Action(value = "searchsugg",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", location = "/admin/replysugg.jsp")}			       
	)
	public String searchSugg() throws Exception{
		System.out.println("searchSugg");
		System.out.println(request.getParameter("id"));
		this.suggestion = new SelectCoursesService().searchSugg(request.getParameter("id"));
		System.out.println(this.suggestion.size());
		return SUCCESS;
	}

	//admin回复反馈验证
	public void validateReplySugg(){
		if(this.sugg.getReplyContent().trim().equals(null) || this.sugg.getReplyContent().trim().equals("")){
			addFieldError("replycontentnull", "回复内容不能为空！");
		}
	}
	
	// admin回复反馈
	@Action(value = "replysugg",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", type="chain", location = "adminfindAllSuggs"),
			            @Result(name = "input", location = "/admin/adminvalidateerror.jsp"),
	                    @Result(name = "error", type="chain", location = "adminfindAllSuggs")}			       
	)
	public String replySugg() throws Exception{
		System.out.println("replySugg");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 获得当前系统时间
		String time = sdf.format(new Date());// 转换为String
		this.sugg.setReplyTime(time.substring(0, 4) +"-"+ time.substring(5, 7)
				+"-"+ time.substring(8, 10) +" "+ time.substring(11, 13) +":"+ time.substring(14, 16) +":"+ 
				time.substring(17, 19)); 
		boolean boo = false;
		boo = new SelectCoursesService().replySugg(this.sugg.getReplyContent(), this.sugg.getReplyTime(), this.sugg.getSuggestionID());
		if(boo == true){
			message = "回复成功！";
			return SUCCESS;
		}else{
			message = "回复失败！";
			return ERROR;
		}
		
	}

}
