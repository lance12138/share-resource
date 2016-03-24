package com.jxust.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.TeachMaterial;
import com.jxust.dao.TeachMaterialDao;
@Repository
public class TeachMaterialDaoImpl extends BaseDaoImpl<TeachMaterial> implements TeachMaterialDao{

	public String getHQL(Long courseid) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from TeachMaterial where 1=1 ");
		if(courseid!=null){
			sb.append(" and courseId="+courseid);
		}
		return sb.toString();
	}

	public List<TeachMaterial> findByCourse(Long courseid) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery(" from TeachMaterial where courseId=?");
		query.setLong(0, courseid);
		return query.list();
	}

}
