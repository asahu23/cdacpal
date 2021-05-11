package com.cdacpal.ResponsePojo;

public class UserLoginPojo {

	private String loginid;
	private String password;
																																																																															
	
	public UserLoginPojo()
	{
		super();
	}
	
	public UserLoginPojo(String loginid)
	{
		super();
		this.loginid = loginid;
		this.password = password;
	}
	
	public UserLoginPojo(String loginid, String password) {
		super();
		this.loginid = loginid;
		this.password = password;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLoginPojo [loginid=" + loginid + ", password=" + password + "]";
	}
	
	
	
	
}
