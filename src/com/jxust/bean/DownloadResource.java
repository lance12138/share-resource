package com.jxust.bean;

import java.util.Date;

public class DownloadResource {

	private Long id;
	private String resourceName;// 要下载的文件名
	int type;//文件类型
	private Date uploadDate;//上传时间
    private String resourceURL;//下载文件名用于前台陈列
    private Long courseId;
    public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	private String courseName;
    private String input_search;//冗余字段，数据库中没有，为了更好取数据
	public String getInput_search() {
		return input_search;
	}

	public void setInput_search(String inputSearch) {
		input_search = inputSearch;
	}

	public String getResourceURL() {
		return resourceURL;
	}

	public void setResourceURL(String resourceURL) {
		this.resourceURL = resourceURL;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

/*	private Course course;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
