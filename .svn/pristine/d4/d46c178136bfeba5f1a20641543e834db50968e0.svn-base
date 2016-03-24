package com.jxust.dao;

import java.util.List;

import com.jxust.base.BaseDao;
import com.jxust.bean.Knowledge;

public interface KnowledgeDao extends BaseDao<Knowledge>{

	String getHQL(Knowledge knowledge,Long courseid,Long chapterId);

	List<Knowledge> getListForPage(String hql, int startRow, int endRow,
			Long courseid);

}
