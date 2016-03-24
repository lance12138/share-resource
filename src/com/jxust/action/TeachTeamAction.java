package com.jxust.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jxust.bean.Course;
import com.jxust.bean.TeachMaterial;
import com.jxust.bean.TeachTeam;
import com.jxust.bean.TeachTopic;
import com.jxust.bean.TeamHonor;
import com.jxust.bean.Thesis;
import com.jxust.service.CourseService;
import com.jxust.service.TeachMaterialService;
import com.jxust.service.TeachTeamService;
import com.jxust.service.TeachTopicService;
import com.jxust.service.TeamHonorService;
import com.jxust.service.ThesisService;
import com.jxust.util.PageToolBar;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class TeachTeamAction extends ActionSupport implements ModelDriven<TeachTeam>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TeachTeam teachTeam;
	private TeachTopic teachTopic;
	private Thesis thesis;
	private TeachMaterial material;
	public TeachMaterial getMaterial() {
		return material;
	}
	public void setMaterial(TeachMaterial material) {
		this.material = material;
	}
	public TeamHonor getHonor() {
		return honor;
	}
	public void setHonor(TeamHonor honor) {
		this.honor = honor;
	}
	private TeamHonor honor;
	public Thesis getThesis() {
		return thesis;
	}
	public void setThesis(Thesis thesis) {
		this.thesis = thesis;
	}
	public TeachTopic getTeachTopic() {
		return teachTopic;
	}
	public void setTeachTopic(TeachTopic teachTopic) {
		this.teachTopic = teachTopic;
	}
	Long courseid;
	private Long id;
	private String courseOfTopic;
	public String getCourseOfTopic() {
		return courseOfTopic;
	}
	public void setCourseOfTopic(String courseOfTopic) {
		this.courseOfTopic = courseOfTopic;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	String teachCourse;
	@Resource
	private TeachTeamService teachTeamService;
	@Resource
	private CourseService courseService;
	@Resource
	private TeachTopicService teachTopicService;
	@Resource
	private ThesisService thesisService;
	@Resource
	private TeachMaterialService teachMaterialService;
	@Resource
	private TeamHonorService teamHonorService;
	private String  photoContentType;
	private File photo;
	private String photoFileName;
	
	
	private PageToolBar toolBar;
	private int pageSize = 6;
	private int currentPage = 1;
	
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
	public String getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public TeachTeam getTeachTeam() {
		return teachTeam;
	}
	public void setTeachTeam(TeachTeam teachTeam) {
		this.teachTeam = teachTeam;
	}
	public String getTeachCourse() {
		return teachCourse;
	}
	public void setTeachCourse(String teachCourse) {
		this.teachCourse = teachCourse;
	}
	public TeachTeam getModel() {
		// TODO Auto-generated method stub
		return teachTeam;
	}
	public Long getCourseid() {
		return courseid;
	}
	public void setCourseid(Long courseid) {
		this.courseid = courseid;
	}
	/*public TeachTeam getModel() {
		// TODO Auto-generated method stub
		return teachTeam;
	}*/
	
	/*
	 * 前台进入教学团队
	 * 
	 * */
	public String addUI(){
	Course course=courseService.findById(courseid);
	Set<TeachTeam> teacherList=course.getCourseTeacher();
	/* TeachTeam teachTeam=teachTeamService.finById(course.getManagerId());
		*/
	for (Iterator iterator = teacherList.iterator(); iterator.hasNext();) {
		TeachTeam teachTeam = (TeachTeam) iterator.next();
		if(teachTeam.getManager()!=null){
			ActionContext.getContext().put("TeamManager", teachTeam);
		}
	}
	
	ActionContext.getContext().put("course", course);
	ActionContext.getContext().put("teacherList", teacherList);
	//加入研究课题
	addTopicUI();
	addThesis();
	enterMaterial();
	enterHonor();
	return"toaddUI";
}
	/*
	 * 
	 * 后台数据填充(课程选择下拉框),为进入页面做准备
	 * */
	public String addList(){
	ListModel();
	return"toaddList";
}
 public void ListModel(){
	 List<Course> courseList=courseService.findAll();
		ActionContext.getContext().put("courseList", courseList);
	 
 } 
 /*
  * 后台添加教学团队
  * */
 	public String addTeacherTeam()throws Exception{
 	
	FileOutputStream fos=null;
	FileInputStream fis=null;
	String[] q=teachTeam.getChooseCourse();
	ActionContext.getContext().put("payment", q);
	/*Integer[] m=teachTeam.getChooseManager();*/
	
	if(q==null){
		ActionContext.getContext().put("courseError", "请选择教授课程！");
		ListModel();
		return"addError";
	}
	if(teachTeam.getTeacherName()==null||teachTeam.getTeacherName().isEmpty()){
		ActionContext.getContext().put("nameError", "教师姓名不可为空！");
		ListModel();
		return"addError";
	}
	if(teachTeam.getBirthday()==null||teachTeam.getBirthday().isEmpty()){
		ActionContext.getContext().put("birthdayError", "出生年月不可为空！");
		ListModel();
		return"addError";
	}
	if(teachTeam.getDiploma()==null||teachTeam.getDiploma().isEmpty()){
		ActionContext.getContext().put("diplomaError", "专业技术职务不可为空！");
		ListModel();
		return"addError";
	}
	if(teachTeam.getCourseMajor()==null||teachTeam.getCourseMajor().isEmpty()){
		ActionContext.getContext().put("majorError", "学科专业不可为空！");
		ListModel();
		return"addError";
	}
	if(teachTeam.getJob()==null||teachTeam.getJob().isEmpty()){
		ActionContext.getContext().put("jobError", "课程中承担的工作不可为空！");
		ListModel();
		return"addError";
	}
	boolean flag=false;
	//判断该门课的课程负责人是否唯一，如果有课程负责人不允许再将其他人员设为课程负责人
	for (int i = 0; i < teachTeam.getChooseCourse().length; i++) {
		if(q[i]!=null){
	      
		Course course=courseService.findBytitle(q[i]);
	
		Set<TeachTeam> teachList=course.getCourseTeacher();
		
		for (Iterator iterator = teachList.iterator(); iterator.hasNext();) {
			TeachTeam teachTeam = (TeachTeam) iterator.next();
			
			if(teachTeam.getManager()!=null){
				flag=true;
			}
		}
		if(teachTeam.getManager()!=null){
		if(flag){
				ActionContext.getContext().put("managerError", "每门课程中课程负责人只有一个，课程负责人已有人选!请重新选择!");
				ListModel();
				return "addError";
		}
		}
	}
	}
	if(photo!=null){
		try{
		String path=ServletActionContext.getServletContext().getRealPath("images/teachers");
		fis=new FileInputStream(photo);
		fos=new FileOutputStream(path+"\\"+photoFileName);
		byte[]buffer=new byte[1024];
		int length=0;
		while((length=fis.read(buffer))!=-1){
			fos.write(buffer, 0, length);
		}
		}catch(Exception e){
			ListModel();
			ActionContext.getContext().put("uploadError", "上传文件出错,请重新上传");
			return"uploadError";
		}
		finally{
			if(fis!=null){
				fis.close();
			}
			if(fos!=null){
				fos.close();
			}
		}
		teachTeam.setSelf_photo(photoFileName);
	}
	//course.getCourseTeacher().add(teachTeam);
	for (int i = 0; i < q.length; i++) {
		if(q[i]!=null){
		Course course=courseService.findBytitle(q[i]);
		teachTeam.getTeamCourse().add(course);
		}
	}
	ActionContext.getContext().put("teacher", teachTeam);
	teachTeamService.save(teachTeam);
	ListModel();
	List<String> qq=new ArrayList<String>();
	
	Set<Course> courseChoice=teachTeam.getTeamCourse();
	for (Iterator iterator = courseChoice.iterator(); iterator.hasNext();) {
		Course course = (Course) iterator.next();
		qq.add(course.getName());
	}
	ActionContext.getContext().put("manage", teachTeam.getManager());
	ActionContext.getContext().put("courseCh", q);
	return"toaddTeacher";
}
 	
 	/*
 	 * 
 	 * 后台师资队伍管理
 	 * */
 	public String teamManage(){
 		ListModel();
 		List teachersList=teachTeamService.findAll();
 		ActionContext.getContext().put("teachersList", teachersList);
 		
 		return "toTeamManage";
 	}
 	/**
 	 * 批量删除teacher
 	 * @return
 	 */
 	public String teambatchDelete(){
 		
 		 Course course=courseService.findById(courseid);
 		 Set<TeachTeam>teachTeamList=course.getCourseTeacher();
 		 for (Iterator iterator = teachTeamList.iterator(); iterator.hasNext();) {
			TeachTeam teachTeam = (TeachTeam) iterator.next();
			teachTeamService.delete(teachTeam.getId());
		}
		 
		   return"teamdelete";
 	}
 	/**
 	 * 批量删除topic
 	 * @return
 	 */
 	public String topicbatchDelete(){
 		
 		 int size=teachTopicService.getSize(courseid);
		   if(size<=0){
			   return "topicdeleteError";
		   }else{
			   teachTopicService.batchDelete(courseid);
		   }
		   return"topicdelete";
 	}
 	/**
 	 * 批量删除论文
 	 * @return
 	 */
 	public String thesisbatchDelete(){
 		int size=thesisService.getSize(courseid);
		   if(size<=0){
			   return "thesisdeleteError";
		   }else{
			   thesisService.batchDelete(courseid);
		   }
		   return"thesisdelete";
 	}
 	/*
 	 * 通过课程查找
 	 * */
 	public String getTeam(){
 		ListModel();
 		Course course=courseService.findBytitle(teachCourse);
 		Set<TeachTeam> teachersList=course.getCourseTeacher();
 		ActionContext.getContext().put("teachersList", teachersList);
 		return "togetTeam";
 	}
 	/*
 	 * 删除成员
 	 * */
	public String teamDelete(){
		teachTeamService.delete(id);
		ListModel();
		return"toTeamDelete";
	}
	/*
	编辑成员信息
	*
	*/
	public String Edit(){
		ListModel();
		List<String> q=new ArrayList<String>();
		TeachTeam teacher=teachTeamService.finById(id);
		Set<Course> courseChoice=teacher.getTeamCourse();
		for (Iterator iterator = courseChoice.iterator(); iterator.hasNext();) {
			Course course = (Course) iterator.next();
			q.add(course.getName());
		}
		ActionContext.getContext().put("manage", teacher.getManager());
		ActionContext.getContext().put("courseCh", q);
		ActionContext.getContext().put("teacher", teacher);
		return"toEdit";
	}
	/*
	 * 更新成员信息
	 * */
	public String updateTeacherTeam() throws Exception{
		FileOutputStream fos=null;
		FileInputStream fis=null;
		String[] q=teachTeam.getChooseCourse();
		if(teachTeam.getTeacherName()==null||teachTeam.getTeacherName().isEmpty()){
			ActionContext.getContext().put("nameError", "教师姓名不可为空！");
			ListModel();
			return"editError";
		}
		if(teachTeam.getBirthday()==null||teachTeam.getBirthday().isEmpty()){
			ActionContext.getContext().put("birthdayError", "出生年月不可为空！");
			ListModel();
			return"editError";
		}
		if(teachTeam.getDiploma()==null||teachTeam.getDiploma().isEmpty()){
			ActionContext.getContext().put("diplomaError", "专业技术职务不可为空！");
			ListModel();
			return"editError";
		}
		if(teachTeam.getCourseMajor()==null||teachTeam.getCourseMajor().isEmpty()){
			ActionContext.getContext().put("majorError", "学科专业不可为空！");
			ListModel();
			return"editError";
		}
		if(teachTeam.getJob()==null||teachTeam.getJob().isEmpty()){
			ActionContext.getContext().put("jobError", "课程中承担的工作不可为空！");
			ListModel();
			return"editError";
		}
		TeachTeam teach=teachTeamService.finById(id);//通过id获取teacher对象
		boolean flag=false;
		//判断该门课的课程负责人是否唯一，如果有课程负责人不允许再将其他人员设为课程负责人
		for (int i = 0; i < teachTeam.getChooseCourse().length; i++) {
			if(q[i]!=null){
		
			Course course=courseService.findBytitle(q[i]);
		
			Set<TeachTeam> teachList=course.getCourseTeacher();
			
			for (Iterator iterator = teachList.iterator(); iterator.hasNext();) {
				TeachTeam teachTeam = (TeachTeam) iterator.next();
				if(teachTeam.getManager()!=null){
					flag=true;
				}
			}
			if(teachTeam.getManager()!=null){
			if(flag){
				
					ActionContext.getContext().put("managerError", "课程负责人已有人选!要修改请先将之前负责人负责状态修改为否！");
					ListModel();
					return "addError";
			}
			}
			
		}
		}
		
		if(photo!=null){
			try{
			String path=ServletActionContext.getServletContext().getRealPath("images/teachers");
			fis=new FileInputStream(photo);
			fos=new FileOutputStream(path+"\\"+photoFileName);
			byte[]buffer=new byte[1024];
			int length=0;
			while((length=fis.read(buffer))!=-1){
				fos.write(buffer, 0, length);
			}
			}catch(Exception e){
				ListModel();
				ActionContext.getContext().put("uploadError", "上传文件出错,请重新上传");
				return"uploadError";
			}
			finally{
				if(fis!=null){
					fis.close();
				}
				if(fos!=null){
					fos.close();
				}
			}
			teach.setSelf_photo(photoFileName);
		}
		
		
		/*
		 * 因为teachTeam与course多对多，无法在修改的时候再让管理员通过下拉菜单的形式修改该教师
		 * 教授的课程，因为可能该老师教授多门课，所以通过页面传来的teachTeam对象来修改teach对象
		 * */
		teach.setBirthday(teachTeam.getBirthday());
		teach.setCourseMajor(teachTeam.getCourseMajor());
		teach.setDiploma(teachTeam.getDiploma());
		teach.setEvaluate(teachTeam.getEvaluate());
		teach.setForeignMeeting(teachTeam.getForeignMeeting());
		teach.setJob(teachTeam.getJob());
		teach.setSex(teachTeam.getSex());
		teach.setManager(teachTeam.getManager());
		teach.setTeacherName(teachTeam.getTeacherName());
		
		teachTeamService.update(teach);
		return "toUpdate";
	}
	//前台为进入师资队伍准备数据
	public void addTopicUI(){

		List<TeachTopic> topicList=teachTopicService.findByCourse(courseid);
	
		ActionContext.getContext().put("topicList", topicList);
	}
	//后台进入添加课题准备数据
	public String addTeachTopic(){
		ListModel();
		return "toaddTeachTopic";
	}
	//添加一条新课题
	public String uploadTopic(){
		if(teachTopic.getProjectName()==null||teachTopic.getProjectName().isEmpty()){
			ActionContext.getContext().put("nameError", "课题名不可为空！");
			ListModel();
			return"touploadError";
		}
		if(teachTopic.getProjectSource()==null||teachTopic.getProjectSource().isEmpty()){
			ActionContext.getContext().put("sourceError", "项目来源不可为空！");
			ListModel();
			return"touploadError";
		}
		if(teachTopic.getStartTime()==null||teachTopic.getStartTime().isEmpty()){
			ListModel();
			ActionContext.getContext().put("timeError", "起止时间不可为空！");
			return"touploadError";
		}
		if(teachTopic.getAuthor()==null||teachTopic.getAuthor().isEmpty()){
			ListModel();
			ActionContext.getContext().put("authorError", "作者不可为空！");
			return"touploadError";
		}
		
		Course course=courseService.findBytitle(courseOfTopic);
		teachTopic.setCourseId(course.getId());
		teachTopicService.save(teachTopic);
		return"touploadTopic";
	}
	//添加课题选择二级联动
	public Set<TeachTeam> getTeachTeamList(String name)throws Exception{
		Course course=courseService.findBytitle(name);
		
	   Set<TeachTeam>TeachTeamList=course.getCourseTeacher();
	  
	   return TeachTeamList;
		
	}
	//课改课题管理
	public String teachTopicManager()throws Exception{
		ListModel();
		if(teachTopic==null){
			teachTopic=new TeachTopic();
		}
		Long courseID=null;
		if(courseOfTopic!=null){
		Course course=courseService.findBytitle(courseOfTopic);
		 courseID=course.getId();
		}
		String hql=teachTopicService.getQueryHQL(courseID);
		int topicCount=teachTopicService.getCountByHQL(hql,courseID);
		 if(getToolBar()==null){
			   setToolBar(new PageToolBar(topicCount,pageSize));
			   
		   }
		   else{
			   getToolBar().setResultsetCount(topicCount);
				getToolBar().setPageSize(pageSize);
		   }
		 List<TeachTopic> topicList=teachTopicService.getListForPage(hql, toolBar.getStartRow(), toolBar.getEndRow(),courseID);
	ActionContext.getContext().put("topicList", topicList);
		 return "tomanage";
	}
	//删除teamTopic
	public String deleteTopic()throws Exception{
		teachTopicService.delete(id);
		
		return "todeleteTopic";
	}
	//准备研究论文
	public void addThesis(){
		//Course course=courseService.findById(courseid);
		//Set<Thesis> thesisList=course.getCourseThesis();
		List<Thesis> thesisList=thesisService.findByCourse(courseid);
		ActionContext.getContext().put("thesisList", thesisList);
		
	}
	//后台进入添加thesis
	public String addThesisUI(){
		ListModel();
		return"toaddThesisUI";
	}
	//添加研究论文
	public String uploadThesis()throws Exception{
		if(thesis.getThesisName()==null||thesis.getThesisName().isEmpty()){
			ActionContext.getContext().put("thesisError", "论文名不可为空！");
			ListModel();
			return"toThesisError";
		}
		if(thesis.getIssue()==null||thesis.getIssue().isEmpty()){
			ActionContext.getContext().put("issueError", "发表期刊不可为空！");
			ListModel();
			return"toThesisError";
		}
		if(thesis.getStudyTime()==null||thesis.getStudyTime().isEmpty()){
			ListModel();
			ActionContext.getContext().put("timeError", "研究时间不可为空！");
			return"toThesisError";
		}
		if(thesis.getAuthor()==null||thesis.getAuthor().isEmpty()){
			ListModel();
			ActionContext.getContext().put("authorError", "作者不可为空！");
			return"toThesisError";
		}
		if(thesis.getPosition()==null||thesis.getPosition().isEmpty()){
			ListModel();
			ActionContext.getContext().put("positionError", "名次不可为空！");
			return"toThesisError";
		}
		Course course=courseService.findBytitle(courseOfTopic);
		thesis.setCourseId(course.getId());
		thesisService.save(thesis);
		return "toaddThesis";
	}
	/**
	 * 论文管理
	 * @return
	 * @throws Exception
	 */
	public String thesisManage()throws Exception{
		ListModel();
		if(thesis==null){
			thesis=new Thesis();
		}
		Long courseID=null;
		if(courseOfTopic!=null){
		Course course=courseService.findBytitle(courseOfTopic);
		 courseID=course.getId();
		}
		String hql=thesisService.getQueryHQL(courseID);
		int thesisCount=thesisService.getCountByHQL(hql,courseID);
		 if(getToolBar()==null){
			   setToolBar(new PageToolBar(thesisCount,pageSize));
			   
		   }
		   else{
			   getToolBar().setResultsetCount(thesisCount);
				getToolBar().setPageSize(pageSize);
		   }
		 List<Thesis> thesisList=thesisService.getListForPage(hql, toolBar.getStartRow(), toolBar.getEndRow(),courseID);
	ActionContext.getContext().put("thesisList", thesisList);
		 return "toThesismanage";
		
	}
	/**
	 * 删除论文
	 * @return
	 * @throws Exception
	 */
	public String deleteThesis()throws Exception{
		thesisService.delete(id);
		
		return"todeleteThesis";
	}
	public String addMaterialUI(){
		ListModel();
		return"tomaterialUI";
	}
	/**
	 * 添加出版教材
	 * @return
	 */
	public String uploadMaterial(){
		ListModel();
		if(material.getMaterialName()==null||material.getMaterialName().isEmpty()){
			ActionContext.getContext().put("materialnameError", "出版教材名不可为空！");
			return"addmaterialError";
		}
		if(material.getProduct()==null||material.getProduct().isEmpty()){
			ActionContext.getContext().put("productError", "出版社不可为空！");
			return"addmaterialError";
		}
		if(material.getProductTime()==null||material.getProductTime().isEmpty()){
			ActionContext.getContext().put("timeError", "出版时间不可为空！");
			return"addmaterialError";
		}
		if(material.getCourseId()==null){
			ActionContext.getContext().put("courseError", "请选择所属课程！");
			return"addmaterialError";
		}
		if(material.getUsingCount()==null||material.getUsingCount().isEmpty()){
			ActionContext.getContext().put("usingCountError", "使用人数不可为空！");
			return"addmaterialError";
		}
		teachMaterialService.save(material);
		ActionContext.getContext().put("materialmsg", "出版教材添加成功");
		return"touploadMaterial";
	}
	public void enterMaterial(){
		List<TeachMaterial> maList=teachMaterialService.findByCourse(courseid);
		ActionContext.getContext().put("maList", maList);
	}
	public void enterHonor(){
		List<TeamHonor> hoList=teamHonorService.findByCourse(courseid);
		ActionContext.getContext().put("hoList", hoList);
	}
	/**
	 * 出版教材管理
	 * @return
	 */
	public String materialManage(){
		ListModel();
		if(material==null){
			material=new TeachMaterial();
		}
		String hql=teachMaterialService.getHQL(courseid);
		int count=teachMaterialService.getCountByHQL(hql);
		if(getToolBar()==null){
			 setToolBar(new PageToolBar(count,pageSize));
			   
		   }
		   else{
			   getToolBar().setResultsetCount(count);
				getToolBar().setPageSize(pageSize);
		   }
		List<TeachMaterial> materialList=teachMaterialService.getListForPage(hql, toolBar.getStartRow(), toolBar.getEndRow());
		ActionContext.getContext().put("materialList", materialList);
		return "tomaterialManage";
	}
	/**
	 * 删除发表教材
	 * @return
	 */
	public String deleteMaterial(){
		teachMaterialService.delete(id);
		return"todeleteMaterial";
	}
	/**
	 * 删除获奖情况
	 * @return
	 */
	public String deleteHonor(){
		teamHonorService.delete(id);
		return"todeleteHonor";
	}
	/**
	 * 批量删除发表教材
	 * @return
	 */
	public String materialbatchDelete(){
		int size=teachMaterialService.getSize(courseid);
		if(size<=0){
			return"materialDeleteError";
		}else{
			teachMaterialService.batchDelete(courseid);
		}
		return"tomaterialbatch";
	}
	/**
	 * 批量删除获奖情况
	 * @return
	 */
	public String honorbatchDelete(){
		int size=teamHonorService.getSize(courseid);
		if(size<=0){
			return"honorDeleteError";
		}else{
			teamHonorService.batchDelete(courseid);
		}
		return"tohonorbatch";
	}
	/**
	 * 进入添加获奖情况
	 * @return
	 */
	public String addHonorUI(){
		ListModel();
		return"toaddHonorUI";
	}
	/**
	 * 添加获奖情况
	 * @return
	 */
	public String uploadHonor(){
		ListModel();
		if(honor.getProject()==null||honor.getProject().isEmpty()){
			ActionContext.getContext().put("projectError", "获奖项目不可为空！");
			return"toaddHonorError";
		}
		
		if(honor.getDepartment()==null||honor.getDepartment().isEmpty()){
			ActionContext.getContext().put("departmentError", "授奖部门不可为空！");
			return"toaddHonorError";
		}
		if(honor.getTime()==null||honor.getTime().isEmpty()){
			ActionContext.getContext().put("timeError", "获奖时间不可为空！");
			return"toaddHonorError";
		}
		teamHonorService.save(honor);
		ActionContext.getContext().put("honormsg", "出版教材添加成功");
		return"touploadHonor";
	}
	/**
	 * 获奖情况管理
	 * @return
	 */
	public String honorManage(){
		ListModel();
		if(honor==null){
			honor=new TeamHonor();
		}
		String hql=teamHonorService.getHQL(courseid);
		int count=teamHonorService.getCountByHQL(hql);
		if(getToolBar()==null){
			 setToolBar(new PageToolBar(count,pageSize));
			   
		   }
		   else{
			   getToolBar().setResultsetCount(count);
				getToolBar().setPageSize(pageSize);
		   }
		List<TeamHonor> honorList=teamHonorService.getListForPage(hql, toolBar.getStartRow(), toolBar.getEndRow());
		ActionContext.getContext().put("honorList", honorList);
		return "tohonorManage";
	}
}
