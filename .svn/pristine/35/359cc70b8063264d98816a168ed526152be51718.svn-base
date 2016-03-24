package com.jxust.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.PreCourse;
import com.jxust.dao.PreCourseDao;
import com.jxust.service.PreCourseService;
@Service
@Transactional
public class PreCourseServiceImpl implements PreCourseService{
	@Resource
	private PreCourseDao preCourseDao;

	public void save(PreCourse pre) {
		// TODO Auto-generated method stub
		preCourseDao.save(pre);
	}

	public List<PreCourse> findAll(Long courseid) {
		// TODO Auto-generated method stub
		return preCourseDao.findAll(courseid);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		preCourseDao.delect(id);
	}

	public void batchDelete(Long long1) {
		// TODO Auto-generated method stub
		preCourseDao.batchDelete(long1);
	}

	public int getSize(Long long1) {
		// TODO Auto-generated method stub
		return preCourseDao.getSize(long1);
	}

	
}
