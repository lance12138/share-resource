package com.jxust.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.Knowledge;
import com.jxust.dao.KnowledgeDao;
@Repository
public class KnowledegeDaoImpl extends BaseDaoImpl<Knowledge> implements KnowledgeDao{

	public String getHQL(Knowledge knowledge,Long courseid,Long chapterId) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from Knowledge where 1=1 ");
		if(courseid!=null){
			sb.append(" and courseId="+courseid);
			System.out.println(sb.toString());
		}
		if(chapterId!=null){
			sb.append(" and chapterId="+chapterId);
		}
		return sb.toString();
	}
   
	public List<Knowledge> getListForPage(String hql, int startRow, int endRow,
			Long courseid) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery(hql);
		
		query.setFirstResult(startRow);
		query.setMaxResults(endRow);
		return query.list();
	}

}
