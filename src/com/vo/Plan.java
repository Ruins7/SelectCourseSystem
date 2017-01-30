package com.vo;

import java.util.Date;

public class Plan {
        private String planID;
        private String planName;
        private String type;//修读类型（主修，辅修）
        private String major;
        private String majID;
        private String degree;//学位类型
        private String eduLevel;//学历类型
        private String direction;//方向
        private short minCredit;//学分要求
        private Date timeForPlan;//制定时间
        private String p1;
        private String p2;
		public String getPlanID() {
			return planID;
		}
		public void setPlanID(String planID) {
			this.planID = planID;
		}
		public String getPlanName() {
			return planName;
		}
		public void setPlanName(String planName) {
			this.planName = planName;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
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
		public String getDegree() {
			return degree;
		}
		public void setDegree(String degree) {
			this.degree = degree;
		}
		public String getDirection() {
			return direction;
		}
		public void setDirection(String direction) {
			this.direction = direction;
		}
		public short getMinCredit() {
			return minCredit;
		}
		public void setMinCredit(short minCredit) {
			this.minCredit = minCredit;
		}
		public Date getTimeForPlan() {
			return timeForPlan;
		}
		public void setTimeForPlan(Date timeForPlan) {
			this.timeForPlan = timeForPlan;
		}
		public String getP1() {
			return p1;
		}
		public void setP1(String p1) {
			this.p1 = p1;
		}
		public String getP2() {
			return p2;
		}
		public void setP2(String p2) {
			this.p2 = p2;
		}
		public String getEduLevel() {
			return eduLevel;
		}
		public void setEduLevel(String eduLevel) {
			this.eduLevel = eduLevel;
		}
		public Plan() {
			
		}
		public Plan(String planID, String planName, String type, String major,
				String majID, String degree, String eduLevel, String direction,
				short minCredit, Date timeForPlan, String p1, String p2) {
			super();
			this.planID = planID;
			this.planName = planName;
			this.type = type;
			this.major = major;
			this.majID = majID;
			this.degree = degree;
			this.eduLevel = eduLevel;
			this.direction = direction;
			this.minCredit = minCredit;
			this.timeForPlan = timeForPlan;
			this.p1 = p1;
			this.p2 = p2;
		}
}
