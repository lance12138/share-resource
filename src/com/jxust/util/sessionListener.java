package com.jxust.util;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.jxust.bean.User;

@SuppressWarnings("unchecked")
public class sessionListener implements HttpSessionAttributeListener{
	public static List list = new ArrayList();  
	
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getName().equals("user")){
			User user=(User)arg0.getValue();
			list.add(user);
		}
		
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		 try {  
	            int n = 0;  
	            User u=null;
	            if(arg0.getName().equals("user")){
	             u = (User) arg0.getValue();  
	            }
	            for (int i = 0; i < list.size(); i++) {  
	                User user = (User) list.get(i);  
	                if (u.getId().equals(user.getId())) {  
	                    n = i;  
	                    break;  
	                }  
	            }  
	            list.remove(n);  
	        } catch (Exception e) {  
	        }  
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	}
