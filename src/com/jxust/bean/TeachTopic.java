package com.jxust.bean;

import java.util.Date;

public class TeachTopic {

	private Long id;
	private String projectName;
	private String projectSource;
	private String StartTime;
	private String author;
	private Long courseId;


	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectSource() {
		return projectSource;
	}

	public void setProjectSource(String projectSource) {
		this.projectSource = projectSource;
	}

	
}
