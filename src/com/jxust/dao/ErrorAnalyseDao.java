package com.jxust.dao;

import java.util.List;

import com.jxust.base.BaseDao;
import com.jxust.bean.ErrorAnalyse;

public interface ErrorAnalyseDao extends BaseDao<ErrorAnalyse>{

	public String getHQL(ErrorAnalyse analyse);

	public int getCountByHQL(String hql, Long courseId);

	public String getHqlByCourseId();

	public List<ErrorAnalyse> getListForPage(String hql, Long courseId,
			int startRow, int endRow);

}
