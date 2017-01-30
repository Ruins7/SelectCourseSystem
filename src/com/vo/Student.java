package com.vo;

import java.sql.Date;


public class Student {
       private String studentID = null;
       private String password = null;
       private String studentName;
       private String sex;
       private String department;//学院
       private String depID;
       private String major;//专业
       private String majID;
       private String yearEnter;//入学年份
       private String classes;//班级
       private String direction;//方向
       private String qq;
       private String stuTeleNum;
       private String stuEmail;
       private String idCardNum;//身份证号
       private Date birthday;
       private String eduLevel;//培养层次（专科，本科，研究生）
       private String photo;
       private String s1;
       private String s2;
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDepID() {
		return depID;
	}
	public void setDepID(String depID) {
		this.depID = depID;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getMajID() {
		return majID;
	}
	public void setMajID(String majID) {
		this.majID = majID;
	}
	public String getYearEnter() {
		return yearEnter;
	}
	public void setYearEnter(String yearEnter) {
		this.yearEnter = yearEnter;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getStuTeleNum() {
		return stuTeleNum;
	}
	public void setStuTeleNum(String stuTeleNum) {
		this.stuTeleNum = stuTeleNum;
	}
	public String getStuEmail() {
		return stuEmail;
	}
	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}
	public String getIdCardNum() {
		return idCardNum;
	}
	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEduLevel() {
		return eduLevel;
	}
	public void setEduLevel(String eduLevel) {
		this.eduLevel = eduLevel;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getS1() {
		return s1;
	}
	public void setS1(String s1) {
		this.s1 = s1;
	}
	public String getS2() {
		return s2;
	}
	public void setS2(String s2) {
		this.s2 = s2;
	}
	public Student() {
		
	}
	public Student(String studentID, String password, String studentName,
			String sex, String department, String depID, String major,
			String majID, String yearEnter, String classes, String direction,
			String qq, String stuTeleNum, String stuEmail, String idCardNum,
			Date birthday, String eduLevel, String photo, String s1, String s2) {
		super();
		this.studentID = studentID;
		this.password = password;
		this.studentName = studentName;
		this.sex = sex;
		this.department = department;
		this.depID = depID;
		this.major = major;
		this.majID = majID;
		this.yearEnter = yearEnter;
		this.classes = classes;
		this.direction = direction;
		this.qq = qq;
		this.stuTeleNum = stuTeleNum;
		this.stuEmail = stuEmail;
		this.idCardNum = idCardNum;
		this.birthday = birthday;
		this.eduLevel = eduLevel;
		this.photo = photo;
		this.s1 = s1;
		this.s2 = s2;
	}
	   
}
