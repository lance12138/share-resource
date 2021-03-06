
package com.jxust.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.ErrorAnalyse;
import com.jxust.dao.ErrorAnalyseDao;
@Repository
public class ErrorAnalyseDaoImpl extends BaseDaoImpl<ErrorAnalyse> implements ErrorAnalyseDao{

	public String getHQL(ErrorAnalyse analyse) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer(" from ErrorAnalyse e where 1=1 ");
		if(analyse.getCourseId()!=null){
			sb.append(" and e.courseId="+analyse.getCourseId());
		}
		return sb.toString();
	}

	public String getHqlByCourseId() {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer(" from ErrorAnalyse e where e.courseId=?");
		return sb.toString();
	}

	public int getCountByHQL(String hql, Long courseId) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery(" select count(*) "+hql);
		query.setLong(0, courseId);
		return Integer.parseInt(String.valueOf(query.list().get(0)));
	}

	public List<ErrorAnalyse> getListForPage(String hql, Long courseId,
			int startRow, int endRow) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery(hql);
		query.setLong(0, courseId);
		query.setFirstResult(startRow);
		query.setMaxResults(endRow);
		return query.list();
	}

}
