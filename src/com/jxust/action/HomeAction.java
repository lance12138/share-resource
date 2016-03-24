package com.jxust.action;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jxust.bean.Course;
import com.jxust.service.CourseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class HomeAction extends ActionSupport implements ModelDriven<Course> {

	private Course course;

	String type;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@Resource
	private CourseService courseService;
	public Course getModel() {
		// TODO Auto-generated method stub
		return course;
	}

	
	/*
	 * 
	 * 大纲
	 */
	public String outline() throws Exception {
		  List courseList=courseService.findAll();
		  ActionContext.getContext().put("courseList", courseList);
		
		 if(type.equals("1")){
			 for (Iterator iterator = courseList.iterator(); iterator.hasNext();) {
					Course course = (Course) iterator.next();
					if(course.getTeachOutline()==null){
						this.addFieldError("Errors", "管理员没有上传文件！");
						return "teacherror";
					}
					
				}
				
		return "teachOutline";
		 }else if(type.equals("2")){
			 for (Iterator iterator = courseList.iterator(); iterator.hasNext();) {
				Course course = (Course) iterator.next();
				if(course.getTeachCalendar()==null){
					this.addFieldError("Errors", "管理员没有上传文件！");
					return "error";
				}
				
			}
			
		 return "teachCalendar";}
		 else if(type.equals("3")){
			 for (Iterator iterator = courseList.iterator(); iterator.hasNext();) {
					Course course = (Course) iterator.next();
					if(course.getExamOutline()==null){
						this.addFieldError("Errors", "管理员没有上传文件！");
						return "examerror";
					}
					
				}
				
			return"examOutline";
		}
		 else if(type.equals("4")){
			 for (Iterator iterator = courseList.iterator(); iterator.hasNext();) {
					Course course = (Course) iterator.next();
					if(course.getScore()==null){
						this.addFieldError("Errors", "管理员没有上传文件！");
						return "scoreerror";
					}
					
				}
				
			return"scoreOutline";
		}
		 else if(type.equals("5")){
			 for (Iterator iterator = courseList.iterator(); iterator.hasNext();) {
					Course course = (Course) iterator.next();
					if(course.getExperimentOutline()==null){
						this.addFieldError("Errors", "管理员没有上传文件！");
						return "contenterror";
					}
					
				}
				
			return"introductContent";
		}
		 else if(type.equals("6")){
			 for (Iterator iterator = courseList.iterator(); iterator.hasNext();) {
					Course course = (Course) iterator.next();
					if(course.getStudyGuide()==null){
						this.addFieldError("Errors", "管理员没有上传文件！");
						return "guideerror";
					}
					
				}
				
		return "guideOutline";
			 
		 }
	
			 return null;
		 
	}
	
	
	/*
	 * 
	 * 进入后台
	 */
	public String backstage() throws Exception {
        
		return "tobackstage";
	}
    
}
