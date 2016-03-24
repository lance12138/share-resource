package com.jxust.dao;

import java.util.List;

import com.jxust.base.BaseDao;
import com.jxust.bean.Question;

public interface QuestionDao extends BaseDao<Question>{

	

	 public List getBygrade(int grade,Long courseId);//获取记录数
	 public String getHQL(Long courseID);
	 public List getByHQL(String hql);//通过hql查询数据
	// public List getListForPage(int startRow, int endRow,int Count1,int Count2,int Count3);
	 public List getListForPageCommon(String hql, int startRow, int endRow);
}
