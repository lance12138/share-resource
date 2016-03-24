package com.jxust.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.Course;
import com.jxust.dao.CourseDao;
import com.jxust.service.CourseService;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
   @Resource
   private CourseDao courseDao;
	public List findAll() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}
	public void save(Course course) {
		courseDao.save(course);
	}
	public void delete(Long id) {
		courseDao.delect(id);
		
	}
	public Course findById(Long id) {
		// TODO Auto-generated method stub
		return courseDao.getById(id);
	}
	public void update(Course course) {
		courseDao.update(course);
		
	}
	public String getQueryHQL(Course course) {
		// TODO Auto-generated method stub
		return courseDao.getQueryHQL(course);
	}
	public int getCountByHQL(String hql) {
		// TODO Auto-generated method stub
		return courseDao.getCountByHQL(hql);
	}
	public List getListForPage(String hql, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		return courseDao.getListForPage(hql, startIndex, pageSize);
	}
	public Course findBytitle(String name) {
		// TODO Auto-generated method stub
		return courseDao.findBytitle(name);
	}
	public List findTopThree() {
		// TODO Auto-generated method stub
		return courseDao.findTopThree();
	}
	public List findLast() {
		// TODO Auto-generated method stub
		return courseDao.findLast();
	}
	public int findTopCourseId() {
		// TODO Auto-generated method stub
		return courseDao.findTopCourseId();
	}
	
}
