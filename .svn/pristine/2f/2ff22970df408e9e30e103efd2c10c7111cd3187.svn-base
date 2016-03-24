package com.jxust.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.jxust.bean.Course;
import com.jxust.bean.PreCourse;
import com.jxust.service.CourseService;
import com.jxust.service.PreCourseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class preCourseAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PreCourse pre;
	public PreCourse getPre() {
		return pre;
	}
	public void setPre(PreCourse pre) {
		this.pre = pre;
	}
	private String courseName;
	private Long ChapterId;
	public Long getChapterId() {
		return ChapterId;
	}
	public void setChapterId(Long chapterId) {
		ChapterId = chapterId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Resource
	private PreCourseService preCourseService;
	@Resource
	private CourseService courseService;
	
	
	public void modelList(){
		List<Course> CourseList =courseService.findAll();
		ActionContext.getContext().put("CourseList", CourseList);
	}
	 public String addpreUI(){
		 
		 modelList();
		 return"toaddpreUI";
	 }
	/**
	  * 添加反转课堂知识点
	  * @return
	  */
	 public String addPrecourse(){
		 modelList();
		 if(pre.getPreknowledge()==null||pre.getPreknowledge().isEmpty()){
			 ActionContext.getContext().put("preError", "知识不可为空！");
			 return"addPreError";
		 }
		 if(courseName==null){
			 ActionContext.getContext().put("courseError", "请选择所属课程！");
			 return"addPreError";
		 }
		 if(pre.getChapterId()==null){
			 ActionContext.getContext().put("chapterError", "请选择章节！");
			 return"addPreError";
		 }
		
		 preCourseService.save(pre);
		 
		 ActionContext.getContext().put("premsg", "反转课堂知识点保存成功！");
		 return"toaddPre";
		 
	 }
	 /**
	  * 反转课堂知识点管理
	  * @return
	  */
	 public String preManage(){
		 modelList();
		 List<PreCourse> preList=preCourseService.findAll(pre.getChapterId());
		 
		 ActionContext.getContext().put("ChapterId", pre.getChapterId());
		 ActionContext.getContext().put("preList", preList);
		 return"topreManage";
	 }
	 /**
	  * 单条反转课堂知识点删除
	  * @return
	  */
	 public String predelete(){
		 preCourseService.delete(pre.getId());
		 ActionContext.getContext().put("ChapterId", pre.getChapterId());
		 return"topredelete";
	 }
	 /**
	  * 前台反转课堂知识点展示
	  * @return
	 * 
	  */
	public List<PreCourse> prelist(Long ChapterId){
		List<PreCourse> presList=preCourseService.findAll(ChapterId);
		//ActionContext.getContext().put("presList", presList);
		
		return presList;
	}
	public String prebatchDelete(){
		 ActionContext.getContext().put("ChapterId", pre.getChapterId());
		int size=preCourseService.getSize(pre.getChapterId());
		if(size<=0){
			return"batchError";
		}else{
			preCourseService.batchDelete(pre.getChapterId());
		}
		return"tobatch";
	}
}
