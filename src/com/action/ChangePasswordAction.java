package com.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SelectCoursesService;
import com.vo.Administrator;
import com.vo.Student;

@ParentPackage("struts2_selectCourse")
public class ChangePasswordAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String oldpassword;
	private String newpassword;
	private String renewpassword;
	private Student stu;
	private Administrator admin;
	private String changeResult;
	
	public String getRenewpassword() {
		return renewpassword;
	}
	public void setRenewpassword(String renewpassword) {
		this.renewpassword = renewpassword;
	}
	public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	public String getChangeResult() {
		return changeResult;
	}
	public void setChangeResult(String changeResult) {
		this.changeResult = changeResult;
	}
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	
	//student 修改密码验证
	public void validateChangePs(){
		if(oldpassword.trim().equals(null) || oldpassword.trim().equals("")){
			addFieldError("oldnull", "原密码不能为空！");
		}else{
			if(newpassword.trim().equals(null) || newpassword.trim().equals("")){
				addFieldError("newnull", "新密码不能为空！");
			}else{
				if(renewpassword.trim().equals(null) || renewpassword.trim().equals("") || !renewpassword.trim().equals(newpassword)){
					 addFieldError("final", "两次密码输入不一致！请重新输入！");
				}
			}
		}
	}
	
	//修改学生密码
	@Action(value = "changePassword", 
			interceptorRefs = {
			@InterceptorRef(value="LoginCheck")},
			results = { @Result(name = "error", location = "/student/changepassword.jsp"),
			            @Result(name = "input", location = "/student/changepassword.jsp"),
	                    @Result(name = "success", type="chain", location="homepage")}//有拦截器可以使用chain
	)
	public String changePs() throws Exception{
		System.out.println("更改密码");
		Map<String, Object> session = ActionContext.getContext().getSession();
		System.out.println("11111111111"+(String)session.get("studentID"));//获得当前session
	    String sid = (String) session.get("studentID");
		boolean boo = new SelectCoursesService().changePassword(sid,getOldpassword(),getNewpassword());
		if(boo == true){
			System.out.println("修改成功");
			changeResult = "密码修改成功!";
			return SUCCESS;
		}else{
			System.out.println("修改失败!!!");
			changeResult = "输入的原密码有误！请重新输入！";
			return ERROR;
		}	
	}
	
	//admin 修改密码验证
	public void validateChangeAdminPs(){
		if(oldpassword.trim().equals(null) || oldpassword.trim().equals("")){
			addFieldError("oldnull", "原密码不能为空！");
		}else{
			if(newpassword.trim().equals(null) || newpassword.trim().equals("")){
				addFieldError("newnull", "新密码不能为空！");
			}else{
				if(renewpassword.trim().equals(null) || renewpassword.trim().equals("") || !renewpassword.trim().equals(newpassword)){
					 addFieldError("final", "两次密码输入不一致！请重新输入！");
				}
			}
		}
	}
	
	//修改admin密码
	@Action(value = "changeAdminPassword", 
			interceptorRefs = {
			@InterceptorRef(value="AdminLoginCheck")},
			results = { @Result(name = "error", location = "/admin/changeadminps.jsp"),
			            @Result(name = "input", location = "/admin/changeadminps.jsp"),
	                    @Result(name = "success", location="/admin/adminhomepage.jsp")}//有拦截器可以使用  type="chain"
	)
	public String changeAdminPs() throws Exception{
		System.out.println("更改管理员密码");
		Map<String, Object> session = ActionContext.getContext().getSession();
		System.out.println("11111111111"+(String)session.get("adminID"));//获得当前session
	    String aid = (String) session.get("adminID");
		boolean boo = new SelectCoursesService().changeAdminPs(aid,getOldpassword(),getNewpassword());
		if(boo == true){
			System.out.println("admin修改成功");
			changeResult = "管理员密码修改成功!";
			return SUCCESS;
		}else{
			System.out.println("admin修改失败!!!");
			changeResult = "输入的原密码有误！请重新输入！";
			return ERROR;
		}	
	}
}
