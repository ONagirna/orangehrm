package com.orange.data;

public class NewUser {
	
	private final String newuserrole;
	private final String newemployeename;
	private final String newusername;
	private final String newuserstatus;
	private final String newuserpassword;
	private final String newpasswordconfirm;
	
	public NewUser (String newuserrole, String newemployeename, String newusername, String newuserstatus, String newuserpassword, String newpasswordconfirm ) {
		this.newuserrole = newuserrole;
		this.newemployeename = newemployeename;
		this.newusername = newusername;
		this.newuserstatus = newuserstatus;
		this.newuserpassword = newuserpassword;
		this.newpasswordconfirm = newpasswordconfirm;
	}
	
	public String getNewUserRole() {
		return this.newuserrole;
	}

	public String getNewEmployeeName() {
		return this.newemployeename;
	}

	public String getNewUserName() {
		return this.newusername;
	}
	public String getNewUserStatus() {
		return this.newuserstatus;
	}
	public String getNewUserPassword() {
		return this.newuserpassword;
	}
	public String getNewPasswordConfirm() {
		return this.newpasswordconfirm;
	}
	

}
