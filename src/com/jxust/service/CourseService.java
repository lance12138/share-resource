package com.jxust.service;

import java.util.List;

import com.jxust.bean.Course;

public interface CourseService {
 
	List findAll();//查询所有
	public void save(Course course);//保存记录
	void delete(Long id);//删除记录
	public Course findById(Long id);//通过id查询
	void update(Course course);//执行更新
	public String getQueryHQL(Course course);//得到hql语句
	public int getCountByHQL(String hql);//通过hql语句查到记录数
	public List getListForPage(String hql, int startIndex, int pageSize);//分页
	public Course findBytitle(String name);//通过名字查询
	public List findTopThree();//查询课程前三条记录
	public List findLast();
	public int findTopCourseId();
}
