package com.jxust.service;

import java.util.List;

import com.jxust.bean.Thesis;

public interface ThesisService {

	public void save(Thesis thesis);

	public String getQueryHQL(Long courseID);

	public int getCountByHQL(String hql, Long courseID);

	public List<Thesis> getListForPage(String hql, int startRow, int endRow,
			Long courseID);

	public void delete(Long id);

	public List<Thesis> findByCourse(Long courseid);

	public int getSize(Long courseid);

	public void batchDelete(Long courseid);

}
