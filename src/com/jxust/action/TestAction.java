package com.jxust.action;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jxust.test.testService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class TestAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private testService testservice;
	
	/*public String execute() throws Exception {
		System.out.println("--------> TestAction.execute()");
		testservice.save();
		return "success";
	}*/
	private File image;
	private String imageFileName;
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	private String imageContentType;
   public String test(){
	   
	   
	   return "test";
   }
}
