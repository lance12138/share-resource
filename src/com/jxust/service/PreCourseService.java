package com.jxust.service;

import java.util.List;

import com.jxust.bean.PreCourse;

public interface PreCourseService {

	public void save(PreCourse pre);

	public List<PreCourse> findAll(Long courseid);

	public void delete(Long id);

	public int getSize(Long long1);

	public void batchDelete(Long long1);

}
