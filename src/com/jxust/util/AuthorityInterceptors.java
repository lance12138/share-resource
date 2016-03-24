package com.jxust.util;


import com.jxust.bean.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class AuthorityInterceptors extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		User user = (User) ActionContext.getContext().getSession().get("user");
		String namespace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();

		String privilegeUrl = null;
		if (namespace.endsWith("/")) {
			privilegeUrl = namespace + actionName;
		} else {
			privilegeUrl = namespace + "/" + actionName;
		}
		
		if (privilegeUrl.startsWith("/")) {
			privilegeUrl = privilegeUrl.substring(1);
		}
		if(user==null){
	if(privilegeUrl.startsWith("forumAction_addForumTheme")||privilegeUrl.startsWith("replyAtion")){

		return "";
		}
		}
	/*	if (user != null) {
			if(backuser==null){
			  if(!privilegeUrl.startsWith("userAction_backLogin")||privilegeUrl.startsWith("backstageAction")){
				return invocation.invoke();}// ����
			}else{
				return invocation.invoke();
			}
			 else {
				return "input";
			}
		}*/
		return invocation.invoke();// ����
	
	}

}
