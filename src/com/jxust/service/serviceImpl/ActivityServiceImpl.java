package com.jxust.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.Activity;
import com.jxust.dao.ActivityDao;
import com.jxust.service.ActivityService;
@Service
@Transactional
public class ActivityServiceImpl implements ActivityService{
	@Resource
	private ActivityDao activityDao;

	public List<Activity> findAll() {
		// TODO Auto-generated method stub
		return activityDao.findAll();
	}

	public void save(Activity activity) {
		// TODO Auto-generated method stub
		activityDao.save(activity);
	}

	public void delete(Long acId) {
		// TODO Auto-generated method stub
		activityDao.delect(acId);
	}

	public Activity findById(Long acId) {
		// TODO Auto-generated method stub
		return activityDao.getById(acId);
	}

	public Activity previousPage(Activity ac) {
		// TODO Auto-generated method stub
		return activityDao.previousPage(ac);
	}

	public Activity nextPage(Activity ac) {
		// TODO Auto-generated method stub
		return activityDao.nextPage(ac);
	}

	public int findByHQL(String hql) {
		// TODO Auto-generated method stub
		return activityDao.getCountByHQL(hql);
	}

	public String getHQL(Activity activity) {
		// TODO Auto-generated method stub
		return activityDao.getQueryHQL(activity);
	}

	public List getListForPage(String hql, int startRow, int endRow) {
		// TODO Auto-generated method stub
		return activityDao.getListForPage(hql, startRow, endRow);
	}
}
