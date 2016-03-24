package com.jxust.dao;

import java.util.List;

import com.jxust.base.BaseDao;
import com.jxust.bean.Thesis;

public interface ThesisDao extends BaseDao<Thesis> {

	public String getQueryHQL(Long courseID);

	public int getCountByHQL(String hql, Long courseID);

	public List<Thesis> getListForPage(String hql, int startRow, int endRow,
			Long courseID);

	public List<Thesis> findByCourse(Long courseid);

}
