package com.vo;

public class Teacher {
        private String teacherID;
        private String teacherName;
        private String sex;
        private String department;
        private String depID;
        private String position;//职称
        private String teaTeleNum;
        private String teaEmail;
        private String photo;
        private String t1;
        private String t2;
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
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		public String getTeaTeleNum() {
			return teaTeleNum;
		}
		public void setTeaTeleNum(String teaTeleNum) {
			this.teaTeleNum = teaTeleNum;
		}
		public String getTeaEmail() {
			return teaEmail;
		}
		public void setTeaEmail(String teaEmail) {
			this.teaEmail = teaEmail;
		}
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
		}
		public String getT1() {
			return t1;
		}
		public void setT1(String t1) {
			this.t1 = t1;
		}
		public String getT2() {
			return t2;
		}
		public void setT2(String t2) {
			this.t2 = t2;
		}
		public Teacher() {
			
		}
		public Teacher(String teacherID, String teacherName, String sex,
				String department, String depID, String position,
				String teaTeleNum, String teaEmail, String photo, String t1,
				String t2) {
			super();
			this.teacherID = teacherID;
			this.teacherName = teacherName;
			this.sex = sex;
			this.department = department;
			this.depID = depID;
			this.position = position;
			this.teaTeleNum = teaTeleNum;
			this.teaEmail = teaEmail;
			this.photo = photo;
			this.t1 = t1;
			this.t2 = t2;
		}
		
		
}
