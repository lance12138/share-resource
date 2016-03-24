package com.jxust.dao;

import java.util.List;

import com.jxust.base.BaseDao;
import com.jxust.bean.Course;

public interface CourseDao extends BaseDao<Course>{
	public List findBygrade(Integer grade);//通过等级查询
	public Course findBytitle(String name);//通过课程名查询
	public List findTopThree();//查询前三条记录
	public List findLast();//查询剩下记录
    public int findTopCourseId();//查询新增课程前最大courseId；
	
}
