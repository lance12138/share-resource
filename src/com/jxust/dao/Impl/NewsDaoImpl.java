package com.jxust.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.News;
import com.jxust.dao.NewsDao;
@Repository
public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao{

	public String getHQL(News news) {
		
		StringBuffer sb =new StringBuffer("from News where 1=1 ");
		 if(null!=news.getTitle() && !"".equals(news.getTitle()))
			 sb.append(" and title like '%"+news.getTitle()+"%' ");
		 
        return sb.toString(); 
	}

	@SuppressWarnings("unchecked")
	public List nextPage(News news) {
		try {
			String queryString = "from News d where d.id>? order by id asc";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setLong(0,news.getId());
			queryObject.setFirstResult(0);
			queryObject.setMaxResults(1);
			return queryObject.list();
		} catch (RuntimeException re) {

			throw re;
		}
		
	}
	public List previousPage(News news){
		try{
			String queryString="from News d where d.id<? order by id desc";
			Query queryObject=getSession().createQuery(queryString);
			queryObject.setLong(0,news.getId());
			queryObject.setFirstResult(0);
			queryObject.setMaxResults(1);
			return queryObject.list();
			
		}catch(RuntimeException re){
			
			throw re;
		}
		
	}

	

}
