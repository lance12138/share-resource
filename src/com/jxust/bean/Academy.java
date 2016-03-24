package com.jxust.bean;

import java.util.HashSet;
import java.util.Set;

public class Academy {

	private Long id;
	private String academy;
	private Set<Tools> academyTools=new HashSet<Tools>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAcademy() {
		return academy;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	public Set<Tools> getAcademyTools() {
		return academyTools;
	}
	public void setAcademyTools(Set<Tools> academyTools) {
		this.academyTools = academyTools;
	}
	
}
