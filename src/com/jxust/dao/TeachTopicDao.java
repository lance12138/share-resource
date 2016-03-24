package com.jxust.dao;

import java.util.List;

import com.jxust.base.BaseDao;
import com.jxust.bean.TeachTopic;

public interface TeachTopicDao extends BaseDao<TeachTopic>{

	public String getQueryHQL(Long courseID);
	public List<TeachTopic> getListForPage(String hql, int startRow, int endRow,Long courseID);
	public int getCountByHQL(String hql,Long courseID);
	public List<TeachTopic> findByCourse(Long courseid);
}
