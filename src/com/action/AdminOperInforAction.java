package com.action;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.service.SelectCoursesService;
import com.vo.Course;
import com.vo.Department;
import com.vo.Major;
import com.vo.Notice;
import com.vo.Plan;
import com.vo.Suggestion;
import com.vo.Teacher;

@ParentPackage("struts2_selectCourse")
public class AdminOperInforAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Plan plan;
	private Course cou;
	private Teacher teacher;
	private Department depart;
	private Major major;
	private Notice notice;
	private ArrayList<Major> maj;
	private ArrayList<Department> dep;
	private ArrayList<Teacher> tea;
	private ArrayList<Plan> pla;
	private ArrayList<Suggestion> sugg;
	private String planid;
	private String courseid;
	private String studentid;
	private String teacherid;
	private String depid;
	private String majid;
	private String notid;
	private String suggid;
	private String timeForCourseHourB;
	private String timeForCourseMinB;
	private String timeForCourseHourE;
	private String timeForCourseMinE;
	private String errorAdd;//返回的信息
    
	public String getSuggid() {
		return suggid;
	}
	public void setSuggid(String suggid) {
		this.suggid = suggid;
	}
	public ArrayList<Suggestion> getSugg() {
		return sugg;
	}
	public void setSugg(ArrayList<Suggestion> sugg) {
		this.sugg = sugg;
	}
	public Notice getNotice() {
		return notice;
	}
	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	public String getNotid() {
		return notid;
	}
	public void setNotid(String notid) {
		this.notid = notid;
	}
	public String getMajid() {
		return majid;
	}
	public void setMajid(String majid) {
		this.majid = majid;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public String getDepid() {
		return depid;
	}
	public void setDepid(String depid) {
		this.depid = depid;
	}
	public Department getDepart() {
		return depart;
	}
	public void setDepart(Department depart) {
		this.depart = depart;
	}
	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getTimeForCourseHourB() {
		return timeForCourseHourB;
	}
	public void setTimeForCourseHourB(String timeForCourseHourB) {
		this.timeForCourseHourB = timeForCourseHourB;
	}
	public String getTimeForCourseMinB() {
		return timeForCourseMinB;
	}
	public void setTimeForCourseMinB(String timeForCourseMinB) {
		this.timeForCourseMinB = timeForCourseMinB;
	}
	public String getTimeForCourseHourE() {
		return timeForCourseHourE;
	}
	public void setTimeForCourseHourE(String timeForCourseHourE) {
		this.timeForCourseHourE = timeForCourseHourE;
	}
	public String getTimeForCourseMinE() {
		return timeForCourseMinE;
	}
	public void setTimeForCourseMinE(String timeForCourseMinE) {
		this.timeForCourseMinE = timeForCourseMinE;
	}
	public Course getCou() {
		return cou;
	}
	public void setCou(Course cou) {
		this.cou = cou;
	}
	public ArrayList<Department> getDep() {
		return dep;
	}
	public void setDep(ArrayList<Department> dep) {
		this.dep = dep;
	}
	public ArrayList<Teacher> getTea() {
		return tea;
	}
	public void setTea(ArrayList<Teacher> tea) {
		this.tea = tea;
	}
	public ArrayList<Plan> getPla() {
		return pla;
	}
	public void setPla(ArrayList<Plan> pla) {
		this.pla = pla;
	}
	public ArrayList<Major> getMaj() {
		return maj;
	}
	public void setMaj(ArrayList<Major> maj) {
		this.maj = maj;
	}
	public String getPlanid() {
		return planid;
	}
	public void setPlanid(String planid) {
		this.planid = planid;
	}
	public String getErrorAdd() {
		return errorAdd;
	}
	public void setErrorAdd(String errorAdd) {
		this.errorAdd = errorAdd;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	
	//admin添加培养方案验证
	public void validateAddPlan(){
		if(this.plan.getPlanName().trim().equals(null) || this.plan.getPlanName().trim().equals("")){
			addFieldError("plannamenull", "培养计划信息不完整！");
		}
	}

	// admin添加培养计划
	@Action(value = "addplan",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success",type="chain", location = "adminfindAllPlans"),
			            @Result(name = "input", location = "/admin/adminvalidateerror.jsp"),
			            @Result(name = "error", location = "/admin/addplan.jsp")}
	)
	public String addPlan() throws Exception {
		System.out.println("admin添加培养计划");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 获得当前系统时间
		String time = sdf.format(new Date());// 转换为String
		System.out.println(time.substring(0, 4));// 年
		System.out.println(time.substring(5, 7));// 月
		System.out.println(time.substring(8, 10));// 日
		System.out.println(time.substring(11, 13));// 时
		System.out.println(time.substring(14, 16));// 分
		System.out.println(time.substring(17, 19));//秒	
		System.out.println(time);
        //获取planID
		plan.setPlanID(time.substring(0, 4) + time.substring(5, 7)
				+ time.substring(8, 10)+time.substring(11, 13)+time.substring(14, 16)+time.substring(17, 19));
		//获取timeForPlan
		String date = time.substring(0, 10);//yyyy-MM-dd
		boolean boo = false;
		
		boo = new SelectCoursesService().addPlan(plan.getPlanID(), plan
				.getPlanName(), plan.getType(), plan.getMajID(), plan
				.getDegree(), plan.getEduLevel(), plan.getDirection(), plan
				.getMinCredit(), date);
		if (boo == true) {
			errorAdd = "添加成功！";
			return SUCCESS;
		} else {
			errorAdd ="添加失败！请重试！";
			return ERROR;
		}
	}
	
	//admin发送planid并且查找专业
	@Action(value = "sendplanid",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", location = "/admin/updateplan.jsp")}
	)
	public String sendPlanID() throws Exception{
		this.planid = getPlanid();
		this.maj = new SelectCoursesService().findALLMaj();
		return SUCCESS;
	}
	
	//
	public void validateUpdatePlan(){
		if(this.plan.getPlanName().trim().equals(null) || this.plan.getPlanName().trim().equals("")){
			addFieldError("plannamenull2", "培养计划信息不完整！");
		}
	}
	
	//admin修改培养计划
	@Action(value = "updatePlan",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			 results = { @Result(name = "success", type="chain",location = "adminfindAllPlans"),
			             @Result(name = "input", location = "/admin/adminvalidateerror.jsp"),
			             @Result(name="error", type="chain",location = "adminfindAllPlans")}
	)
	public String updatePlan() throws Exception{
		System.out.println(this.plan.getPlanID());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 获得当前系统时间
		String time = sdf.format(new Date());// 转换为String
		String date = time.substring(0, 10);
		boolean boo = new SelectCoursesService().updatePlan(this.plan,date);
		if(boo == true){
			errorAdd = "修改成功！";
			return SUCCESS;
		}else{
			errorAdd = "修改失败";
			return ERROR;
		}	
	}
	
	//admin删除培养计划
	@Action(value = "deleteplan",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", type="chain",location = "adminfindAllPlans"),
			            @Result(name="error", type="chain",location = "adminfindAllPlans")}
	)
	public String deletePlan() throws Exception{
		System.out.println(this.planid);
		boolean boo = false;
		boo = new SelectCoursesService().deletePlan(this.planid);
		if(boo == true){
			errorAdd = "删除成功！";
			return SUCCESS;
		}else{
			errorAdd = "删除失败！请检查该培养计划下是否有课程！";
			return ERROR;
		}	
	}
	
	//admin添加课程之前对dep tea plan maj的查找
	@Action(value = "findDepTeaPlan",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", location = "/admin/addcourse.jsp"),
	                    @Result(name = "error", location = "/admin/allcourses.jsp")}
	)
	public String findDepTeaPlan() throws Exception{
		//查找学院
		this.dep = new SelectCoursesService().findALLDep();
		//查找教师
		this.tea = new SelectCoursesService().findALLTeacher();
		//查找培养方案
		this.pla = new SelectCoursesService().findAllPlans();
		//查找专业
		this.maj = new SelectCoursesService().findALLMaj();
		if(this.dep == null || this.tea == null || this.pla == null || this.maj == null){
			System.out.println("101010101010");
			errorAdd = "没有学院，教师，专业或者培养方案的信息，请先添加必要的学院，教师或者培养方案信息后再添加课程！";
			return ERROR;
		}
		return SUCCESS;
	}
	
	//admin添加课程验证
	public void validateAddcourse(){
		if(this.cou.getCourseName().trim().equals(null) || this.cou.getCourseName().trim().equals("")){
			addFieldError("coursenull", "课程信息不完整！");
		}
	}
	
	//admin添加课程
	@Action(value = "addcourse",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", type="chain", location = "adminfindAllCourses"),
			            @Result(name = "input",  location = "/admin/adminvalidateerror.jsp"),
			            @Result(name = "error", location = "/admin/addcourse.jsp") }
	)
	public String addcourse() throws Exception{
		System.out.println("addcoursessssssssss");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 获得当前系统时间
		String time = sdf.format(new Date());// 转换为String
		System.out.println(time.substring(0, 4));// 年
		System.out.println(time.substring(5, 7));// 月
		System.out.println(time.substring(8, 10));// 日
		System.out.println(time.substring(11, 13));// 时
		System.out.println(time.substring(14, 16));// 分
		System.out.println(time.substring(17, 19));//秒	
		System.out.println(time);
        //获取courseID
		cou.setCourseID(time.substring(0, 4) + time.substring(5, 7)
				+ time.substring(8, 10)+time.substring(11, 13)
				+ time.substring(14, 16)+time.substring(17, 19));
		//获取timeForCourse
		cou.setTimeForCourse(getTimeForCourseHourB()+":"+getTimeForCourseMinB()+" ~ "+getTimeForCourseHourE()+":"+getTimeForCourseMinE());
		boolean boo = false;
		boo = new SelectCoursesService().addcourse(this.cou);
		if(boo == true){
			errorAdd = "课程添加成功！";
			return SUCCESS;
		}else{
			errorAdd = "课程添加失败！";
			return ERROR;
		}	
	}
	
	//admin发送courseid并且查找学院 教师 培养计划
	@Action(value = "sendcourseid",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", location = "/admin/updatecourse.jsp")}
	)
	public String sendCourseID() throws Exception{
		this.courseid = getCourseid();
		System.out.println(this.courseid+"56565656565656565656");
		//查找学院
		this.dep = new SelectCoursesService().findALLDep();
		//查找教师
		this.tea = new SelectCoursesService().findALLTeacher();
		//查找培养方案
		this.pla = new SelectCoursesService().findAllPlans();
		//查找专业
		this.maj = new SelectCoursesService().findALLMaj();
		return SUCCESS;
	}
	

	//admin添加课程验证
	public void validateUpdateCourse(){
		System.out.println("12312312312312");
		if(this.cou.getCourseName().trim().equals(null) || this.cou.getCourseName().trim().equals("")){
			addFieldError("coursenull2", "课程信息不完整！");
		}
	}
	
	//admin修改课程信息
	@Action(value = "updatecourse",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", type="chain",location = "adminfindAllCourses"),
			            @Result(name = "input",  location = "/admin/adminvalidateerror.jsp"),
			            @Result(name = "error", location = "/admin/updatecourse.jsp")}
	)
	public String updateCourse() throws Exception{
		System.out.println(this.cou.getCourseID());
		boolean boo = false; 
		cou.setTimeForCourse(getTimeForCourseHourB()+":"+getTimeForCourseMinB()+" ~ "+getTimeForCourseHourE()+":"+getTimeForCourseMinE());
		boo = new SelectCoursesService().updateCourse(this.cou);
		if(boo == true){
			errorAdd = "修改成功！";
			return SUCCESS;
		}else{
			errorAdd = "修改失败";
			return ERROR;
		}	
	}
	
	//admin删除课程
	@Action(value = "deletecourse",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", type="chain",location = "adminfindAllCourses"),
			            @Result(name="error", type="chain",location = "adminfindAllCourses")}
	)
	public String deleteCourse() throws Exception{
		System.out.println(this.courseid);
		boolean boo = false;
		boo = new SelectCoursesService().deleteCourse(this.courseid);
		if(boo == true){
			errorAdd = "删除成功！";
			return SUCCESS;
		}else{
			errorAdd = "删除失败！";
			return ERROR;
		}	
	}
	
	// 学生修改个人信息前 发送studentid并且查找学院 专业 
	@Action(value = "sendstudentid",
			interceptorRefs = { @InterceptorRef(value = "LoginCheck") }, 
			results = { @Result(name = "success", location = "/admin/updatecourse.jsp")}
	)
	public String sendStudentID() throws Exception{
		this.courseid = getCourseid();
		System.out.println(this.studentid+"56565656565656565656");
		//查找学院
		this.dep = new SelectCoursesService().findALLDep();
		//查找教师
		this.tea = new SelectCoursesService().findALLTeacher();
		//查找培养方案
		this.pla = new SelectCoursesService().findAllPlans();
		return SUCCESS;
	}
	
	//admin删除学生
	@Action(value = "deletestudent",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", type="chain",location = "adminfindAllStudents"),
			            @Result(name="error", type="chain",location = "adminfindAllStudents")}
	)
	public String deleteStudent() throws Exception{
		System.out.println(this.courseid);
		boolean boo = false;
		boo = new SelectCoursesService().deleteStudent(this.studentid);
		if(boo == true){
			errorAdd = "删除成功！";
			return SUCCESS;
		}else{
			errorAdd = "删除失败！";
			return ERROR;
		}	
	}
	
	//admin添加教师信息之前对dep的查找
	@Action(value = "findDepForAdmin",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", location = "/admin/addteacher.jsp"),
	                    @Result(name = "error", location = "/admin/allteachers.jsp")}
	)
	public String findDepForAdmin() throws Exception{
		//查找学院
		this.dep = new SelectCoursesService().findALLDep();
		if(this.dep == null){
			errorAdd = "没有必要的学院信息！无法添加教师！";
			return ERROR;
		}
		return SUCCESS;
	}
	
	//admin添加教师验证
	public void validateAddTeacher(){
		if(this.teacher.getTeacherName().trim().equals(null) || this.teacher.getTeacherName().trim().equals("")){
			addFieldError("teanamenull", "教师姓名不能为空！");
		}else{
			if(this.teacher.getTeaTeleNum().trim().equals(null) || this.teacher.getTeaTeleNum().trim().equals("")){
				addFieldError("teatelenull", "教师手机号不能为空！");
			}else{
				if(this.teacher.getTeaEmail().trim().equals(null) || this.teacher.getTeaEmail().trim().equals("")){
					addFieldError("teaemailnull", "教师邮箱不能为空！");
				}
			}
		}
		
	}
	
	//admin添加教师
	@Action(value = "addteacher",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", type="chain", location = "adminfindAllTeachers"),
			            @Result(name = "input",  location = "/admin/adminvalidateerror.jsp"),
			            @Result(name = "error", location = "/admin/addteacher.jsp") }
	)
	public String addTeacher() throws Exception{
		System.out.println("addTeacher");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 获得当前系统时间
		String time = sdf.format(new Date());// 转换为String
		System.out.println(time.substring(14, 16));// 分
		System.out.println(time.substring(17, 19));//秒	
		System.out.println(time);
        //获取teacherID(10位)
		this.teacher.setTeacherID(this.teacher.getDepID()+time.substring(14, 16)+time.substring(17, 19));
		boolean boo = false;
		boo = new SelectCoursesService().addTeacher(this.teacher);
		if(boo == true){
			errorAdd = "教师信息添加成功！";
			return SUCCESS;
		}else{
			errorAdd = "教师信息添加失败！";
			return ERROR;
		}	
	}
	
	// admin修改教师信息前 发送teacherid并且查找学院
	@Action(value = "sendteacherid",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", location = "/admin/updateteacher.jsp")}
	)
	public String sendTeacherID() throws Exception{
		this.teacherid = getTeacherid();
		//查找学院
		this.dep = new SelectCoursesService().findALLDep();
		return SUCCESS;
	}
	
	//admin修改教师信息验证
	public void validateUpdateTeacher(){
		if(this.teacher.getTeacherName().trim().equals(null) || this.teacher.getTeacherName().trim().equals("")){
			addFieldError("teanamenull", "教师姓名不能为空！");
		}else{
			if(this.teacher.getTeaTeleNum().trim().equals(null) || this.teacher.getTeaTeleNum().trim().equals("")){
				addFieldError("teatelenull", "教师手机号不能为空！");
			}else{
				if(this.teacher.getTeaEmail().trim().equals(null) || this.teacher.getTeaEmail().trim().equals("")){
					addFieldError("teaemailnull", "教师邮箱不能为空！");
				}
			}
		}
	}
	
	
	//admin修改教师信息
	@Action(value = "updateteacher",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", type="chain",location = "adminfindAllTeachers"),
			            @Result(name = "input", location = "/admin/adminvalidateerror.jsp"),
			            @Result(name = "error", location = "/admin/updateteacher.jsp")}
	)
	public String updateTeacher() throws Exception{
		System.out.println("updateTeacher");
		boolean boo = false; 
		boo = new SelectCoursesService().updateTeacher(this.teacher);
		if(boo == true){
			errorAdd = "修改成功！";
			return SUCCESS;
		}else{
			errorAdd = "修改失败";
			return ERROR;
		}	
	}
	
	//admin删除教师
	@Action(value = "deleteteacher",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", type="chain",location = "adminfindAllTeachers"),
			            @Result(name="error", type="chain",location = "adminfindAllTeachers")}
	)
	public String deleteTeacher() throws Exception{
		System.out.println(this.teacherid);
		boolean boo = false;
		boo = new SelectCoursesService().deleteTeacher(this.teacherid);
		if(boo == true){
			errorAdd = "删除成功！";
			return SUCCESS;
		}else{
			errorAdd = "删除失败！请检查该教师是否有任课记录，若有请先删除该课程，再删除该教师！";
			System.out.println(errorAdd);
			return ERROR;
		}	
	}

	//admin 添加学院验证
	public void validateAddDep(){
		if(this.depart.getDepName().trim().equals(null) || this.depart.getDepName().trim().equals("")){
			addFieldError("depnull", "学院名称不能为空！");
		}
	}
	
	//admin添加学院
	@Action(value = "adddep",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
		 	results = { @Result(name = "success", type="chain", location = "adminfindAllDeps"),
			            @Result(name = "input", location = "/admin/adminvalidateerror.jsp"),
			            @Result(name = "error", type="chain", location = "adminfindAllDeps") }
	)
	public String addDep() throws Exception{
		System.out.println("addDep");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 获得当前系统时间
		String time = sdf.format(new Date());// 转换为String
		System.out.println(time.substring(11, 13));// 时
		System.out.println(time.substring(14, 16));// 分
		System.out.println(time.substring(17, 19));//秒	
		System.out.println(time);
        //获取depID(6位)
		this.depart.setDepID(time.substring(11, 13)+time.substring(14, 16)+time.substring(17, 19));
		boolean boo = false;
		boo = new SelectCoursesService().addDep(this.depart);
		if(boo == true){
			errorAdd = "学院信息添加成功！";
			return SUCCESS;
		}else{
			errorAdd = "学院信息添加失败！";
			return ERROR;
		}	
	}
	
	// admin修改学院信息前 发送depid
	@Action(value = "senddepid",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", location = "/admin/updatedep.jsp")}
	)
	public String sendDepID() throws Exception{
		this.depid = getDepid();
		return SUCCESS;
	}
	
	//admin修改学院验证
	public void validateUpdateDep(){
		if(this.depart.getDepName().trim().equals(null) || this.depart.getDepName().trim().equals("")){
			addFieldError("depnull2", "学院名称不能为空！");
		}
	}
	
	//admin修改学院信息
	@Action(value = "updateDep",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", type="chain",location = "adminfindAllDeps"),
			            @Result(name = "input", location = "/admin/adminvalidateerror.jsp"),
			            @Result(name = "error", location = "adminfindAllDeps")}
	)
	public String updateDep() throws Exception{
		System.out.println("updateDep");
		boolean boo = false; 
		boo = new SelectCoursesService().updateDep(this.depart);
		if(boo == true){
			errorAdd = "修改成功！";
			return SUCCESS;
		}else{
			errorAdd = "修改失败";
			return ERROR;
		}	
	}

	//admin删除学院
	@Action(value = "deletedep",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", type="chain",location = "adminfindAllDeps"),
			            @Result(name="error", type="chain",location = "adminfindAllDeps")}
	)
	public String deleteDep() throws Exception{
		System.out.println(this.depid);
		boolean boo = false;
		boo = new SelectCoursesService().deleteDep(this.depid);
		if(boo == true){
			errorAdd = "删除成功！";
			return SUCCESS;
		}else{
			errorAdd = "删除失败！请检查该学院下属是否有学生，专业或者教师！";
			return ERROR;
		}	
	}
	
	//admin添加专业信息之前对dep的查找
	@Action(value = "findDepForAdminAddMaj",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", location = "/admin/addmaj.jsp"),
	                    @Result(name = "error", location = "/admin/allmajs.jsp")}
	)
	public String findDepForAdminAddMaj() throws Exception{
		this.dep = new SelectCoursesService().findALLDep();
		if(this.dep == null){
			errorAdd = "没有必要的学院信息，无法添加专业！";
			return ERROR;
		}
		return SUCCESS;
	}
	
	//admin添加专业验证
	public void validateAddMaj(){
		if(this.major.getMajorName().trim().equals(null) || this.major.getMajorName().trim().equals("")){
	         addFieldError("majnull", "专业名称不能为空！");
	 }	
	}
	
	//admin添加专业
	@Action(value = "addmaj",
			interceptorRefs = { 
			            @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success",type="chain", location = "adminfindAllMajs"),
                        @Result(name = "error",type="chain" ,location = "adminfindAllMajs"),
                        @Result(name = "input", location = "/admin/adminvalidateerror.jsp")}                    
    )
	public String addMaj() throws Exception{
		System.out.println("addMaj");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 获得当前系统时间
		String time = sdf.format(new Date());// 转换为String
        //获取majID(8位)
		this.major.setMajID(this.major.getDepID() + time.substring(17, 19));
		boolean boo = false;
		boo = new SelectCoursesService().addMaj(this.major);
		if(boo == true){
			errorAdd = "专业信息添加成功！";
			return SUCCESS;
		}else{
			errorAdd = "专业信息添加失败！";
			return ERROR;
		}	
	}
	
	//admin删除学院
	@Action(value = "deletemaj",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", type="chain",location = "adminfindAllMajs"),
			            @Result(name="error", type="chain",location = "adminfindAllMajs")}
	)
	public String deleteMaj() throws Exception{
		System.out.println(this.depid);
		boolean boo = false;
		boo = new SelectCoursesService().deleteMaj(this.majid);
		if(boo == true){
			errorAdd = "删除成功！";
			return SUCCESS;
		}else{
			errorAdd = "删除失败！请检查该专业下是否有学生或者培养计划！";
			return ERROR;
		}	
	}
	
	// admin修改专业信息前 发送majid并且查找学院
	@Action(value = "sendmajid",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", location = "/admin/updatemaj.jsp")}
	)
	public String sendMajID() throws Exception{
		this.majid = getMajid();
		this.dep = new SelectCoursesService().findALLDep();
		return SUCCESS;
	}
	
	//admin修改专业验证
	public void validateUpdateMaj(){
		if(this.major.getMajorName().trim().equals(null) || this.major.getMajorName().trim().equals("")){
			addFieldError("majnull2", "专业名称不能为空！");
		}
	}
	
	//admin修改专业信息
	@Action(value = "updateMaj",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", type="chain",location = "adminfindAllMajs"),
			            @Result(name = "input", location = "/admin/adminvalidateerror.jsp"),
			            @Result(name = "error", location = "adminfindAllMajs")}
	)
	public String updateMaj() throws Exception{
		System.out.println("updateDep");
		boolean boo = false; 
		boo = new SelectCoursesService().updateMaj(this.major);
		if(boo == true){
			errorAdd = "修改成功！";
			return SUCCESS;
		}else{
			errorAdd = "修改失败";
			return ERROR;
		}	
	}
	
	//admin删除公告
	@Action(value = "deletenot",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", type="chain",location = "adminfindAllNots"),
			            @Result(name="error", type="chain",location = "adminfindAllNots")}
	)
	public String deleteNot() throws Exception{
		System.out.println(this.notid);
		boolean boo = false;
		boo = new SelectCoursesService().deleteNot(this.notid);
		if(boo == true){
			errorAdd = "删除成功！";
			return SUCCESS;
		}else{
			errorAdd = "删除失败！";
			return ERROR;
		}	
	}
	
	//admin添加公告验证
	public void validateAddNotice(){
		if(this.notice.getTitle().trim().equals(null) ||this.notice.getTitle().trim().equals("")){
			addFieldError("noticetitilenull", "公告题目不能为空！");
		}else{
			if(this.notice.getContent().trim().equals(null) ||this.notice.getContent().trim().equals("")){
				addFieldError("noticecontentnull", "公告内容不能为空！");
			}
		}
	}
	
    //admin添加公告
	@Action(value = "addnotice",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", type="chain", location = "adminfindAllNots"),
		             	@Result(name = "input",  location = "/admin/adminvalidateerror.jsp"),
			            @Result(name = "error", type="chain", location = "adminfindAllNots") }
	)
	public String addNotice() throws Exception{
		System.out.println("addNotice");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 获得当前系统时间
		String time = sdf.format(new Date());// 转换为String
        System.out.println(time);
		//获取majID(14位)	
		this.notice.setNoticeID(time.substring(0, 4) + time.substring(5, 7)
				+ time.substring(8, 10)+time.substring(11, 13)
				+ time.substring(14, 16)+time.substring(17, 19));
		//String 型的timeOfNotice
		String date = time.substring(0, 4)+"-"+time.substring(5, 7)+"-"+time.substring(8, 10)+" "
		             +time.substring(11, 13)+":"+time.substring(14, 16)+":"+time.substring(17, 19);
		this.notice.setTimeOfNotice(date);
		System.out.println(date);
		boolean boo = false;
		boo = new SelectCoursesService().addNotice(this.notice);
		if(boo == true){
			errorAdd = "公告信息添加成功！";
			return SUCCESS;
		}else{
			errorAdd = "公告信息添加失败！";
			return ERROR;
		}	
	}

	//admin修改公告验证
	public void validateUpdateNotice(){
		if(this.notice.getTitle().trim().equals(null) ||this.notice.getTitle().trim().equals("")){
			addFieldError("noticetitilenull", "公告题目不能为空！");
		}else{
			if(this.notice.getContent().trim().equals(null) ||this.notice.getContent().trim().equals("")){
				addFieldError("noticecontentnull", "公告内容不能为空！");
			}
		}
	}
	
	//admin修改公告信息
	@Action(value = "updatenotice",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = {  @Result(name = "success", type="chain",location = "adminfindAllNots"),
			             @Result(name = "input", location = "/admin/adminvalidateerror.jsp"),
			             @Result(name = "error", location = "adminfindAllNots")}
	)
	public String updateNotice() throws Exception{
		System.out.println("updateDep");
		boolean boo = false; 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 获得当前系统时间
		String time = sdf.format(new Date());// 转换为String
		//String 型的timeOfNotice
		String date = time.substring(0, 4)+"-"+time.substring(5, 7)+"-"+time.substring(8, 10)+" "
		             +time.substring(11, 13)+":"+time.substring(14, 16)+":"+time.substring(17, 19);
		this.notice.setTimeOfNotice(date);
		boo = new SelectCoursesService().updateNotice(this.notice);
		if(boo == true){
			errorAdd = "修改成功！";
			return SUCCESS;
		}else{
			errorAdd = "修改失败";
			return ERROR;
		}	
	}
	
	//admin查看所有学生意见反馈
	@Action(value = "adminfindAllSuggs",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", location = "/admin/allsuggs.jsp"),
			            @Result(name = "error", location = "/admin/allsuggs.jsp")}
	)
	public String adminFindAllSuggs() throws Exception{
		 System.out.println("adminfindAllSuggs");
		 this.sugg = new SelectCoursesService().adminFindAllSuggs();
		 if(this.sugg == null){
			 errorAdd = "当前没有任何学生反馈！";
			 return ERROR;
		 }else{
			 return SUCCESS;
		 }	
	}

	//admin删除学生意见反馈
	@Action(value = "deletesugg",
			interceptorRefs = { @InterceptorRef(value = "AdminLoginCheck") }, 
			results = { @Result(name = "success", type="chain", location = "adminfindAllSuggs"),
			            @Result(name = "error", type="chain", location = "adminfindAllSuggs")}
	)
	public String deleteSugg() throws Exception{
		 System.out.println("adminfindAllSuggs");
		 boolean boo = false;
		 boo = new SelectCoursesService().deleteSugg(this.suggid);
		 if(boo == true){
			 errorAdd = "删除成功！";
			 return SUCCESS;
		 }else{
			 errorAdd = "删除失败！";
			 return ERROR;
		 }	
	}
	
}
