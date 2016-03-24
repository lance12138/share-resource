package com.jxust.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.TeamHonor;
import com.jxust.dao.TeamHonorDao;
@Repository
public class TeamHonorDaoImpl extends BaseDaoImpl<TeamHonor> implements TeamHonorDao{

	public String getHQL(Long courseid) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from TeamHonor where 1=1 ");
		if(courseid!=null){
			sb.append(" and courseId="+courseid);
		}
		return sb.toString();
	}

	public List<TeamHonor> findByCourse(Long courseid) {
		Query query=getSession().createQuery(" from TeamHonor where courseId=?");
		query.setLong(0, courseid);
		return query.list();
	}

}
