package com.vo;

public class Administrator {
        private String adminID;
        private String password;
        private String adminEmail;
        private String a1;
        private String a2;
       		
		public String getAdminEmail() {
			return adminEmail;
		}
		public void setAdminEmail(String adminEmail) {
			this.adminEmail = adminEmail;
		}
		public String getAdminID() {
			return adminID;
		}
		public void setAdminID(String adminID) {
			this.adminID = adminID;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getA1() {
			return a1;
		}
		public void setA1(String a1) {
			this.a1 = a1;
		}
		public String getA2() {
			return a2;
		}
		public void setA2(String a2) {
			this.a2 = a2;
		}
		public Administrator() {
		
		}
		public Administrator(String adminID, String password,
				String adminEmail, String a1, String a2) {
			super();
			this.adminID = adminID;
			this.password = password;
			this.adminEmail = adminEmail;
			this.a1 = a1;
			this.a2 = a2;
		}
		     
}
