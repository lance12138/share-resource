package com.jxust.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jxust.bean.Forum;
import com.jxust.bean.Messages;
import com.jxust.bean.Reply;
import com.jxust.bean.User;
import com.jxust.service.ForumService;
import com.jxust.service.MessagesService;
import com.jxust.service.ReplyService;
import com.jxust.service.UserService;
import com.jxust.util.PageToolBar;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class ReplyAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7455772705383583946L;
	private Reply reply;
    private Long forumId;
    private int inform;
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
	private int pageSize = 6;
	private int currentPage = 1;
   
	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}
	@Resource
    private ReplyService replyService;
    @Resource
    private ForumService forumService;
    @Resource
    private UserService userService;
    @Resource
    private MessagesService messagesService;
	

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}
	/**
	 * 前台分页
	 * @return
	 * @throws Exception
	 */
	public String list()throws Exception{
		//List replyList=replyService.findAll();
		Forum forum=forumService.findById(forumId);
		//Set<Reply> replyList=forum.getReplies();
		if(reply==null){
			reply=new Reply();
		}
		String hql=replyService.getHQL(reply,forumId);
		int replyCount=replyService.getQueryCount(hql);
		if(getToolBar()==null){
			setToolBar(new PageToolBar(replyCount, pageSize));
		} else {
			getToolBar().setResultsetCount(replyCount);
			getToolBar().setPageSize(pageSize);
		}
		List replyList=replyService.getListForPage(hql, toolBar
				.getStartRow(), toolBar.getEndRow());
		
		ActionContext.getContext().put("forumId", forumId);
		ActionContext.getContext().put("forum", forum);
		ActionContext.getContext().put("replyList", replyList);
		return"toList";
	}
	/**
	 * 回帖
	 * @return
	 * @throws Exception
	 */
	public String addReply()throws Exception{
		User user=(User)ActionContext.getContext().getSession().get("user");
		reply.setUser(user);
		Forum forum=forumService.findById(forumId);
		inform=forum.getUsers().getInform();//获取用户通知数
		inform=inform+1;//每有人回帖通知数就+1
		forum.getUsers().setInform(inform);
		forum.setUpdateTime(new Date());
		forumService.update(forum);
		reply.setUpdateTime(new Date());
		reply.setForum(forum);
		replyService.save(reply);
		//每回复一条记录，在message中添加一条记录
		Messages msg=new Messages();
		msg.setForumId(forumId);
		msg.setForumContent(forum.getTitle());
		msg.setMsg_content(reply.getContent());
		msg.setMsg_time(new Date());
		msg.setUserName(user.getUserName());//回帖用户信息
		msg.setUserphoto(user.getPhoto());//回帖用户信息
		msg.setUserId(forum.getUsers().getId());//保存楼主id便于消息筛选
		messagesService.save(msg);
		return"toaddReply";
	}
	/**
	 * 查看新消息
	 * @return
	 */
	public String checkInform(){
		User user=(User)ActionContext.getContext().getSession().get("user");
		String hql=messagesService.getHQL();
		int replynewsCount=messagesService.getQueryCount(hql,user.getId());
		if(getToolBar()==null){
			setToolBar(new PageToolBar(replynewsCount, pageSize));
		} else {
			getToolBar().setResultsetCount(replynewsCount);
			getToolBar().setPageSize(pageSize);
		}
		List<Messages> newReplyList=messagesService.getListForPage(hql, toolBar
				.getStartRow(), toolBar.getEndRow(),user.getId());
		
		user.setInform(0);
		userService.update(user);
		ActionContext.getContext().put("newReplyList", newReplyList);
		return"checkInform";
	}
	/**
	 * 建立长连接，每五秒钟刷新一次，实现动态消息推送
	 * @return
	 * @throws Exception
	 */
	public String longPolling()throws Exception{
		 HttpServletResponse response = ServletActionContext.getResponse();  
		 PrintWriter out=response.getWriter();
		 User ouser=(User)ActionContext.getContext().getSession().get("user");
		 if(ouser==null){
			 out.close();
			 return null;}
		 Thread longThread = new Thread() {  
		        public void run() {  
		            try {  
		                //这里模拟全局事件监听，如果其他模块有需要发送消息就发送一个事件，然后休眠停止，发送消息。  
		                sleep(5000);  
		            } catch (InterruptedException e) {  
		                e.printStackTrace();  
		            }  
		        };  
		    };  
		    longThread.run();  
		    if(ouser.getInform()>0){
		    out.print(ouser.getInform());  
		    }
		    out.flush();  
		    out.close();  
		    return null;
	}
	
	
	/**
	 * 后台回复管理
	 * @return
	 */
	public String replyManage(){
	
		Forum forum=forumService.findById(forumId);
		if(reply==null){
			reply=new Reply();
		}
		String hql=replyService.getHQL(reply,forumId);
		int replyCount=replyService.getQueryCount(hql);
		if(getToolBar()==null){
			setToolBar(new PageToolBar(replyCount, pageSize));
		} else {
			getToolBar().setResultsetCount(replyCount);
			getToolBar().setPageSize(pageSize);
		}
		List replyList=replyService.getListForPage(hql, toolBar
				.getStartRow(), toolBar.getEndRow());
		
		ActionContext.getContext().put("forumId", forumId);
		ActionContext.getContext().put("forum", forum);
		ActionContext.getContext().put("replyList", replyList);
		return"toreplyManage";
	}
	/**
	 * 单个删除回复
	 * @return
	 */
	public String delete(){
		replyService.delete(reply.getId());
		ActionContext.getContext().put("forumId", forumId);
		return"todelete";
	}
	/**
	 * 批量删除
	 * @return
	 */
	public String replybatchDelete(){
		int size=replyService.getSize(forumId);
		ActionContext.getContext().put("forumId", forumId);
		if(size<=0){
			return "toDeleteError";
		}else{
			replyService.batchDelete(forumId);
		}
		return "tobatchDelete";
	}
}
