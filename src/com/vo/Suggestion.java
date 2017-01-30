package com.vo;

public class Suggestion {
	private String suggestionID;
	private String studentID;
	private String studentName;
	private String timeOfSugg;
	private String title;
	private String suggContent;
	private String replyContent;
	private String replyTime;
	private String sugg1;
	private String sugg2;
	public String getSuggestionID() {
		return suggestionID;
	}
	public void setSuggestionID(String suggestionID) {
		this.suggestionID = suggestionID;
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
	
	public String getTimeOfSugg() {
		return timeOfSugg;
	}
	public void setTimeOfSugg(String timeOfSugg) {
		this.timeOfSugg = timeOfSugg;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSuggContent() {
		return suggContent;
	}
	public void setSuggContent(String suggContent) {
		this.suggContent = suggContent;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}
	public String getSugg1() {
		return sugg1;
	}
	public void setSugg1(String sugg1) {
		this.sugg1 = sugg1;
	}
	public String getSugg2() {
		return sugg2;
	}
	public void setSugg2(String sugg2) {
		this.sugg2 = sugg2;
	}
	public Suggestion() {
		
	}
	public Suggestion(String suggestionID, String studentID,
			String studentName, String timeOfSugg, String title,
			String suggContent, String replyContent, String replyTime,
			String sugg1, String sugg2) {
		super();
		this.suggestionID = suggestionID;
		this.studentID = studentID;
		this.studentName = studentName;
		this.timeOfSugg = timeOfSugg;
		this.title = title;
		this.suggContent = suggContent;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		this.sugg1 = sugg1;
		this.sugg2 = sugg2;
	}
    
}
