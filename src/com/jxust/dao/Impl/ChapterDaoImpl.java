package com.jxust.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.Chapter;
import com.jxust.dao.ChapterDao;

@Repository
public class ChapterDaoImpl extends BaseDaoImpl<Chapter> implements ChapterDao {

	public Chapter findByTitle(String name) {
		try {
			String queryString = "from Course d where d.id.name=?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setString(0, name);
			return  (Chapter) queryObject.list().get(0);
		} catch (RuntimeException re) {

			throw re;
		}
	
		
	}

	public String getQueryHQL(Long grade) {
		StringBuffer sb = new StringBuffer("from Chapter  where 1=1  ");
		if(grade!=null){
			sb.append(" and courseId=?");
		}
		return sb.toString();
		
	}

	public List findBygrade(int grade) {
		
			String queryString = "from Chapter  where courseId=?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setInteger(0,grade);
			return   queryObject.list();
		
	}
	public int getCountByHQL(Long grade,String hql){
		Query query = getSession().createQuery("select count(*) " + hql);
		if(grade!=null){
		query.setLong(0,grade);
		}
		int result = Integer.parseInt(String.valueOf(query.list().get(0)));
		return result;
	}
	public List getListForPage(String hQL, int startRow, int endRow,Long grade){
		Query query = this.getSession().createQuery(hQL);
		if(grade!=null){
		 query.setLong(0, grade);
		}
		query.setFirstResult(startRow);
		query.setMaxResults(endRow);
		return query.list();
	}

	public List<Chapter> findBycourse(Long courseid) {
		String queryString = "from Chapter  where courseId=?";
		Query queryObject = getSession().createQuery(queryString);
		queryObject.setLong(0,courseid);
		return   queryObject.list();
	}

}
