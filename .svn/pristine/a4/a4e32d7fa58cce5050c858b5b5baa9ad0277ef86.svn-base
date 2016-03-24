package com.jxust.service;

import java.util.List;

import com.jxust.bean.Resource;

public interface ResourceService {
	public List findBygrade(Integer grade);

	public void save(Resource resource);
	public void saves(Resource[] resource);
	public int getCountByHQL(String hql,Integer type);

	public String getHQL(Resource resource,String downloadSelect);

	public List getListForPage(String hql, int startRow, int endRow,Integer type);

	public void delete(Long resourceId);

	public Resource findById(Long id);

	public List<Resource> finByIdAndGrade(Long courseid, int grade);

	
	public void batchDelete(int grade,Long id);

	public int findSizeByGrade(int type, Long id);
}
