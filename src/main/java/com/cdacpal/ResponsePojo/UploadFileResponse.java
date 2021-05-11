package com.cdacpal.ResponsePojo;

public class UploadFileResponse {
	
	private int error;
	private String success;
	
	
	
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	@Override
	public String toString() {
		return "UploadFileResponse [error=" + error + ", success=" + success + "]";
	}
	
	
    
    
    
	
 // Getters and Setters (Omitted for brevity)
}
