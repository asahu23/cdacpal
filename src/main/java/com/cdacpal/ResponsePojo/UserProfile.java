package com.cdacpal.ResponsePojo;

public class UserProfile {

	private String name;
	private String email;
	private String password;
	private Long userid;
	private String mobileno;
	private String address;
	
	public String getMobileno() {
		return mobileno;
	}






	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}






	public String getAddress() {
		return address;
	}






	public void setAddress(String address) {
		this.address = address;
	}






	public UserProfile() {
		super();
	}






	public UserProfile(String name, String email, String password, Long userid) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.userid = userid;
	}






	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Long getUserid() {
		return userid;
	}






	public void setUserid(Long userid) {
		this.userid = userid;
	}






	@Override
	public String toString() {
		return "UserProfile [name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
}
