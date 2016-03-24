package com.jxust.dao.Impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.TeachTeam;
import com.jxust.dao.TeachTeamDao;

@Repository
public class TeachTeamDaoImpl extends BaseDaoImpl<TeachTeam> implements TeachTeamDao{

	public String getQueryHQL(TeachTeam teachTeam){
		StringBuffer sb=new StringBuffer("from Case where 1=1 ");
		if(teachTeam.getTeacherName()!=null && !teachTeam.getTeacherName().isEmpty()){
			 sb.append(" and teacherName like '%"+teachTeam.getTeacherName()+"%' ");
		}
		return sb.toString();
	}

	public TeachTeam findByManager(int i) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery("from TeachTeam t where t.manager=?");
		query.setInteger(0, i);
		return (TeachTeam) query.uniqueResult();
	}
	
}
