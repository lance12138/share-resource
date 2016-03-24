package com.jxust.dao;

import java.util.List;

import com.jxust.base.BaseDao;
import com.jxust.bean.Chapter;

public interface ChapterDao extends BaseDao<Chapter>{

  public Chapter findByTitle(String name);//通过标题查询

  public String getQueryHQL(Long grade);//测试用
  
  public List findBygrade(int grade);//通过等级查询
  public int getCountByHQL(Long grade,String hql);//获取记录数
  
  public List getListForPage(String hQL, int startRow, int endRow,Long grade);

public List<Chapter> findBycourse(Long courseid);


}
