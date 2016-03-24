package com.jxust.bean;

import java.util.Date;

public class Program {

	private Long pro_id;
	private String pro_title;
	private String pro_content;
	private Date pro_time;
	private Long courseId;
	private String trainVideo;
	public String getTrainVideo() {
		return trainVideo;
	}
	public void setTrainVideo(String trainVideo) {
		this.trainVideo = trainVideo;
	}
	public Long getPro_id() {
		return pro_id;
	}
	public void setPro_id(Long proId) {
		pro_id = proId;
	}
	public String getPro_title() {
		return pro_title;
	}
	public void setPro_title(String proTitle) {
		pro_title = proTitle;
	}
	public String getPro_content() {
		return pro_content;
	}
	public void setPro_content(String proContent) {
		pro_content = proContent;
	}
	public Date getPro_time() {
		return pro_time;
	}
	public void setPro_time(Date proTime) {
		pro_time = proTime;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
}
