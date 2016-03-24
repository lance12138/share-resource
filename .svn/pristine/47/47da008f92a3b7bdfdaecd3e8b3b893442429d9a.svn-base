package com.jxust.service;

import java.util.List;

import com.jxust.bean.TeachTopic;

public interface TeachTopicService {

	public void save(TeachTopic teachTopic);

	public String getQueryHQL(Long courseID);

	public int getCountByHQL(String hql, Long courseID);

	public List<TeachTopic> getListForPage(String hql, int startRow, int endRow,Long courseID);

	public void delete(Long id);

	public List<TeachTopic> findByCourse(Long courseid);

	public int getSize(Long courseid);

	public void batchDelete(Long courseid);

}
