package com.jxust.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.jxust.bean.Chapter;
import com.jxust.bean.Course;
import com.jxust.bean.Knowledge;
import com.jxust.service.ChapterService;
import com.jxust.service.CourseService;
import com.jxust.service.KnowledgeService;
import com.jxust.util.PageToolBar;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class KnowledgeAction extends ActionSupport{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Knowledge knowledge;
	public Knowledge getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}
	@Resource
	private CourseService courseService;
	@Resource
	private KnowledgeService knowledgeService;
	@Resource
	private ChapterService chapterService;
	
	private Long courseid;
	private Long id;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCourseid() {
		return courseid;
	}

	public void setCourseid(Long courseid) {
		this.courseid = courseid;
	}
	private String courseName;
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	private PageToolBar toolBar;
	private int pageSize = 8;
	public PageToolBar getToolBar() {
		return toolBar;
	}

	public void setToolBar(PageToolBar toolBar) {
		this.toolBar = toolBar;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	private int currentPage = 1;

	
	/**
	 * 为进入添加微知识做准备
	 * @return
	 */
	public String addUI(){
	model();
		return"toaddUI";
		
	}
	public void model(){
		List<Course> courseList=courseService.findAll();
		ActionContext.getContext().put("courseList", courseList);
	}
	/**
	 * 后台添加微知识
	 * @return
	 */
	public String addknowledge(){
		model();
		if(knowledge.getTitle()==null||knowledge.getTitle().isEmpty()){
		
			ActionContext.getContext().put("titleError", "微知识标题不可为空！");
			return"toError";
		}
		if(knowledge.getChapterId()==null){
			ActionContext.getContext().put("chapterError", "请选择章节！");
			return"toError";
			
		}
		if(knowledge.getAnwser()==null||knowledge.getAnwser().isEmpty()){
			
			ActionContext.getContext().put("explainError", "微知识解释内容不可为空！");
			return"toError";
		}
		Course course=courseService.findBytitle(courseName);
		knowledge.setCourseId(course.getId());
		knowledgeService.save(knowledge);
		ActionContext.getContext().put("message", "微知识添加成功");
		return"tosave";
	}
	/**
	 * 后台微知识管理
	 * @return
	 */
	public String knowledgeManage(){
		model();
		if(knowledge==null){
			knowledge=new Knowledge();
		}
		courseid=knowledge.getCourseId();
		String hql=knowledgeService.getHQL(knowledge,courseid,null);
		int Count=knowledgeService.getCount(hql);
		if(getToolBar()==null){
			setToolBar(new PageToolBar(Count, pageSize));
		}else{
			getToolBar().setResultsetCount(Count);
			getToolBar().setPageSize(pageSize);
		}
		List<Knowledge> knowList=knowledgeService.getListForPage(hql, toolBar.getStartRow(), toolBar.getEndRow(),courseid);
		ActionContext.getContext().put("knowList", knowList);
		ActionContext.getContext().put("courseid", courseid);
		return"tomanage";
	}
	public String list(){
		if(knowledge==null){
			knowledge=new Knowledge();
		}
		String hql=knowledgeService.getHQL(knowledge,courseid,knowledge.getChapterId());
		int Count=knowledgeService.getCount(hql);
		if(getToolBar()==null){
			setToolBar(new PageToolBar(Count, pageSize));
		}else{
			getToolBar().setResultsetCount(Count);
			getToolBar().setPageSize(pageSize);
		}
		List<Knowledge> knowledageList=knowledgeService.getListForPage(hql, toolBar.getStartRow(), toolBar.getEndRow(),courseid);
		List<Chapter>chapterList=chapterService.findBycourse(courseid);
		ActionContext.getContext().put("knowledageList", knowledageList);
		ActionContext.getContext().put("chapterList", chapterList);
		return"tolist";
		
	}
	public String knowledgebatchDelete(){
		int size=knowledgeService.getSize(courseid);
		if(size<=0){
			return"todelete";
		}else{
			knowledgeService.batchDelete(courseid);
		}
		return "todelete";
	}
	public String delete(){
		knowledgeService.delete(id);
		return"todelete";
	}
}
