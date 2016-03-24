package com.jxust.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.Video;
import com.jxust.dao.VideoDao;

@Repository
public class VideoDaoImpl extends BaseDaoImpl<Video> implements VideoDao{

	public List<Video> findBygrade(Long grade) {
		try {
			String queryString = "from Video  where grade=0 and courseId=?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setLong(0,grade);
			return   queryObject.list();
		} catch (RuntimeException re) {

			throw re;
		}

	}
	public List<Video> getByCourse(Long courseId){
		
			String queryString = "from Video  where courseId=? and grade=1";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setLong(0,courseId);
			return   queryObject.list();
		
	}
	public String getHQL(Video video,Long cid) {
		StringBuffer sb =new StringBuffer("from Video where 1=1 ");
		 if(cid!=null){
			 sb.append(" and courseId="+cid);
		 }
	
      return sb.toString(); 
	}
	
}

	
