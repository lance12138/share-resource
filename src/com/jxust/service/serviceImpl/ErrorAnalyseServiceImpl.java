package com.jxust.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.ErrorAnalyse;
import com.jxust.dao.ErrorAnalyseDao;
import com.jxust.service.ErrorAnalyseService;
@Service
@Transactional
public class ErrorAnalyseServiceImpl implements ErrorAnalyseService{

	@Resource
	private ErrorAnalyseDao errorAnalyseDao;

	public void save(ErrorAnalyse analyse) {
		// TODO Auto-generated method stub
	errorAnalyseDao.save(analyse);	
	}

	public int getCountByHQL(String hql) {
		// TODO Auto-generated method stub
		return errorAnalyseDao.getCountByHQL(hql);
	}

	public String getHQL(ErrorAnalyse analyse) {
		// TODO Auto-generated method stub
		return errorAnalyseDao.getHQL(analyse);
	}

	public List<ErrorAnalyse> getListForPage(String hql, int startRow,
			int endRow) {
		// TODO Auto-generated method stub
		return errorAnalyseDao.getListForPage(hql, startRow, endRow);
	}

	public void delete(Long errorId) {
		// TODO Auto-generated method stub
	errorAnalyseDao.delect(errorId);	
	}

	public int getCountByHQL(String hql, Long courseId) {
		// TODO Auto-generated method stub
		return errorAnalyseDao.getCountByHQL(hql,courseId);
	}

	public String getHqlByCourseId() {
		// TODO Auto-generated method stub
		return errorAnalyseDao.getHqlByCourseId();
	}

	public List<ErrorAnalyse> getListForPage(String hql, Long courseId,
			int startRow, int endRow) {
		// TODO Auto-generated method stub
		return errorAnalyseDao.getListForPage(hql,courseId, startRow, endRow);
	}
}
