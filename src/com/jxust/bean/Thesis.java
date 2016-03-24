package com.jxust.bean;

public class Thesis {
	
	private Long id;
	private String thesisName;
	private String issue;
	private String studyTime;
	private Long courseId;
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getStudyTime() {
		return studyTime;
	}
	public void setStudyTime(String studyTime) {
		this.studyTime = studyTime;
	}
	private String position;
	private String author;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getThesisName() {
		return thesisName;
	}
	public void setThesisName(String thesisName) {
		this.thesisName = thesisName;
	}
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}


}
