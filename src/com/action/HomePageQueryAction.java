package com.action;

import java.util.ArrayList;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.service.SelectCoursesService;
import com.vo.Course;
import com.vo.Department;
import com.vo.Major;
import com.vo.Student;
import com.vo.Teacher;


@ParentPackage("struts2_selectCourse")
public class HomePageQueryAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String category = null;// 查询的类别（同学，老师，课程）
	private String querycontent = null;// 输入的查询内容
	private ArrayList<Student> student = null;
	private ArrayList<Teacher> teacher = null;
	private ArrayList<Course> course = null;
	private ArrayList<Department> dep = null;
	private ArrayList<Major> maj = null;
	private String homePageNotFound = null;
    
	public ArrayList<Major> getMaj() {
		return maj;
	}

	public void setMaj(ArrayList<Major> maj) {
		this.maj = maj;
	}

	public ArrayList<Department> getDep() {
		return dep;
	}

	public void setDep(ArrayList<Department> dep) {
		this.dep = dep;
	}

	public String getHomePageNotFound() {
		return homePageNotFound;
	}

	public void setHomePageNotFound(String homePageNotFound) {
		this.homePageNotFound = homePageNotFound;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getQuerycontent() {
		return querycontent;
	}

	public void setQuerycontent(String querycontent) {
		this.querycontent = querycontent;
	}

	public ArrayList<Student> getStudent() {
		return student;
	}

	public void setStudent(ArrayList<Student> student) {
		this.student = student;
	}

	public ArrayList<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(ArrayList<Teacher> teacher) {
		this.teacher = teacher;
	}

	public ArrayList<Course> getCourse() {
		return course;
	}

	public void setCourse(ArrayList<Course> course) {
		this.course = course;
	}
	
	//homepageQuery
	@Action(value = "homePageQuery", 
			results = { @Result(name = "error", location = "/student/error.jsp"),
	                    @Result(name = "succstu", location = "/student/resofhpqstu.jsp"),
	                    @Result(name = "succtea", location = "/student/resofhpqtea.jsp"),
	                    @Result(name = "succcou", location = "/student/resofhpqcou.jsp")}
	)
	public String execute() throws Exception {
		String sf = ERROR;
		if(getQuerycontent().equals("")){//输入为空
			System.out.println("空值");
			sf = ERROR;
		}else{
			if (getCategory().equals("同学")) {
				System.out.println("同学");
			    this.student = new SelectCoursesService().homepageQueryStudent(getQuerycontent());
				if (this.student == null) {
					sf = ERROR;
				} else {
					sf = "succstu";
				}
			} else if (getCategory().equals("教师")) {
				System.out.println("教师");
				this.teacher = new SelectCoursesService().homepageQueryTeacher(getQuerycontent());
				if (this.teacher == null) {
					sf = ERROR;
				} else {
					sf = "succtea";
				}
			} else if (getCategory().equals("课程")) {
				System.out.println("课程");
				this.course = new SelectCoursesService().homepageQueryCourse(getQuerycontent());
				System.out.println("here...........");
				if (this.course == null) {
					System.out.println("wrong...........");
					sf = ERROR;
				} else {
					System.out.println("right...........");
					sf = "succcou";
				}
			}
		}	
		homePageNotFound = "啊哦!木有找到唉~~";
		return sf;
	}
	
	//admin查找所有学生
	@Action(value = "adminfindAllStudents",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", location = "/admin/allstudents.jsp"),
			            @Result(name = "error", location = "/admin/adminerror.jsp")}
	)
	public String adminfindAllStudents() throws Exception{
		this.student = new SelectCoursesService().findAllStudnets();
		System.out.println(this.student);
		if (this.student == null) {
			homePageNotFound = "当前没有任何学生注册！";
			return ERROR;
		} else {
			return SUCCESS;
		}
	}
	
	//admin查找所有教师
	@Action(value = "adminfindAllTeachers",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", location = "/admin/allteachers.jsp"),
			            @Result(name = "error", location = "/admin/allteachers.jsp")}
	)
	public String adminfindAllTeachers() throws Exception{
		this.teacher = new SelectCoursesService().findALLTeacher();
		if (this.teacher == null) {
			homePageNotFound = "当前没有任何教师信息！";
			return ERROR;
		} else {
			return SUCCESS;
		}
	}
	
	//admin查找所有学院
	@Action(value = "adminfindAllDeps",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", location = "/admin/alldeps.jsp"),
			@Result(name = "error", location = "/admin/alldeps.jsp")}
	)
	public String adminfindAllDeps() throws Exception{
		this.dep = new SelectCoursesService().findALLDep();
		if (this.dep == null) {
			homePageNotFound = "当前没有任何学院信息！";
			return ERROR;
		} else {
			return SUCCESS;
		}
	}
	
	//admin查找所有专业
	@Action(value = "adminfindAllMajs",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", location = "/admin/allmajs.jsp"),
			@Result(name = "error", location = "/admin/allmajs.jsp")}
	)
	public String adminfindAllMajs() throws Exception{
		this.maj = new SelectCoursesService().findALLMaj();
		if (this.maj == null) {
			homePageNotFound = "当前没有任何专业信息！";
			return ERROR;
		} else {
			return SUCCESS;
		}
	}
}
