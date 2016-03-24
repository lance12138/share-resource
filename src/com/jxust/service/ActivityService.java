package com.jxust.service;

import java.util.List;

import com.jxust.bean.Activity;

public interface ActivityService {

	public List<Activity> findAll();

	public void save(Activity activity);

	public void delete(Long acId);

	public Activity findById(Long acId);

	public Activity previousPage(Activity ac);

	public Activity nextPage(Activity ac);
	
	public String getHQL(Activity activity);
	public int findByHQL(String hql);
	public List getListForPage(String hql, int startRow, int endRow);
}
