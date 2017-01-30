package com.action;

import java.util.ArrayList;
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
public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
    private Student stu = null;
    private ArrayList<Student> student = null;
    private Administrator admin = null;
    private String loginNotFound = null;
    Map<String, Object> session = ActionContext.getContext()
	.getSession();

	public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	public ArrayList<Student> getStudent() {
		return student;
	}
	public void setStudent(ArrayList<Student> student) {
		this.student = student;
	}
	public String getLoginNotFound() {
		return loginNotFound;
	}
	public void setLoginNotFound(String loginNotFound) {
		this.loginNotFound = loginNotFound;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	
	//学生登陆
	@Action(value = "login", 
			results = { @Result(name = "error", location = "/student/stulogin.jsp"),
	                    @Result(name = "success", type = "redirect", location = "homepage")}//防止地址栏出现login.action,所以type="redirect"
	)
    public String login() throws Exception{
		System.out.println("登陆");	
		boolean boo = new SelectCoursesService().login(stu.getStudentID(),stu.getPassword());
    	if(boo == false){
    		loginNotFound = "用户名或密码错误！";
    		return ERROR;
    	}else{
    		
    		this.student = new SelectCoursesService().findStuInformation(stu.getStudentID());
	        session.put("studentID", student.get(0).getStudentID());//存放学号
	        session.put("studentName", student.get(0).getStudentName());//存放姓名
	        session.put("department", student.get(0).getDepartment());//存放学院
	        session.put("major", student.get(0).getMajor());//存放专业       
	        session.put("yearEnter", student.get(0).getYearEnter());//存放年级
	        session.put("sex", student.get(0).getSex());//存放性别
	        session.put("classes", student.get(0).getClasses());//存放班级
	        session.put("QQ", student.get(0).getQq());//存放QQ
	        session.put("stuTeleNum", student.get(0).getStuTeleNum());//存放手机号
	        session.put("stuEmail", student.get(0).getStuEmail());//存放邮箱
	        session.put("birthday", student.get(0).getBirthday());//存放生日
	        session.put("eduLevel", student.get(0).getEduLevel());//存放培养层次
	        System.out.println(",,,,,,,,,,,.boo.........."+student.get(0).getPhoto() != null);
	        if(student.get(0).getPhoto() != null){
	        	 session.put("photo", student.get(0).getPhoto().trim());//存放照片  
	        }   
	        session.put("direction", student.get(0).getDirection());//存放方向	 
	        System.out.println("登陆成功");
    		return SUCCESS;
    	}	
    }
	
	//学生退出登陆
	@Action(value = "logout", 
			results = {@Result(name = "success", type="redirect", location="homepage")}
	)
    public String logout() throws Exception{
    	System.out.println("退出登陆");
    	session.clear();
    	return SUCCESS;
    }
	
	//管理员登陆
	@Action(value = "adminLogin", 
			results = { @Result(name = "error", location = "/admin/adminlogin.jsp"),
	                    @Result(name = "success", location="/admin/adminhomepage.jsp")}
	)
	public String adminLogin() throws Exception{
		System.out.println("adminlogin");
		boolean boo = new SelectCoursesService().adminLogin(admin.getAdminID(),admin.getPassword());
		if(boo == false){
    		loginNotFound = "管理员账号或密码错误！";
    		return ERROR;
    	}else{
    		session.put("adminID", admin.getAdminID());//存放管理员的ID
    		return SUCCESS;
    	}
	}
	
	//管理员退出登陆
	@Action(value = "adminlogout", 
			results = {@Result(name = "success", location="/admin/adminlogin.jsp")}
	)
    public String adminLogout() throws Exception{
    	System.out.println("admin退出登陆");
    	session.clear();
		return SUCCESS;
    }

	//检查学生是否登录
	@Action(value = "checkstulogin",
			interceptorRefs = {
			@InterceptorRef(value="LoginCheck")},
			results = {@Result(name = "success", location="/student/sendsugg.jsp")}
	)
	public String checkStuLogin() throws Exception{
		return SUCCESS;	
	}
	
	//检查admin是否登录
	@Action(value = "checkAdminLogin",
			interceptorRefs = {
			@InterceptorRef(value="AdminLoginCheck")},
			results = {@Result(name = "success", location="/admin/changeselectcoursetime.jsp")}
	)
	public String checkAdminLogin() throws Exception{
		System.out.println("admin已登录");
		return SUCCESS;	
	}
}
