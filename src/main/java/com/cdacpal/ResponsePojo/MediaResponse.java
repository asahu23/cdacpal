package com.cdacpal.ResponsePojo;

import java.util.Arrays;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MediaResponse {
	
	@NotNull
	@NotBlank
	private String coursetype;	
	private long fileid;
	private String filename;	
	@NotNull
	@NotBlank
	private byte[] file;
	
	
	
	
	

	public String getCoursetype() {
		return coursetype;
	}

	public void setCoursetype(String coursetype) {
		this.coursetype = coursetype;
	}

	public long getFileid() {
		return fileid;
	}

	public void setFileid(long fileid) {
		this.fileid = fileid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "MediaResponse [coursetype=" + coursetype + ", fileid=" + fileid + ", filename=" + filename + ", file="
				+ Arrays.toString(file) + "]";
	}

	

}
