package com.jxust.bean;

public class PreCourse {

	private Long id;
	private String preknowledge;//反转课堂知识点
	private Long chapterId;
	
	public Long getChapterId() {
		return chapterId;
	}
	public void setChapterId(Long chapterId) {
		this.chapterId = chapterId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPreknowledge() {
		return preknowledge;
	}
	public void setPreknowledge(String preknowledge) {
		this.preknowledge = preknowledge;
	}
}
