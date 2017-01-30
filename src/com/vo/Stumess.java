package com.vo;

public class Stumess {
	private String messageID;
	private String fromStudentID;
	private String toStudentID;
	private String toStudentName;
	private String timeOfLeaMes;
	private String content;
	private Short confirmMessage;
	private Short haveBeenRead;
	private String fromStudentName;
	private String stumess1;
	private String stumess2;
	
	public String getFromStudentName() {
		return fromStudentName;
	}
	public void setFromStudentName(String fromStudentName) {
		this.fromStudentName = fromStudentName;
	}
	public String getMessageID() {
		return messageID;
	}
	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}
	
	public String getFromStudentID() {
		return fromStudentID;
	}
	public void setFromStudentID(String fromStudentID) {
		this.fromStudentID = fromStudentID;
	}
	public String getToStudentID() {
		return toStudentID;
	}
	public void setToStudentID(String toStudentID) {
		this.toStudentID = toStudentID;
	}
	public String getToStudentName() {
		return toStudentName;
	}
	public void setToStudentName(String toStudentName) {
		this.toStudentName = toStudentName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
    
	public String getTimeOfLeaMes() {
		return timeOfLeaMes;
	}
	public void setTimeOfLeaMes(String timeOfLeaMes) {
		this.timeOfLeaMes = timeOfLeaMes;
	}
	public Short getConfirmMessage() {
		return confirmMessage;
	}
	public void setConfirmMessage(Short confirmMessage) {
		this.confirmMessage = confirmMessage;
	}
	public Short getHaveBeenRead() {
		return haveBeenRead;
	}
	public void setHaveBeenRead(Short haveBeenRead) {
		this.haveBeenRead = haveBeenRead;
	}
	public String getStumess1() {
		return stumess1;
	}
	public void setStumess1(String stumess1) {
		this.stumess1 = stumess1;
	}
	public String getStumess2() {
		return stumess2;
	}
	public void setStumess2(String stumess2) {
		this.stumess2 = stumess2;
	}
	public Stumess() {
		
	}
	
	public Stumess(String messageID, String fromStudentID, String toStudentID,
			String toStudentName, String timeOfLeaMes, String content,
			Short confirmMessage, Short haveBeenRead, String fromStudentName,
			String stumess1, String stumess2) {
		super();
		this.messageID = messageID;
		this.fromStudentID = fromStudentID;
		this.toStudentID = toStudentID;
		this.toStudentName = toStudentName;
		this.timeOfLeaMes = timeOfLeaMes;
		this.content = content;
		this.confirmMessage = confirmMessage;
		this.haveBeenRead = haveBeenRead;
		this.fromStudentName = fromStudentName;
		this.stumess1 = stumess1;
		this.stumess2 = stumess2;
	}
	public Stumess(String messageID, String fromStudentID, String toStudentID,
			String toStudentName, String timeOfLeaMes, String content,
			Short confirmMessage, Short haveBeenRead,String fromStudentName) {
		super();
		this.messageID = messageID;
		this.fromStudentID = fromStudentID;
		this.toStudentID = toStudentID;
		this.toStudentName = toStudentName;
		this.timeOfLeaMes = timeOfLeaMes;
		this.content = content;
		this.confirmMessage = confirmMessage;
		this.haveBeenRead = haveBeenRead;
		this.fromStudentName = fromStudentName;
	}
	
    
}
