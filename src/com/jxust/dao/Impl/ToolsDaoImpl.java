package com.jxust.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.Tools;
import com.jxust.dao.ToolsDao;
@Repository
public class ToolsDaoImpl extends BaseDaoImpl<Tools> implements ToolsDao{

	public List findTeachter(int grade) {
		Query query=getSession().createQuery("from Tools t where t.grade=?");
		query.setInteger(0, grade);
		return query.list();
	}

	public List<Tools> findother() {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery("from Tools t where t.otherName is not null and t.otherName!=''");
		
		return query.list();
	}
/*
 * 
 * 查找uclass优课
 * */
	public Tools findByGrade(int i) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery("from Tools t where t.grade=0 and t.eduInstitute='uclass'");
		
		return (Tools) query.list().get(0);
	}

	public Tools findTeachChange(int i) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery(" from Tools t where t.grade=?");
		query.setInteger(0, i);
		List list=query.list();
		return (Tools) list.get(list.size()-1);
	}

}
