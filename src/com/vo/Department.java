package com.vo;

public class Department {
	private String depID;//学院号
    private String depName;//院名
    private String d1;
    private String d2;
    private String d3;
    private String d4;
	public String getDepID() {
		return depID;
	}
	public void setDepID(String depID) {
		this.depID = depID;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getD1() {
		return d1;
	}
	public void setD1(String d1) {
		this.d1 = d1;
	}
	public String getD2() {
		return d2;
	}
	public void setD2(String d2) {
		this.d2 = d2;
	}
	public String getD3() {
		return d3;
	}
	public void setD3(String d3) {
		this.d3 = d3;
	}
	public String getD4() {
		return d4;
	}
	public void setD4(String d4) {
		this.d4 = d4;
	}
	public Department() {
		
	}
	public Department(String depID, String depName, String d1, String d2,
			String d3, String d4) {
		super();
		this.depID = depID;
		this.depName = depName;
		this.d1 = d1;
		this.d2 = d2;
		this.d3 = d3;
		this.d4 = d4;
	}
    
    
}
