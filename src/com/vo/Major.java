package com.vo;

public class Major {
	   private String majID;//系别号
	   private String majorName;//系
	   private String depID;//所属院号
	   private String depName;//所属院名
	   private String dep1;
	   private String dep2;
	   private String dep3;
	   private String dep4;
	   
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
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
	public String getDepID() {
		return depID;
	}
	public void setDepID(String depID) {
		this.depID = depID;
	}
	public String getDep1() {
		return dep1;
	}
	public void setDep1(String dep1) {
		this.dep1 = dep1;
	}
	public String getDep2() {
		return dep2;
	}
	public void setDep2(String dep2) {
		this.dep2 = dep2;
	}
	public String getDep3() {
		return dep3;
	}
	public void setDep3(String dep3) {
		this.dep3 = dep3;
	}
	public String getDep4() {
		return dep4;
	}
	public void setDep4(String dep4) {
		this.dep4 = dep4;
	}
	public Major() {
		
	}
	public Major(String majID, String majorName, String depID, String depName,
			String dep1, String dep2, String dep3, String dep4) {
		super();
		this.majID = majID;
		this.majorName = majorName;
		this.depID = depID;
		this.depName = depName;
		this.dep1 = dep1;
		this.dep2 = dep2;
		this.dep3 = dep3;
		this.dep4 = dep4;
	}
	
	   
}
