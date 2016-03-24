package com.jxust.dao;

import java.util.List;

import com.jxust.base.BaseDao;
import com.jxust.bean.Resource;

public interface ResourceDao extends BaseDao<Resource>{

	public List findBygrade(Integer grade);
	public void saves(Resource[] resource);
	public String getHQL(Resource resource,String downloadSelect);
	public int getCountByHQL(String hql,Integer type);
	public List<Resource> getListForPage(String hql, int startIndex, int pageSize,Integer type);
	public List<Resource> findByIdAndGrade(Long courseid, int grade);
	public int findSizeByGrade(int grade);
	public void batchByGrade(int grade,Long id);
	public int getSize(int type, Long id);
}
