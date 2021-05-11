package com.cdacpal.ResponsePojo;

public class CourseMaterialPojo {
	
	
	
private String coursename;
private String filename;
private String fileurl;
private Long filesize;


public CourseMaterialPojo() {
	super();
}
public CourseMaterialPojo(String coursename, String filename, String file, Long filesize) {
	super();
	this.coursename = coursename;
	this.filename = filename;
	this.fileurl = file;
	this.filesize = filesize;
}
public String getCoursename() {
	return coursename;
}
public void setCoursename(String coursename) {
	this.coursename = coursename;
}
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public String getFile() {
	return fileurl;
}
public void setFile(String file) {
	this.fileurl = file;
}
public Long getFilesize() {
	return filesize;
}
public void setFilesize(Long filesize) {
	this.filesize = filesize;
}



}
