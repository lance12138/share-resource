package com.jxust.service;

import java.util.List;

import com.jxust.bean.Program;

public interface ProgramService {

	public void save(Program program);

	public String getHQL(Long courseId);

	public int getCountByCourse(String hql,Long courseid);

	public List<Program> getListForPage(String hql, int startRow, int endRow,
			Long courseid);

	public int findSizeByCourse(Long courseid);

	public Program findById(Long proId);

	public void delete(Long proId);

}
