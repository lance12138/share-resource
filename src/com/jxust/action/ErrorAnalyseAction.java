package com.jxust.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.jxust.bean.Course;
import com.jxust.bean.ErrorAnalyse;
import com.jxust.service.CourseService;
import com.jxust.service.ErrorAnalyseService;
import com.jxust.util.PageToolBar;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class ErrorAnalyseAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7845349637395556955L;
	private ErrorAnalyse analyse;
	public ErrorAnalyse getAnalyse() {
		return analyse;
	}
	public void setAnalyse(ErrorAnalyse analyse) {
		this.analyse = analyse;
	}
	@Resource
	private ErrorAnalyseService errorAnalyseService;
	@Resource
	private CourseService courseService;
	private File errorPhoto;
	private String errorPhotoFileName;
	private String errorPhotoContentType;
	public File getErrorPhoto() {
		return errorPhoto;
	}
	public void setErrorPhoto(File errorPhoto) {
		this.errorPhoto = errorPhoto;
	}
	public String getErrorPhotoFileName() {
		return errorPhotoFileName;
	}
	public void setErrorPhotoFileName(String errorPhotoFileName) {
		this.errorPhotoFileName = errorPhotoFileName;
	}
	public String getErrorPhotoContentType() {
		return errorPhotoContentType;
	}
	public void setErrorPhotoContentType(String errorPhotoContentType) {
		this.errorPhotoContentType = errorPhotoContentType;
	}
	public File getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(File thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getThumbnailFileName() {
		return thumbnailFileName;
	}
	public void setThumbnailFileName(String thumbnailFileName) {
		this.thumbnailFileName = thumbnailFileName;
	}
	public String getThumbnailContentType() {
		return thumbnailContentType;
	}
	public void setThumbnailContentType(String thumbnailContentType) {
		this.thumbnailContentType = thumbnailContentType;
	}
	private File thumbnail;
	private String thumbnailFileName;
	private String thumbnailContentType;
	private PageToolBar toolBar;
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
	private int PageSize=6;
	private int currentPage=1;
	public void model(){
		List<Course> courseList=courseService.findAll();
		ActionContext.getContext().put("courseList", courseList);
	}
	public String addUI(){
		model();
		return"toaddUI";
	}
	
	public String enterErrorAnalyse(){
		
		String hql=errorAnalyseService.getHqlByCourseId();//通过courseid获得与课程相关所有错误相关记录
		int count=errorAnalyseService.getCountByHQL(hql,analyse.getCourseId());//通过hql语句查询记录条数
		if(getToolBar()==null){
			setToolBar(new PageToolBar(count, PageSize));
		}else{
			getToolBar().setResultsetCount(count);
			getToolBar().setPageSize(PageSize);
		}
		List<ErrorAnalyse> analyseList=errorAnalyseService.getListForPage(hql,analyse.getCourseId(),getToolBar().getStartRow(),getToolBar().getEndRow());
		
		//List<ErrorAnalyse>analyseList=errorAnalyseService.findByCourseId(analyse.getCourseId());
		ActionContext.getContext().put("analyseList", analyseList);
		return"toenter";
	}

	/**
	 * 后台添加错误分析
	 * @return
	 */
	public String addErrorAnalyse(){
		model();
		 FileOutputStream fost1 = null;
		 FileInputStream fist1 = null;
		 FileOutputStream fost2 = null;
		 FileInputStream fist2 = null;
		if(analyse.getError_name()==null||analyse.getError_name().isEmpty()){
			ActionContext.getContext().put("nameError", "错误案例名称不可为空！");
			return"addError";
		}
		if(analyse.getError_analyse()==null||analyse.getError_analyse().isEmpty()){
			ActionContext.getContext().put("analyseError", "错误分析不可为空！");
			return"addError";
		}
		if(errorPhoto==null){
			ActionContext.getContext().put("photoError", "请上传大图！");
			return"addError";
		}
		if(thumbnail==null){
			ActionContext.getContext().put("littlephotoError", "请上传缩略图！");
			return"addError";
		}
		String path=ServletActionContext.getServletContext().getRealPath("/ErrorPhoto");
		try {
			fost1=new FileOutputStream(path+"\\"+thumbnailFileName);
			fost2=new FileOutputStream(path+"\\"+errorPhotoFileName);
			fist1=new FileInputStream(thumbnail);
			fist2=new FileInputStream(errorPhoto);
			byte[] buffer=new byte[1024];
			int len=0;
			int len1=0;
			while((len=fist1.read(buffer))!=-1){
				fost1.write(buffer, 0, len);
			}
			while((len1=fist2.read(buffer))!=-1){
				fost2.write(buffer, 0, len1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ActionContext.getContext().put("uploadError", "文件上传出错！请重新上传");
			return"addError";
		}
		analyse.setThumbnail(thumbnailFileName);
		analyse.setError_photo(errorPhotoFileName);
		errorAnalyseService.save(analyse);
		ActionContext.getContext().put("addmsg","错误分析添加成功！");
		return "addErrorAnalyse";
	}
	/**
	 * 错误分析管理
	 * @return
	 */
	public String errorAnalyseManage(){
		model();
		if(analyse==null){
			analyse=new ErrorAnalyse();
		}
		String hql=errorAnalyseService.getHQL(analyse);
		int count=errorAnalyseService.getCountByHQL(hql);
		if(getToolBar()==null){
			setToolBar(new PageToolBar(count, PageSize));
		}else{
			getToolBar().setResultsetCount(count);
			getToolBar().setPageSize(PageSize);
		}
		List<ErrorAnalyse> errorList=errorAnalyseService.getListForPage(hql,getToolBar().getStartRow(),getToolBar().getEndRow());
		ActionContext.getContext().put("errorList", errorList);
		return"analyseManage";
	}
	/**
	 * 删除一条记录
	 * @return
	 */
	public String error_delete(){
		errorAnalyseService.delete(analyse.getError_id());
		return"todelete";
	}
}
