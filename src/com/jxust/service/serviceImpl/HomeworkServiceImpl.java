package com.jxust.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.Homework;
import com.jxust.dao.HomeworkDao;
import com.jxust.service.HomeworkService;
@Service
@Transactional
public class HomeworkServiceImpl implements HomeworkService{

	@Resource
	private HomeworkDao homeworkDao;

	public void save(Homework homework) {
		// TODO Auto-generated method stub
		homeworkDao.save(homework);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return homeworkDao.findAll();
	}

	public String getQueryHQL(Homework homework,String select) {
		// TODO Auto-generated method stub
		return homeworkDao.getQueryHQL(homework,select);
	}

	public int getCountByHQL(String hql) {
		// TODO Auto-generated method stub
		return homeworkDao.getCountByHQL(hql);
	}

	public List getListForPage(String hql, int startRow, int endRow) {
		// TODO Auto-generated method stub
		return homeworkDao.getListForPage(hql, startRow, endRow);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		homeworkDao.delect(id);
	}

	public int findAllSize() {
		// TODO Auto-generated method stub
		return homeworkDao.getSize();
	}

	public void batchDelete() {
		// TODO Auto-generated method stub
		homeworkDao.batchDelete();
	}

	/*public Homework getById(Long id) {
		return homeworkDao.getById(id);
		
	}*/
}
