package com.jxust.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.jxust.bean.Course;
import com.jxust.bean.Program;
import com.jxust.service.CourseService;
import com.jxust.service.ProgramService;
import com.jxust.util.PageToolBar;
import com.jxust.util.Tools;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class ProgramAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -965702470168579206L;

	private Program program;
	
	private File video;
	private String videoFileName;
	public File getVideo() {
		return video;
	}

	public void setVideo(File video) {
		this.video = video;
	}

	public String getVideoFileName() {
		return videoFileName;
	}

	public void setVideoFileName(String videoFileName) {
		this.videoFileName = videoFileName;
	}

	public String getVideoContentType() {
		return videoContentType;
	}

	public void setVideoContentType(String videoContentType) {
		this.videoContentType = videoContentType;
	}
	private String videoContentType;
	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}
	@Resource
	private CourseService courseService;
	@Resource
	private ProgramService programService;
	
	private PageToolBar toolBar;
	private int PageSize=6;
	private int currentPage=1;
	private Long courseid;
	public Long getCourseid() {
		return courseid;
	}

	public void setCourseid(Long courseid) {
		this.courseid = courseid;
	}

	public PageToolBar getToolBar() {
		return toolBar;
	}

	public void setToolBar(PageToolBar toolBar) {
		this.toolBar = toolBar;
	}

	public int getPageSize() {
		return PageSize;
	}

	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 进入添加实例程序
	 * @return
	 */
	
	public void model(){
		List<Course> courseList=courseService.findAll();
		ActionContext.getContext().put("courseList", courseList);
	}
	public String enterAdd(){
		model();
		return"enter";
	}
	/**
	 * 添加实例项目
	 * @return
	 * @throws Exception
	 */
	public String addProgram()throws Exception{
		model();
		FileOutputStream fos=null;
		FileInputStream fis=null;
		if(program.getPro_title()==null||program.getPro_title().isEmpty()){
			ActionContext.getContext().put("titleError", "项目标题不可为空！");
			return"programError";
		}
		if(program.getPro_content()==null||program.getPro_content().isEmpty()){
			ActionContext.getContext().put("contentError", "项目描述不可为空！");
			return"programError";
		}
		if(video==null){
			ActionContext.getContext().put("videoError", "请上传视频！");
			return"programError";
		}
		String path=ServletActionContext.getServletContext().getRealPath("Video");
		String rename=Tools.renameFileName(videoFileName);
		try {
			fis=new FileInputStream(video);
			
			fos=new FileOutputStream(path+"\\"+rename);
			 byte[] buffer = new byte[1024];
			   int len = 0;
			   while ((len = fis.read(buffer))!=-1) {
				   fos.write(buffer, 0, len);
			   }
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			ActionContext.getContext().put("videoError", "视频上传失败，请重新上传！");
			
			
		}finally{
			if(fos!=null){
			fos.close();
			}
			if(fis!=null){
			fis.close();
			}
		}
		program.setPro_time(new Date());
		program.setTrainVideo(rename);
		programService.save(program);
		ActionContext.getContext().put("msg", "课程实例添加成功！");
		return"toadd";
	}
	
	/**
	 * 前台实例项目列表
	 * @return
	 */
	public String list(){
		String hql=programService.getHQL(courseid);
		int proCount=programService.getCountByCourse(hql,courseid);
		int count=programService.findSizeByCourse(courseid);
		 if(getToolBar()==null){
			   setToolBar(new PageToolBar(proCount,PageSize));
			   
		   }
		   else{
			   getToolBar().setResultsetCount(proCount);
				getToolBar().setPageSize(PageSize);
		   }
		   List<Program> proList=programService.getListForPage(hql, toolBar.getStartRow(), toolBar.getEndRow(),courseid);
		  
		   ActionContext.getContext().put("count", count);
		   ActionContext.getContext().put("proList", proList);
		   return"tolist";
	}
	/**
	 * 进入实例项目细节
	 * @return
	 */
	public String programDetail(){
		Program pro_detail=programService.findById(program.getPro_id());
		ActionContext.getContext().put("pro_detail", pro_detail);
		return"todetail";
	}
	/**
	 * 后台管理
	 * @return
	 */
	public String programManage(){
		model();
		String hql=programService.getHQL(courseid);
		int proCount=programService.getCountByCourse(hql,courseid);
		 if(getToolBar()==null){
			   setToolBar(new PageToolBar(proCount,PageSize));
			   
		   }
		   else{
			   getToolBar().setResultsetCount(proCount);
				getToolBar().setPageSize(PageSize);
		   }
		   List<Program> backproList=programService.getListForPage(hql, toolBar.getStartRow(), toolBar.getEndRow(),courseid);
		   ActionContext.getContext().put("backproList", backproList);
		return"programManage";
	}
	/**
	 * 删除
	 * @return
	 */
	public String pro_delete(){
		programService.delete(program.getPro_id());
		return"todelete";
	}
	
	public String programVideo(){
		Program pro=programService.findById(program.getPro_id());
		ActionContext.getContext().put("uri", pro.getTrainVideo());
		return"programVideo";
	}
}
