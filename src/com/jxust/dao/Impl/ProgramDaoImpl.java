package com.jxust.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.Program;
import com.jxust.dao.ProgramDao;

@Repository
public class ProgramDaoImpl extends BaseDaoImpl<Program> implements ProgramDao{

	public int getCountByCourse(String hql,Long courseid) {
		// TODO Auto-generated method stub
		Query query = this.getSession().createQuery("select count(*) " + hql);
		if(courseid!=null){
			query.setLong(0, courseid);
		}
		int result = Integer.parseInt(String.valueOf(query.list().get(0)));
		return result;
	}

	public String getHQL(Long courseId) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from Program p where 1=1 ");
		if(courseId!=null){
			sb.append(" and p.courseId=?");
		}
		return sb.toString();
	}

	public List<Program> getListForPage(String hql, int startRow, int endRow,
			Long courseid) {
		// TODO Auto-generated method stub
		Query query = this.getSession().createQuery(hql);
		if(courseid!=null){
			query.setLong(0, courseid);
		}
		query.setFirstResult(startRow);
		query.setMaxResults(endRow);
		return query.list();

	}

}
