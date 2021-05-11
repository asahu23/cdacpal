package com.cdacpal.ResponsePojo;

public class AcknowledgementPojo {

	private int success;
	private String error;
	private Long userId; 
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "AcknowledgementPojo [success=" + success + ", error=" + error + "]";
	}
	
	
	
}
