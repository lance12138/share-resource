package com.jxust.service;

import java.util.List;

import com.jxust.bean.Knowledge;

public interface KnowledgeService {

	void save(Knowledge knowledge);

	String getHQL(Knowledge knowledge,Long courseid,Long chapterId);

	int getCount(String hql);

	List<Knowledge> getListForPage(String hql, int startRow, int endRow,
			Long courseid);

	void delete(Long id);

	int getSize(Long courseid);

	void batchDelete(Long courseid);
}
