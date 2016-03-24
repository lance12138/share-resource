package com.jxust.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.ToolBarUI;

import org.apache.commons.lang3.SystemUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jxust.bean.Course;
import com.jxust.bean.Question;
import com.jxust.service.CourseService;
import com.jxust.service.QuestionService;
import com.jxust.util.PageToolBar;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@SuppressWarnings("unchecked")
public class QuestionAction extends ActionSupport implements ModelDriven<Question>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Question question;
	
	private Course course;
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	Long updateId;
	private Long courseid;
	private String nameList;
	public String getNameList() {
		return nameList;
	}
	public void setNameList(String nameList) {
		this.nameList = nameList;
	}
	public Long getCourseid() {
		return courseid;
	}
	public void setCourseid(Long courseid) {
		this.courseid = courseid;
	}
	public void setUpdateId(Long updateId) {
		this.updateId = updateId;
	}
	public Long getUpdateId() {
		return updateId;
	}
	Long questionid[]=new Long[50];
	public Long[] getQuestionid() {
		return questionid;
	}
	public void setQuestionid(Long[] questionid) {
		this.questionid = questionid;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	@Resource
	QuestionService questionService;
	@Resource
	CourseService courseService;
	private PageToolBar toolBar;
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
	private int pageSize = 5;
	private int currentPage = 1;
	//加载数据，随机组成一套题目
	
	public String addList()throws Exception{
		//course=(Course) ActionContext.getContext().getApplication().get("course");
		course=courseService.findById(courseid);
		List<Question> singleQuestionList=new ArrayList<Question>();
		List<Question> multiQuestionList=new ArrayList<Question>();
		List<Question> trueOrFalseList=new ArrayList<Question>();
	
		
		 singleQuestionList=questionService.getBygrade(1,courseid);
		 multiQuestionList=questionService.getBygrade(2,courseid);
		 trueOrFalseList=questionService.getBygrade(3,courseid);
		
		  ActionContext.getContext().put("singleQuestionList", singleQuestionList);
		  ActionContext.getContext().put("multiQuestionList", multiQuestionList);
		  ActionContext.getContext().put("trueOrFalseList", trueOrFalseList);
		  return "toaddList";
	}
//校验答案并算出分数
	
	public String validateAnswer()throws Exception{
		int j=0;
		List ErrorResult=new ArrayList();
		List ErrorSingleQuestion=new ArrayList();
		List ErrorMultiQuestion=new ArrayList();
		List ErrorJudegmentQuestion=new ArrayList();
		if(question==null){
		  j=0;
		  ActionContext.getContext().put("ErrorResult", questionid); 
		}
		else{
		String[] q=question.getAnswerS();
		
	
	
		for (int i = 0; i < questionid.length; i++) {
			int s=questionid[i].intValue();
			Question questions=questionService.findById(questionid[i]);
			if(q[s]==null){
				q[s]="cuo";}
			q[s]=q[s].replaceAll(", ","");
			if(questions.getAnswer().equals(q[s])){
			if(questions.getQuestionType().equals("1")){//按题目类型计算分数
				j=j+2;
			}else if(questions.getQuestionType().equals("2")){
				j=j+4;
			}else if(questions.getQuestionType().equals("3")){
				j=j+1;
			}
			}else{
				questions.setErrorAnswer(q[s]);//错答案添加
				if(questions.getQuestionType().equals("1")){
					ErrorSingleQuestion.add(questions);
				}else if(questions.getQuestionType().equals("2")){
					ErrorMultiQuestion.add(questions);
				}else if(questions.getQuestionType().equals("3")){
					ErrorJudegmentQuestion.add(questions);
				}	
				ErrorResult.add(q[s]);	
				}
		}
		ActionContext.getContext().put("ErrorResult", ErrorResult);
		ActionContext.getContext().put("ErrorSingleQuestion", ErrorSingleQuestion);
		ActionContext.getContext().put("ErrorMultiQuestion", ErrorMultiQuestion);
		ActionContext.getContext().put("ErrorJudegmentQuestion", ErrorJudegmentQuestion);
		}
		ActionContext.getContext().put("result", j);
		
	return "toResult";	
	}
	public void model(){
		List<Course> courseNameList=courseService.findAll();
		ActionContext.getContext().put("courseNameList", courseNameList);
	}
	public String enterAddQuestion()throws Exception{
		model();
		return "toEnterAdd";
	}
	//后台添加测试题目
	public String addQuestion()throws Exception{
		if(question==null){
			ActionContext.getContext().put("questionError", "请勿提交空信息！");
			return "addQuestionError";
		}
		if(question.getQuestion()==null||question.getQuestion().isEmpty()){
			ActionContext.getContext().put("topicError", "题目不能为空！");
			return "addQuestionError";
		}
		if(question.getQuestionType()==null||question.getQuestionType().isEmpty()){
			ActionContext.getContext().put("typeError", "题目类型不能为空！");
			return "addQuestionError";
		}
		if(Integer.parseInt(question.getQuestionType())<3){
		if(question.getOption_A()==null||question.getOption_A().isEmpty()||
				question.getOption_B()==null||question.getOption_B().isEmpty()||
				question.getOption_C()==null||question.getOption_C().isEmpty()||
				question.getOption_D()==null||question.getOption_D().isEmpty()){
			ActionContext.getContext().put("answerError", "题目选项不能为空！");
			return "addQuestionError";
		    }
		}
		if(question.getAnswer()==null){
			ActionContext.getContext().put("resultError", "题目正确答案不能为空！");
			return "addQuestionError";
		}
		Course c=courseService.findBytitle(course.getName());
		question.setCourse(c);
		questionService.save(question);
		return "toaddQuestion";
	}
	
	public String questionManage()throws Exception{
		Long courseID=null;
		model();
		if(question==null){
			question=new Question();
		}
		if(nameList!=null&&!nameList.equals("0")){
			Course course=courseService.findBytitle(nameList);
			courseID=course.getId();
		}
		String hql=questionService.getHQL(courseID);
		int count=questionService.getByHQL(hql).size();
	
		if(getToolBar()==null){
			setToolBar(new PageToolBar(count,pageSize));
		}else{
			   getToolBar().setResultsetCount(count);
				getToolBar().setPageSize(pageSize);
		   }
		List questionsList=questionService.getListForPageCommon(hql,toolBar.getStartRow(), toolBar.getEndRow());
		ActionContext.getContext().put("questionsList", questionsList);
		return "toquestionManage";
	}
	//后台进入题目修改页面
	public String questionEdit()throws Exception{
		question=questionService.findById(updateId);
		ActionContext.getContext().put("updateId", updateId);
		return "toquestionEdit";
	}
	public String questionbatchDelete(){
		int size=questionService.getSize(courseid);
		   if(size<=0){
			   return "questiondeleteError";
		   }else{
			   questionService.batchDelete(courseid);
		   }
		   return"questiondelete";
	}
	//后台删除题目
	public String questionDelete()throws Exception{
	
		questionService.delete(updateId);
		return "toquestionDelete";
	}
	//后台修改题目
	public String updateQuestion()throws Exception{
		
		question.setId(updateId);
		questionService.update(question);
		ActionContext.getContext().put("updateId", updateId);
		return "toupdateQuestion";
	}
	public Question getModel() {
		// TODO Auto-generated method stub
		return question;
	}
	
}
