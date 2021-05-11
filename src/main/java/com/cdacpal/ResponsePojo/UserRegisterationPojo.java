package com.cdacpal.ResponsePojo;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UserRegisterationPojo {

	@NotBlank
	@NotNull
	private String name;
	@NotNull
	@NotBlank
	private String course;
	@NotNull
	@NotBlank
	private Date dob;
	@NotNull
	@NotBlank
	private String gender;
	@NotNull
	@NotBlank
	private String loginid;
	@NotNull
	@NotBlank
	private String password;
	@NotNull
	@NotBlank
	private String conpassword;
	@NotNull
	@NotBlank
	private String address;
	@NotNull
	@NotBlank
	@Length(min = 10,max = 10)
	private String mobile;
	
	
	
	
	
	
	public UserRegisterationPojo(@NotBlank @NotNull String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String
			loginid) {
		this.loginid = loginid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConpassword() {
		return conpassword;
	}
	public void setConpassword(String conpassword) {
		this.conpassword = conpassword;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "UserRegisterationPojo [name=" + name + ", course=" + course + ", dob=" + dob + ", gender=" + gender
				+ ", loginid=" + loginid + ", password=" + password + ", conpassword=" + conpassword + ", address="
				+ address + ", mobile=" + mobile + "]";
	}
	
	
}
