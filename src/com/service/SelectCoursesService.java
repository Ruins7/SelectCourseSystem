package com.service;

import java.util.ArrayList;
import java.util.Map;

import com.DAO.SelectCoursesDAO;
import com.IDAO.ISelectCoursesDAO;
import com.vo.Conofselcou;
import com.vo.Course;
import com.vo.Department;
import com.vo.Friend;
import com.vo.Major;
import com.vo.Notice;
import com.vo.Plan;
import com.vo.Student;
import com.vo.Stumess;
import com.vo.Suggestion;
import com.vo.Teacher;


public class SelectCoursesService {

	public ArrayList<Notice> findAllNotice() {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findAllNotice();
	}
	public String findSpecificNotice(String noticeID) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findSpecificNotice(noticeID);
	}
	public ArrayList<Course> findAllCourses() {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findAllCourses();
	}
	public ArrayList<Student> homepageQueryStudent(String querycontent) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.homepageQueryStudent(querycontent);
	}
	public ArrayList<Teacher> homepageQueryTeacher(String querycontent) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.homepageQueryTeacher(querycontent);
	}
	public ArrayList<Course> homepageQueryCourse(String querycontent) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.homepageQueryCourse(querycontent);
	}
	public ArrayList<Department> findALLDep() {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findALLDep();
	}
	public ArrayList<Major> findALLMaj() {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findALLMaj();
	}
	public boolean Signin(Student stu) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.Signin(stu);
	}
	public boolean login(String studentID, String password) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.login(studentID,password);
	}
	public ArrayList<Student> findStuInformation(String studentID) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findStuInformation(studentID);
	}
	public String findPassword(String studentID, String stuEmail) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findPassword(studentID,stuEmail);
	}
	public boolean changePassword(String sid, String oldpassword, String newpassword) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.changePassword(sid,oldpassword,newpassword);
	}
	public ArrayList<Plan> findPlans(String major, String eduLevel) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findPlans(major, eduLevel);
	}
	public ArrayList<Course> findCoursesOfPlan(String planID) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findCoursesOfPlan(planID);
	}
	public boolean adminLogin(String adminID, String password) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.adminLogin(adminID,password);
	}
	public String findAdminPassword(String adminID, String adminEmail) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findAdminPassword(adminID,adminEmail);
	}
	public boolean changeAdminPs(String aid, String oldpassword, String newpassword) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.changeAdminPs(aid,oldpassword,newpassword);
	}
	public ArrayList<Plan> findAllPlans() {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findAllPlans();
	}
	public boolean addPlan(String planID, String planName, String type,
			String majID, String degree, String eduLevel, String direction,
			short minCredit, String date) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.addPlan(planID,planName,type,majID,degree,eduLevel,direction,minCredit, date);
	}
	public boolean updatePlan(Plan plan, String date) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.updatePlan(plan, date);
	}
	public boolean deletePlan(String planid) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.deletePlan(planid);
	}
	public ArrayList<Teacher> findALLTeacher() {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findALLTeacher();
	}
	public boolean addcourse(Course cou) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.addcourse(cou);
	}
	public boolean updateCourse(Course cou) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.updateCourse(cou);
	}
	public boolean deleteCourse(String courseid) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.deleteCourse(courseid);
	}
	public ArrayList<Student> findAllStudnets() {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findAllStudnets();
	}
	public boolean deleteStudent(String studentid) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.deleteStudent(studentid);
	}
	public boolean updateStudent(Student stu) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.updateStudent(stu);
	}
	public boolean addTeacher(Teacher teacher) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.addTeacher(teacher);
	}
	public boolean updateTeacher(Teacher teacher) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.updateTeacher(teacher);
	}
	public boolean deleteTeacher(String teacherid) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.deleteTeacher(teacherid);
	}
	public boolean addDep(Department depart) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.addDep(depart);
	}
	public boolean updateDep(Department depart) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.updateDep(depart);
	}
	public boolean deleteDep(String depid) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.deleteDep(depid);
	}
	public boolean addMaj(Major major) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.addMaj(major);
	}
	public boolean deleteMaj(String majid) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.deleteMaj(majid);
	}
	public boolean updateMaj(Major major) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.updateMaj(major);
	}
	public boolean deleteNot(String notid) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.deleteNot(notid);
	}
	public boolean addNotice(Notice notice) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.addNotice(notice);
	}
	public boolean updateNotice(Notice notice) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.updateNotice(notice);
	}
	public ArrayList<Suggestion> adminFindAllSuggs() {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.adminFindAllSuggs();
	}
	public boolean studentSendSugg(Suggestion sugg) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.studentSendSugg(sugg);
	}
	public boolean deleteSugg(String suggid) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.deleteSugg(suggid);
	}
	public ArrayList<Suggestion> searchSugg(String suggid) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.searchSugg(suggid);
	}
	public boolean replySugg(String replyContent, String replyTime, String suggestionID) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.replySugg(replyContent, replyTime, suggestionID);
	}
	public ArrayList<Suggestion> checkReplySugg(String studentID) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.checkReplySugg(studentID);
	}
	public ArrayList<Course> findCoursebystu(String major, String grade, String eduLevel) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findCoursebystu(major, grade, eduLevel);
	}
	public boolean checkSeletced(String courseid, String studentID) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.checkSeletced(courseid, studentID);
	}
	public boolean addCourseID(String conseID, String Courseid, String studentID, String pickuptime) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.addCourseID(conseID, Courseid, studentID, pickuptime);
	}
	public boolean checkTime(String time, String studentID) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.checkTime(time, studentID);
	}
	public Map<String, Short> findCurrentNum() {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findCurrentNum();
	}
	public boolean deleteCourseID(String courseid, String studentID) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.deleteCourseID(courseid, studentID);
	}
	public ArrayList<Conofselcou> checkSelected(String studentID) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.checkSelected(studentID);
	}
	public ArrayList<ArrayList<Conofselcou>> byTime() {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.byTime();
	}
	public ArrayList<Conofselcou> findAllConse() {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findAllConse();
	}
	public boolean byRandom() {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.byRandom();
	}
	public ArrayList<Stumess> findAllMyMessage(String studentID) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findAllMyMessage(studentID);
	}
	public ArrayList<Friend> findAllMyFriend(String studentID) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findAllMyFriend(studentID);
	}
	public boolean deleteMess(String messageID) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.deleteMess(messageID);
	}
	public boolean addFriendRequest(String messageID, String fromid, String toid, String time) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.addFriendRequest(messageID,fromid,toid,time);
	}
	public ArrayList<Stumess> findAllrequest(String studentID) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findAllrequest(studentID);
	}
	public boolean agreeToAdd(String messageID) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.agreeToAdd(messageID);
	}
	public boolean refuseToAdd(String messageID) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.refuseToAdd(messageID);
	}
	public Student findPersonnalMessage(String sID) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findPersonnalMessage(sID);
	}
	public ArrayList<Conofselcou> findPersonnalCourse(String sID) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findPersonnalCourse(sID);
	}
	public boolean deleteFriend(String beiID, String yaoID) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.deleteFriend(beiID, yaoID);
	}
	public boolean leaveMessage(String beiID, String yaoID, String mid, String time, String content) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.leaveMessage(beiID, yaoID, mid, time, content);
	}
	public ArrayList<Stumess> findAllSPMyMessage(String beiID, String yaoID) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.findAllSPMyMessage(beiID, yaoID);
	}
	public boolean writeReply(String mid, String yaoID, String beiID, String time, String content) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.writeReply(mid, yaoID,  beiID, time,  content);
	}
	public boolean upLoadImg(String sid, String location) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.upLoadImg(sid, location);
	}
	public boolean downloadCourseTable(String sid) {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.downloadCourseTable(sid);
	}
	public boolean downloadConse() {
		ISelectCoursesDAO DAO = new SelectCoursesDAO();
		return DAO.downloadConse();
	}
	
}
