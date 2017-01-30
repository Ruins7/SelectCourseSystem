package com.vo;

public class Friend {
	    private String studentID;
	    private String friendID;
        private String friendName;
        private String f1;
        private String f2;
		public String getStudentID() {
			return studentID;
		}
		public void setStudentID(String studentID) {
			this.studentID = studentID;
		}
		public String getFriendID() {
			return friendID;
		}
		public void setFriendID(String friendID) {
			this.friendID = friendID;
		}
		public String getFriendName() {
			return friendName;
		}
		public void setFriendName(String friendName) {
			this.friendName = friendName;
		}
		public String getF1() {
			return f1;
		}
		public void setF1(String f1) {
			this.f1 = f1;
		}
		public String getF2() {
			return f2;
		}
		public void setF2(String f2) {
			this.f2 = f2;
		}
		public Friend() {
			
		}
		public Friend(String studentID, String friendID, String friendName,
				String f1, String f2) {
			super();
			this.studentID = studentID;
			this.friendID = friendID;
			this.friendName = friendName;
			this.f1 = f1;
			this.f2 = f2;
		}
		public Friend(String studentID, String friendID, String friendName) {
			super();
			this.studentID = studentID;
			this.friendID = friendID;
			this.friendName = friendName;
		}
		
        
}
