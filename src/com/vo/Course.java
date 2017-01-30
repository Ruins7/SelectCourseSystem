package com.vo;

public class Course {
         private String courseID;
         private String courseName;
         private short credit;//学分
         private String classification;//类别（专业，非专业课）
         private String property;//性质（选修，必修）
         private String period;//学时
         private String offerDepID;//开课单位编号
         private String offerDepart;//开课单位
         private String weekday;
         private String timeForCourse;
         private String location;
         private String teacherID;
         private String teacherName;
         private String teaEmail;
         private String majID;//课程所属专业
         private String majorName;
         private short max;//课程最大容量
         private String planID;
         private String planName;
         private String grade;//针对学生年级
         private String eduLevel;//课程针对培养层次
         private Short currentNum;//当前已选人数
         private String l1;
         private String l2;
         		
		public String getWeekday() {
			return weekday;
		}
		public void setWeekday(String weekday) {
			this.weekday = weekday;
		}
		public Short getCurrentNum() {
			return currentNum;
		}
		public void setCurrentNum(Short currentNum) {
			this.currentNum = currentNum;
		}
		public String getMajID() {
			return majID;
		}
		public void setMajID(String majID) {
			this.majID = majID;
		}
		public String getMajorName() {
			return majorName;
		}
		public void setMajorName(String majorName) {
			this.majorName = majorName;
		}
		public String getEduLevel() {
			return eduLevel;
		}
		public void setEduLevel(String eduLevel) {
			this.eduLevel = eduLevel;
		}
		public String getPlanName() {
			return planName;
		}
		public void setPlanName(String planName) {
			this.planName = planName;
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
		public short getCredit() {
			return credit;
		}
		public void setCredit(short credit) {
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
		public short getMax() {
			return max;
		}
		public void setMax(short max) {
			this.max = max;
		}
		public String getPlanID() {
			return planID;
		}
		public void setPlanID(String planID) {
			this.planID = planID;
		}
		public String getGrade() {
			return grade;
		}
		public void setGrade(String grade) {
			this.grade = grade;
		}
		public String getL1() {
			return l1;
		}
		public void setL1(String l1) {
			this.l1 = l1;
		}
		public String getL2() {
			return l2;
		}
		public void setL2(String l2) {
			this.l2 = l2;
		}
		public Course() {
			
		}
		public Course(String courseID, String courseName, short credit,
				String classification, String property, String period,
				String offerDepID, String offerDepart, String timeForCourse,
				String location, String teacherID, String teacherName,
				String teaEmail, String majID, String majorName, short max,
				String planID, String planName, String grade, String eduLevel,
				String weekday) {
			super();
			this.courseID = courseID;
			this.courseName = courseName;
			this.credit = credit;
			this.classification = classification;
			this.property = property;
			this.period = period;
			this.offerDepID = offerDepID;
			this.offerDepart = offerDepart;
			this.weekday = weekday;
			this.timeForCourse = timeForCourse;
			this.location = location;
			this.teacherID = teacherID;
			this.teacherName = teacherName;
			this.teaEmail = teaEmail;
			this.majID = majID;
			this.majorName = majorName;
			this.max = max;
			this.planID = planID;
			this.planName = planName;
			this.grade = grade;
			this.eduLevel = eduLevel;
		}
		
		
		
         
}
