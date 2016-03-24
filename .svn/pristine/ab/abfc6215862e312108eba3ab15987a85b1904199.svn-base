package com.jxust.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.Question;
import com.jxust.dao.QuestionDao;

@Repository
public class QuestionDaoImpl extends BaseDaoImpl<Question> implements QuestionDao{


	public List getBygrade(int grade,Long courseId){
		Query query = getSession().createQuery("from Question  where questionType=? and courseId=? order by rand()");
		query.setInteger(0,grade);
		query.setLong(1, courseId);
		query.setFirstResult(0);
		query.setMaxResults(5);
		
		return query.list();
	}
	/*public List getListForPage(int startRow, int endRow, int Count1,int Count2,int Count3) {
		 String hql=null;
		if(startRow<Count1){
		 hql="from Question d where d.id.questionType=1 order by rand()";
		
		}else if(Count1<=startRow&&startRow<=Count2+Count1){
			hql="from Question d where d.id.questionType=2 order by rand()";
			startRow=0;
		
		}else if(startRow>Count1+Count2){
			hql="from Question d where d.id.questionType=3 order by rand()";
			startRow=0;
		}
		Query query = getSession().createQuery(hql);
		query.setFirstResult(startRow);
		query.setMaxResults(endRow);
		return query.list();
		
	}*/
	public String getHQL(Long courseID) {
		StringBuffer sb=new StringBuffer("from Question  where 1=1 ");
		if(courseID!=null){
			 sb.append(" and courseId="+courseID);
		}
			 
		return sb.toString();
	}
	public List getByHQL(String hql) {
		Query query=getSession().createQuery(hql);
		return query.list();
	}
	public List getListForPageCommon(String hql, int startRow, int endRow) {
			Query query=getSession().createQuery(hql);
			query.setFirstResult(startRow);
			query.setMaxResults(endRow);
			return query.list();
	}
	

}
