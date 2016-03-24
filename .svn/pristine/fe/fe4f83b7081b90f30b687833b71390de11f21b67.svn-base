package com.jxust.dao.Impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.Homework;
import com.jxust.dao.HomeworkDao;
@Repository
public class HomeworkDaoImpl extends BaseDaoImpl<Homework> implements HomeworkDao{

	public String getQueryHQL(Homework homework,String select) {
		StringBuffer sb =new StringBuffer("from Homework where 1=1 ");
		
		if(null!=homework.getSearch() && !"".equals(homework.getSearch()))
			 sb.append(" and "+select+" like '%"+homework.getSearch()+"%' ");
		return sb.toString();
	}
	public void batchDelete(){
		Query query=getSession().createQuery("from Homework");
		List<Homework> homeList=query.list();
		for (Iterator iterator = homeList.iterator(); iterator.hasNext();) {
			Homework homework = (Homework) iterator.next();
			getSession().delete(homework);
		}
	}
}
