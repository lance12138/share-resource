package com.jxust.util;



import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import com.jxust.bean.User;






public class FckeditorFilter extends StrutsPrepareAndExecuteFilter {

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;		   
        HttpServletResponse response = (HttpServletResponse) res;        
       HttpSession session = request.getSession();      
        String url=request.getServletPath(); 
        String contextPath=request.getContextPath();
        User ouser=(User)session.getAttribute("user");
        if(url.equals("")) url+="/";   
        
        if(((url.startsWith("/")&&url.startsWith("/backstage")&&!url.startsWith("/backstage/outline"))||url.startsWith("/newsAction_list")
        		||url.startsWith("/activityAction_activityManage")||url.startsWith("/courseAction_list")||url.startsWith("/courseAction_*List")||url.startsWith("/preCourseAction_addpreUI")
        		||url.startsWith("/errorAnalyseAction_addUI")||url.startsWith("/errorAnalyseAction_errorAnalyseManage")||url.startsWith("/questionAction_enterAddQuestion")
        		||url.startsWith("/teachTeamAction_addList")||url.startsWith("/*_*Manage")||url.startsWith("/teachTeamAction_addTeachTopic")
        		||url.startsWith("/teachTeamAction_add*UI")||url.startsWith("/resourceAction_*List")||url.startsWith("/resourceAction_list")||url.startsWith("/knowledgeAction_addUI"))){
        	User user=(User) session.getAttribute("backUser"); 
        if(user==null){
        	   response.sendRedirect(contextPath+"/backLogin.jsp");   
               return;    
        }
        }

        if(url.startsWith("/forumAction_addForumTheme")||url.startsWith("/replyAction_list")){
        	if(ouser==null){
        		response.sendRedirect(contextPath+"/forumAction_list?bbs=3");
        		return;
        	}
        }

      if((url.startsWith("/VerifyCodeServlet")||url.contains("/controller"))){   
        
    	  chain.doFilter(req, res);
        } else {
			super.doFilter(req, res, chain);

		}

	
	}

}
