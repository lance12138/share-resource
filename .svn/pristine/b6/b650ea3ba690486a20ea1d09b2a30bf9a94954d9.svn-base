package com.jxust.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.Thesis;
import com.jxust.dao.ThesisDao;
import com.jxust.service.ThesisService;

@Service
@Transactional
public class ThesisServiceImpl implements ThesisService{

	@Resource
	private ThesisDao thesisDao;

	public void save(Thesis thesis) {
		// TODO Auto-generated method stub
		thesisDao.save(thesis);
	}

	public String getQueryHQL(Long courseID) {
		// TODO Auto-generated method stub
		return thesisDao.getQueryHQL(courseID);
	}

	public int getCountByHQL(String hql, Long courseID) {
		// TODO Auto-generated method stub
		return thesisDao.getCountByHQL(hql,courseID);
	}

	public List<Thesis> getListForPage(String hql, int startRow, int endRow,
			Long courseID) {
		// TODO Auto-generated method stub
		return thesisDao.getListForPage(hql, startRow, endRow,courseID);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		thesisDao.delect(id);
	}

	public List<Thesis> findByCourse(Long courseid) {
		// TODO Auto-generated method stub
		return thesisDao.findByCourse(courseid);
	}

	public int getSize(Long courseid) {
		// TODO Auto-generated method stub
		return thesisDao.getSize(courseid);
	}

	public void batchDelete(Long courseid) {
		// TODO Auto-generated method stub
		thesisDao.batchDelete(courseid);
	}
}
