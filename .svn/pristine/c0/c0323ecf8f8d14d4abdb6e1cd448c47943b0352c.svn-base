package com.jxust.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.Course;
import com.jxust.dao.CourseDao;
@Repository
public class CourseDaoImpl extends BaseDaoImpl<Course> implements CourseDao{

	public List findBygrade(Integer grade) {
		try {
			String queryString = "from Course d where d.id.grade=?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setInteger(0, grade);
			return queryObject.list();
		} catch (RuntimeException re) {

			throw re;
		}
	}

	public Course findBytitle(String name) {
		try {
			String queryString = "from Course d where d.id.name=?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setString(0, name);
			return  (Course) queryObject.list().get(0);
		} catch (RuntimeException re) {

			throw re;
		}
	}

	public List findTopThree() {
	   try{
		   String queryString="from Course";
		   Query queryObject=getSession().createQuery(queryString);
		   queryObject.setFirstResult(0);
		   queryObject.setMaxResults(3);
		   return queryObject.list();
	   }catch(RuntimeException e){
		   throw e;
	   }
	}

	public List findLast() {
		   try{
			   String queryString="from Course ";
			   Query queryObject=getSession().createQuery(queryString);
			   queryObject.setFirstResult(2);
			   return queryObject.list();
		   }catch(RuntimeException e){
			   throw e;
		   }
		}

	public int findTopCourseId() {
		try{
			String queryString=" from Course";
			Query query=getSession().createQuery("select max(courseId) "+queryString);
			System.out.println(Integer.parseInt(String.valueOf(query.list().get(0))));
			return Integer.parseInt(String.valueOf(query.list().get(0)));
		}catch(RuntimeException e){
			throw e;
		}
		
	}

	

	

}
