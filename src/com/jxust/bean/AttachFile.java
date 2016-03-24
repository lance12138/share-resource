package com.jxust.bean;

public class AttachFile {

	private Long id;
	private String file;
	private Homework homework;
	private Long attachId;//方便页面取数据
	public Long getAttachId() {
		return attachId;
	}
	public void setAttachId(Long attachId) {
		this.attachId = attachId;
	}
	public Homework getHomework() {
		return homework;
	}
	public void setHomework(Homework homework) {
		this.homework = homework;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
}
