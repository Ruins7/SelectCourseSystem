package com.vo;

public class Notice {
         private String noticeID;
         private String title;
         private String content;
         private String timeOfNotice;//发布公告时间
         private String n1;
         private String n2;
		public String getNoticeID() {
			return noticeID;
		}
		public void setNoticeID(String noticeID) {
			this.noticeID = noticeID;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		
		public String getTimeOfNotice() {
			return timeOfNotice;
		}
		public void setTimeOfNotice(String timeOfNotice) {
			this.timeOfNotice = timeOfNotice;
		}
		public String getN1() {
			return n1;
		}
		public void setN1(String n1) {
			this.n1 = n1;
		}
		public String getN2() {
			return n2;
		}
		public void setN2(String n2) {
			this.n2 = n2;
		}
		public Notice() {
			
		}
		public Notice(String noticeID, String title, String content,
				String timeOfNotice, String n1, String n2) {
			super();
			this.noticeID = noticeID;
			this.title = title;
			this.content = content;
			this.timeOfNotice = timeOfNotice;
			this.n1 = n1;
			this.n2 = n2;
		}
         
}
