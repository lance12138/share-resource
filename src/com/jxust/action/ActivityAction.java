package com.jxust.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.jxust.bean.Activity;
import com.jxust.service.ActivityService;
import com.jxust.util.PageToolBar;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class ActivityAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Activity activity;
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	@Resource
	private ActivityService activityService;
	
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


	/**
	 * 进入activity教研活动页面
	 * @return
	 */
	public String addUI(){
		List<Activity> acList=activityService.findAll();
		ActionContext.getContext().put("acList", acList);
		ActionContext.getContext().put("count", acList.size());
		return"enterUI";
	}
	/**
	 * 后台添加教研活动
	 * @return
	 */
	public String addActivity(){
	
		if(activity.getAc_name()==null||activity.getAc_name().isEmpty()){
			ActionContext.getContext().put("nameError", "教研活动名称不可为空！");
			return"addAcError";
		}
		if(activity.getAc_author()==null||activity.getAc_author().isEmpty()){
			ActionContext.getContext().put("authorError", "作者不可为空！");
			return"addAcError";
		}
		if(activity.getAc_content()==null||activity.getAc_content().isEmpty()){
			ActionContext.getContext().put("contentError", "教研活动内容不可为空！");
			return"addAcError";
		}
		activity.setAc_time(new Date());
		activityService.save(activity);
		ActionContext.getContext().put("msg", "教研活动添加成功！");
		return"toadd";
	}
	/**
	 * 进入教研活动查看
	 * @return
	 */
	public String edit(){
		Activity ac=activityService.findById(activity.getAc_id());
		Activity preAC=activityService.previousPage(ac);
		Activity nextAC=activityService.nextPage(ac);
		ActionContext.getContext().put("ac", ac);
		ActionContext.getContext().put("preAC", preAC);
		ActionContext.getContext().put("nextAC", nextAC);
		return"acEdit";
	}
	public String ac_delete(){
		activityService.delete(activity.getAc_id());
		return "ac_delete";
	}
	
	public String ac_deleteAll(){
		List<Activity> acList=activityService.findAll();
		for(Activity ac:acList)
		{
			activityService.delete(ac.getAc_id());
		}
		return"ac_deleteAll";
	}
	public String acManage(){
		
		String hql=activityService.getHQL(activity);
		int count=activityService.findByHQL(hql);
		if(getToolBar()==null){
			setToolBar(new PageToolBar(count,pageSize));
		}else{
			getToolBar().setResultsetCount(count);
			getToolBar().setPageSize(pageSize);
			}
		List<Activity> activityList=activityService.getListForPage(hql, toolBar.getStartRow(), toolBar.getEndRow());
		ActionContext.getContext().put("activityList", activityList);
		return "acManage";
	}
}
