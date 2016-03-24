package com.jxust.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.TeachTopic;
import com.jxust.dao.TeachTopicDao;
@Repository
public class TeachTopicDaoImpl extends BaseDaoImpl<TeachTopic> implements TeachTopicDao{

	public String getQueryHQL(Long courseID) {
		StringBuffer sb=new StringBuffer("from TeachTopic where 1=1 ");
		if(courseID!=null){
			 sb.append(" and courseId=? ");
		}
		return sb.toString();
	}
	public List<TeachTopic> getListForPage(String hql, int startRow, int endRow,Long courseID){
		Query query =getSession().createQuery(hql);
		if(courseID!=null){
		query.setLong(0, courseID);
		}
		query.setFirstResult(startRow);
		query.setMaxResults(endRow);
		return query.list();
	}
	public int getCountByHQL(String hql, Long courseID) {
		Query query =getSession().createQuery("select count(*) " + hql);
		if(courseID!=null){
			query.setLong(0, courseID);
		}
		int result = Integer.parseInt(String.valueOf(query.list().get(0)));
		return result;
		
	}
	public List<TeachTopic> findByCourse(Long courseid) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery("from TeachTopic t where t.courseId=?");
		query.setLong(0, courseid);
		return query.list();
	}


}
