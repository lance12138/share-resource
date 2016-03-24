package com.jxust.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.PreCourse;
import com.jxust.dao.PreCourseDao;
@Repository
public class PreCourseDaoImpl extends BaseDaoImpl<PreCourse> implements PreCourseDao{

	public List<PreCourse> findAll(Long courseid) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery(" from PreCourse where chapterId=?");
		query.setLong(0, courseid);
		System.out.println(query.list().size());
		return query.list();
	}
	public int getSize(Long long1){
		Query query=getSession().createQuery(" from PreCourse where chapterId=?");
		query.setLong(0, long1);
		return query.list().size();
	}

	public void batchDelete(Long long1){
	Query query=getSession().createQuery("delete from PreCourse where chapterId=?");
	query.setLong(0, long1);
	query.executeUpdate();
	}
}
