package com.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.service.SelectCoursesService;
import com.vo.Administrator;
import com.vo.Student;

public class FindPasswordAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private Student stu;
	private Administrator admin;
	private String notFindPs;
	
	public String getNotFindPs() {
		return notFindPs;
	}
	public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	public void setNotFindPs(String notFindPs) {
		this.notFindPs = notFindPs;
	}
	public Student getStu() {
		return stu;
	}	
	public void setStu(Student stu) {
		this.stu = stu;
	}

	//student 找回密码验证
	public void validateFindpassword(){
		if(this.stu.getStudentID().trim().equals(null) || this.stu.getStudentID().trim().equals("")){
			addFieldError("sidnull", "学号不能为空！");		
		}else{
			if(!this.stu.getStuEmail().contains("@")){
				addFieldError("emailerror", "请填写正确的邮箱地址！");
			}
		} 
		
	}
		
	//学生密码找回
	@Action(value = "findpassword", 
			results = { @Result(name = "error", location = "/student/findpassword.jsp"),
			            @Result(name = "input", location = "/student/findpassword.jsp"),
	                    @Result(name = "success", type="chain", location="homepage")}
	)
	public String findpassword() throws Exception{		
		String ps = new SelectCoursesService().findPassword(stu.getStudentID(), stu.getStuEmail());
		if(ps == null){//输入学号或邮箱错误
			notFindPs = "输入学号或邮箱错误";
			return ERROR;
		}else{
			return SUCCESS;    
		}	
	}
	
	//admin密码找回验证
	public void validateFindadminpassword(){
		if(this.admin.getAdminID().trim().equals(null) || this.admin.getAdminID().trim().equals("")){
			addFieldError("adminidnull", "管理员账号不能为空！");
		}else{
			if(this.admin.getAdminEmail().trim().equals(null) || this.admin.getAdminEmail().trim().equals("")){
				addFieldError("adminemailnull", "管理员邮箱不能为空！");	
			}else{
				if(!this.admin.getAdminEmail().trim().contains("@")){
					addFieldError("emailerror", "请填写正确的邮箱地址！");
				}
			}
		}
	}
	
	//管理员密码找回
	@Action(value = "findadminpassword", 
			results = { @Result(name = "error", location = "/admin/findadminpassword.jsp"),
			            @Result(name = "input", location = "/admin/findadminpassword.jsp"),
	                    @Result(name = "success", location="/admin/adminlogin.jsp")}
	)	
	public String findadminpassword() throws Exception{		
		String ps = new SelectCoursesService().findAdminPassword(admin.getAdminID(), admin.getAdminEmail());
		if(ps == null){//输入学号或邮箱错误
			notFindPs = "输入的管理员账号或管理员邮箱有误!请重新输入！";
			return ERROR;
		}else{
			notFindPs = "密码已发送至该登陆账号的注册邮箱中，请查看后登陆。";
			return SUCCESS;    
		}	
	}
}
