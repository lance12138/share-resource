package com.jxust.service;

import java.util.List;

import com.jxust.bean.Chapter;

public interface ChapterService {
 public void save(Chapter chapter);
 public Chapter findByTitle(String name);

public String getQueryHQL(Long grade);//测试用
public int getCountByHQL(Long grade,String hql);//获取记录数

public List getListForPage(String hQL, int startRow, int endRow,Long grade);
public List getBygrade(int grade);
public void delete(Long courseid);
public List<Chapter> findBycourse(Long courseid);
}
