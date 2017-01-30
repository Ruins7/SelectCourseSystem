package com.vo;

public class Conofselcou {
    private String conseID;
    private String courseID;
    private String courseName;
    private Short credit;
    private String classification;
    private String property;
    private String period;
    private String offerDepID;
    private String offerDepart;
    private String timeForCourse;
    private String weekday;
    private String location;
    private String teacherID;
    private String teacherName;
    private String teaEmail;
    private String teaTeleNum;
    private String studentID;
    private String studentName;
    private String department;
    private String stumajID;
    private String stumajorName;
    private String stugrade;
    private String classes;
    private String stuTeleNum;
    private Short pickUp;
    private String pickUpTime;
    private String conse1;
    private String conse2;
	
    public String getWeekday() {
		return weekday;
	}
	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}
	public String getConseID() {
		return conseID;
	}
	public void setConseID(String conseID) {
		this.conseID = conseID;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Short getCredit() {
		return credit;
	}
	public void setCredit(Short credit) {
		this.credit = credit;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getOfferDepID() {
		return offerDepID;
	}
	public void setOfferDepID(String offerDepID) {
		this.offerDepID = offerDepID;
	}
	public String getOfferDepart() {
		return offerDepart;
	}
	public void setOfferDepart(String offerDepart) {
		this.offerDepart = offerDepart;
	}
	public String getTimeForCourse() {
		return timeForCourse;
	}
	public void setTimeForCourse(String timeForCourse) {
		this.timeForCourse = timeForCourse;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeaEmail() {
		return teaEmail;
	}
	public void setTeaEmail(String teaEmail) {
		this.teaEmail = teaEmail;
	}
	public String getTeaTeleNum() {
		return teaTeleNum;
	}
	public void setTeaTeleNum(String teaTeleNum) {
		this.teaTeleNum = teaTeleNum;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStumajID() {
		return stumajID;
	}
	public void setStumajID(String stumajID) {
		this.stumajID = stumajID;
	}
	public String getStumajorName() {
		return stumajorName;
	}
	public void setStumajorName(String stumajorName) {
		this.stumajorName = stumajorName;
	}
	public String getStugrade() {
		return stugrade;
	}
	public void setStugrade(String stugrade) {
		this.stugrade = stugrade;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getStuTeleNum() {
		return stuTeleNum;
	}
	public void setStuTeleNum(String stuTeleNum) {
		this.stuTeleNum = stuTeleNum;
	}
	
	public Short getPickUp() {
		return pickUp;
	}
	public void setPickUp(Short pickUp) {
		this.pickUp = pickUp;
	}
	public String getPickUpTime() {
		return pickUpTime;
	}
	public void setPickUpTime(String pickUpTime) {
		this.pickUpTime = pickUpTime;
	}
	public String getConse1() {
		return conse1;
	}
	public void setConse1(String conse1) {
		this.conse1 = conse1;
	}
	public String getConse2() {
		return conse2;
	}
	public void setConse2(String conse2) {
		this.conse2 = conse2;
	}
	public Conofselcou() {
		
	}
	public Conofselcou(String conseID, String courseID, String courseName,
			Short credit, String classification, String property,
			String period, String offerDepID, String offerDepart,
			String timeForCourse, String location, String teacherID,
			String teacherName, String teaEmail, String teaTeleNum,
			String studentID, String studentName, String department,
			String stumajID, String stumajorName, String stugrade,
			String classes, String stuTeleNum, Short pickUp, String pickUpTime,
			String weekday,
			String conse1, String conse2) {
		super();
		this.conseID = conseID;
		this.courseID = courseID;
		this.courseName = courseName;
		this.credit = credit;
		this.classification = classification;
		this.property = property;
		this.period = period;
		this.offerDepID = offerDepID;
		this.offerDepart = offerDepart;
		this.timeForCourse = timeForCourse;
		this.location = location;
		this.teacherID = teacherID;
		this.teacherName = teacherName;
		this.teaEmail = teaEmail;
		this.teaTeleNum = teaTeleNum;
		this.studentID = studentID;
		this.studentName = studentName;
		this.department = department;
		this.stumajID = stumajID;
		this.stumajorName = stumajorName;
		this.stugrade = stugrade;
		this.classes = classes;
		this.stuTeleNum = stuTeleNum;
		this.pickUp = pickUp;
		this.pickUpTime = pickUpTime;
		this.weekday = weekday;
		this.conse1 = conse1;
		this.conse2 = conse2;
	}
	public Conofselcou(String courseID, String courseName,
			String timeForCourse, String location, String teacherName,
			String teaEmail, String studentID, String studentName,
			Short pickUp, String pickUpTime, Short credit, String weekday) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.credit = credit;
		this.timeForCourse = timeForCourse;
		this.location = location;
		this.teacherName = teacherName;
		this.teaEmail = teaEmail;
		this.studentID = studentID;
		this.studentName = studentName;
		this.pickUp = pickUp;
		this.pickUpTime = pickUpTime;
		this.weekday = weekday;
	}
    
    

}