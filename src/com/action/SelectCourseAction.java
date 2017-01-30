package com.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SelectCoursesService;
import com.vo.Course;

@ParentPackage("struts2_selectCourse")
public class SelectCourseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ArrayList<Course> course;
	private String courseid;// 要选的课程id
	private String time;// 上课时间
	private String level;// 当前选课阶段
	private String currentnum;// 当前已选人数
	private String max;// 当前课程最大人数
	private String message;
	private String messagesele;
	private String messagetime;
	private String messagesuccess;
	private String messagemax;
	private String messagethird;
	private Map<String, Short> currentNum;
	Map<String, Object> session = ActionContext.getContext().getSession();
	
	public String getMessagethird() {
		return messagethird;
	}

	public void setMessagethird(String messagethird) {
		this.messagethird = messagethird;
	}

	public String getMessagemax() {
		return messagemax;
	}

	public void setMessagemax(String messagemax) {
		this.messagemax = messagemax;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getCurrentnum() {
		return currentnum;
	}

	public void setCurrentnum(String currentnum) {
		this.currentnum = currentnum;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Map<String, Short> getCurrentNum() {
		return currentNum;
	}

	public void setCurrentNum(Map<String, Short> currentNum) {
		this.currentNum = currentNum;
	}

	public String getMessagetime() {
		return messagetime;
	}

	public void setMessagetime(String messagetime) {
		this.messagetime = messagetime;
	}

	public String getMessagesele() {
		return messagesele;
	}

	public void setMessagesele(String messagesele) {
		this.messagesele = messagesele;
	}

	public String getMessagesuccess() {
		return messagesuccess;
	}

	public void setMessagesuccess(String messagesuccess) {
		this.messagesuccess = messagesuccess;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<Course> getCourse() {
		return course;
	}

	public void setCourse(ArrayList<Course> course) {
		this.course = course;
	}

	// student 通过个人信息对所有课程进行筛选(条件：培养层次，专业，年级)
	@Action(value = "findcoursebystu", interceptorRefs = { @InterceptorRef(value = "LoginCheck") }, results = {
			@Result(name = "success", location = "/student/selectcourse.jsp"),
			@Result(name = "error", location = "/student/selectcourse.jsp") })
	public String selectSourse() throws Exception {
		System.out.println("selectSourse");
		// 查看当前所有选课记录，统计各门课程选课人数
		this.currentNum = new SelectCoursesService().findCurrentNum();
		// 对map的遍历
		for (String s : currentNum.keySet()) {
			System.out.println(s + "----" + currentNum.get(s));
		}
		session.get("yearEnter");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 获得当前系统时间
		String time = sdf.format(new Date());// 转换为String
		String i = time.substring(0, 4);
		String k = time.substring(5, 7);
		String j = (String) session.get("yearEnter");
		int a = Integer.parseInt(i);
		int b = Integer.parseInt(j);
		int d = Integer.parseInt(k);
		int c;
		if (d >= 9) {
			c = a - b + 1;
		} else {
			c = a - b;
		}
		String grade = Integer.toString(c);
		System.out.println(grade);
		if (grade.equals("1")) {
			grade = "一年级";
		} else if (grade.equals("2")) {
			grade = "二年级";
		} else if (grade.equals("3")) {
			grade = "三年级";
		} else if (grade.equals("4")) {
			grade = "四年级";
		}
		System.out.println(grade);
		// 通过学生的专业，年级，培养层次先进行筛选
		this.course = new SelectCoursesService().findCoursebystu(
				(String) session.get("major"), grade, (String) session
						.get("eduLevel"));
		if(this.course == null){
			message = "没有符合条件的课程！请联系管理员!";
			System.out.println(message);
			return ERROR;
		}else{
			// 将查找好的当前已选人数赋值给课程信息
			for (int q = 0; q < this.course.size(); q++) {// 筛选出的课程
				for (String s : currentNum.keySet()) {
					if (this.course.get(q).getCourseID().equals(s)) {
						this.course.get(q).setCurrentNum(currentNum.get(s));
					}
				}
			}
			return SUCCESS;
		}
	}

	// student 选课前发送课程id
	@Action(value = "addcourseid", interceptorRefs = {
			@InterceptorRef(value = "LoginCheck"),
			@InterceptorRef(value = "SelectTimeCheck") },
			results = {
			@Result(name = "havebeenselected", type = "chain", location = "findcoursebystu"),
			@Result(name = "timenotfit", type = "chain", location = "findcoursebystu"),
			@Result(name = "success", type = "chain", location = "findcoursebystu") ,
			@Result(name = "beyond", type = "chain", location = "findcoursebystu") ,
			@Result(name = "third", type = "chain", location = "findcoursebystu"),
			@Result(name = "error", type = "chain", location = "findcoursebystu") }
	)
	public String addCourseID() throws Exception {
		System.out.println("addCourseID");
		System.out.println(getCourseid());
		System.out.println(session.get("studentID"));
		boolean boo = false;
		boolean time = false;
		boolean re = false;
		String result = null;
		message = null;
		// 选课阶段在此判断！
		String n = getLevel().trim();
		System.out.println(n.equals("第一阶段"));
		if (n.equals("第一阶段")) {
			System.out.println("第一阶段");
			// 可选 可超
			// 检查是否已选该课程
			boo = new SelectCoursesService().checkSeletced(getCourseid(),
					(String) session.get("studentID"));
			if (boo == false) {// 已选
				messagesele = "您已选此课程！不能重复选择！";
				System.out.println(messagesele);
				result = "havebeenselected";
			} else {// 未选
				// 判断时间是否冲突
				System.out.println("当前课程时间：  " + getTime());
				time = new SelectCoursesService().checkTime(getTime(),
						(String) session.get("studentID"));
				if (time == false) {
					messagetime = "此课程与已选课程上课时间冲突！不能选择！";
					result = "timenotfit";
				} else {
					// 进行选课
					System.out.println("addCourseID");
					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyyMMddHHmmss");// 获得当前系统时间
					// 选课记录id
					String conseID = sdf.format(new Date());// 转换为String
					// 课程id
					getCourseid();
					// 学生id
					session.get("studentID");
					// pickuptime
					SimpleDateFormat sdf1 = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");// 获得当前系统时间
					String pickuptime = sdf1.format(new Date());// 转换为String
					System.out.println("zzzzzzzzzzzzzzzzz");
					re = new SelectCoursesService().addCourseID(conseID,
							getCourseid(), (String) session.get("studentID"),
							pickuptime);
					if (re == false) {
						message = "选课失败！请联系管理员！";
						result = ERROR;
					} else {
						messagesuccess = "选课成功！";
						result = SUCCESS;
					}
				}
			}
		}else if (n.equals("第二阶段")) {
			System.out.println("第二阶段");
			// 可选 不可超
			// 判断人数是否超过MAX
			getCurrentnum();// 获得当前已选人数
			getMax();// 获得当前课程最大人数
			if(getCurrentnum().trim().equals("")){
				setCurrentnum("0");
			}
			int i = Integer.parseInt(getCurrentnum().trim());
			int j = Integer.parseInt(getMax().trim());
			if (i >= j) {//不能判断！！！
				messagemax = "不可以超过课程最大容量！";
				result = "beyond";
			} else {
				// 检查是否已选该课程
				boo = new SelectCoursesService().checkSeletced(getCourseid(),
						(String) session.get("studentID"));
				if (boo == false) {// 已选
					messagesele = "您已选此课程！不能重复选择！";
					System.out.println(messagesele);
					result = "havebeenselected";
				} else {// 未选
					// 判断时间是否冲突
					System.out.println("当前课程时间：  " + getTime());
					time = new SelectCoursesService().checkTime(getTime(),
							(String) session.get("studentID"));
					if (time == false) {
						messagetime = "此课程与已选课程上课时间冲突！不能选择！";
						result = "timenotfit";
					} else {
						// 进行选课
						System.out.println("addCourseID");
						SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyyMMddHHmmss");// 获得当前系统时间
						// 选课记录id
						String conseID = sdf.format(new Date());// 转换为String
						// 课程id
						getCourseid();
						// 学生id
						session.get("studentID");
						// pickuptime
						SimpleDateFormat sdf1 = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss");// 获得当前系统时间
						String pickuptime = sdf1.format(new Date());// 转换为String
						System.out.println("zzzzzzzzzzzzzzzzz");
						re = new SelectCoursesService().addCourseID(conseID,
								getCourseid(), (String) session
										.get("studentID"), pickuptime);
						if (re == false) {
							message = "选课失败！请联系管理员！";
							result = ERROR;
						} else {
							messagesuccess = "选课成功！";
							result = SUCCESS;
						}
					}

				}
			}
		}else{
		   //不可选 不可超
			System.out.println("第三阶段");
			messagethird = "第三阶段只能退课不可以选课！";
			result = "third";		
		}
		return result;	
	}

	// student 退课前发送课程id
	@Action(value = "deletecourseid", 
			interceptorRefs = { @InterceptorRef(value = "LoginCheck"),
			                    @InterceptorRef(value = "SelectTimeCheck") },
			results = {
			@Result(name = "success", type = "chain", location = "findcoursebystu"),
			@Result(name = "error", type = "chain", location = "findcoursebystu") })
	public String deleteCourseID() throws Exception {
		System.out.println("deleteCourseID");
		getCourseid();
		session.get("studentID");
		boolean boo = false;
		boo = new SelectCoursesService().deleteCourseID(getCourseid(),
				(String) session.get("studentID"));
		if (boo == true) {// 退课成功
			message = "退课成功！";
			return SUCCESS;
		} else {
			message = "退课失败！请联系管理员！";
			return ERROR;
		}
	}

}
