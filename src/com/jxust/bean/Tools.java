package com.jxust.bean;

import java.util.Date;

public class Tools {

	private Long id;
	
	private String eduInstitute;
	private String major;
	private int grade;
	private String otherName;//其他上传的资源名
	private Date time;
	private String length;
	private String teachChange;//教学教改
	public String getTeachChange() {
		return teachChange;
	}
	public void setTeachChange(String teachChange) {
		this.teachChange = teachChange;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getOtherName() {
		return otherName;
	}
	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}
	private Academy academy;
	public Academy getAcademy() {
		return academy;
	}
	public void setAcademy(Academy academy) {
		this.academy = academy;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEduInstitute() {
		return eduInstitute;
	}
	public void setEduInstitute(String eduInstitute) {
		this.eduInstitute = eduInstitute;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	private String link;
}
