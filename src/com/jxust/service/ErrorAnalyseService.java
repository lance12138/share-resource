package com.jxust.service;

import java.util.List;

import com.jxust.bean.ErrorAnalyse;

public interface ErrorAnalyseService {

	public void save(ErrorAnalyse analyse);

	public String getHQL(ErrorAnalyse analyse);

	public int getCountByHQL(String hql);

	public List<ErrorAnalyse> getListForPage(String hql, int startRow,
			int endRow);

	public void delete(Long errorId);

	public String getHqlByCourseId();

	public int getCountByHQL(String hql, Long courseId);

	public List<ErrorAnalyse> getListForPage(String hql, Long courseId,
			int startRow, int endRow);

}
