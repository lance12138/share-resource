package com.jxust.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.Resource;
import com.jxust.dao.ResourceDao;

@Repository
public class ResourceDaoImpl extends BaseDaoImpl<Resource> implements ResourceDao{
     //通过grade查找记录
	public List findBygrade(Integer grade) {
		try {
			String queryString = "from Resource d where d.id.grade=?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setInteger(0, grade);
			return queryObject.list();
		} catch (RuntimeException re) {

			throw re;
		}
	}
   //保存
	public void saves(Resource[] resource) {
		for (int i = 0; i < resource.length; i++) {
			getSession().save(resource[i]);
		}
		
	}
	//查询语句
	public String getHQL(Resource resource,String downloadSelect) {
		StringBuffer sb =new StringBuffer("from Resource  where grade=? and 1=1 ");
		 if(null!=resource.getTitle() && !"".equals(resource.getTitle()))
			 sb.append(" and "+downloadSelect+" like '%"+resource.getTitle()+"%' ");
		 
       return sb.toString(); 
	}
	
	public int getCountByHQL(String hql,Integer type){
		
		Query query = this.getSession().createQuery("select count(*) " + hql);
		query.setInteger(0, type);
		int result = Integer.parseInt(String.valueOf(query.list().get(0)));
		return result;
	}
	public List<Resource> getListForPage(String hql, int startIndex, int pageSize,Integer type) {
		// TODO Auto-generated method stub
		Query query =getSession().createQuery(hql);
		query.setInteger(0, type);
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		return query.list();
	}
	public List<Resource> findByIdAndGrade(Long courseid, int grade) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery("from Resource r where r.courseId=? and r.grade=?");
		query.setLong(0, courseid);
		query.setInteger(1, grade);
		return query.list();
	}
	public int findSizeByGrade(int grade) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery("select count(*) from Resource where grade=? ");
		 query.setInteger(0, grade);
		return Integer.parseInt(String.valueOf(query.list().get(0)));
	}
	public void batchByGrade(int grade,Long id) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery("delete from Resource where grade=? and courseId=?");
		query.setInteger(0, grade);
		query.setLong(1, id);
		query.executeUpdate();
	}
	public int getSize(int type, Long id) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery("select count(*) from Resource where grade=? and courseId=? ");
		 query.setInteger(0, type);
		 query.setLong(1, id);
		return Integer.parseInt(String.valueOf(query.list().get(0)));
	}
		
	

}
