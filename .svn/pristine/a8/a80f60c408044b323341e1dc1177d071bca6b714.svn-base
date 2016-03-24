package com.jxust.dao;

import java.util.List;

import com.jxust.base.BaseDao;
import com.jxust.bean.Program;

public interface ProgramDao extends BaseDao<Program>{

	int getCountByCourse(String hql,Long courseid);

	String getHQL(Long courseId);

	List<Program> getListForPage(String hql, int startRow, int endRow,
			Long courseid);


}
