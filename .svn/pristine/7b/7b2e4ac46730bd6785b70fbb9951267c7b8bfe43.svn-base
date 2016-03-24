package com.jxust.service;

import java.util.List;

import com.jxust.bean.Question;

public interface QuestionService {
	
	public String getHQL(Long courseID);//获取hql语句
	 public List getBygrade(int grade,Long questionId);//获取记录数
	 public List getByHQL(String hql);
	// public List getListForPage(int startRow, int endRow,int Count1,int Count2,int Count3);
	 public List getListForPageCommon(String hql, int startRow, int endRow);
	public Question findById(Long id);
	public void save(Question question);
	public void delete(Long id);
	public void update(Question question);
	public int getSize(Long courseid);
	public void batchDelete(Long courseid);
}
