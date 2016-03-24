package com.jxust.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.TeachTopic;
import com.jxust.dao.TeachTopicDao;
import com.jxust.service.TeachTopicService;

@Service
@Transactional
public class TeachTopicServiceImpl implements TeachTopicService{

	@Resource
	private TeachTopicDao teachTopicDao;

	public void save(TeachTopic teachTopic) {
		// TODO Auto-generated method stub
		teachTopicDao.save(teachTopic);
	}

	public String getQueryHQL(Long courseID) {
		// TODO Auto-generated method stub
		return teachTopicDao.getQueryHQL(courseID);
	}

	public int getCountByHQL(String hql, Long courseID) {
		// TODO Auto-generated method stub
		return teachTopicDao.getCountByHQL(hql,courseID);
	}

	public List<TeachTopic> getListForPage(String hql, int startRow, int endRow,Long courseID) {
		// TODO Auto-generated method stub
		return teachTopicDao.getListForPage(hql, startRow, endRow,courseID);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		teachTopicDao.delect(id);
	}

	public List<TeachTopic> findByCourse(Long courseid) {
		// TODO Auto-generated method stub
		return teachTopicDao.findByCourse(courseid);
	}

	public int getSize(Long courseid) {
		// TODO Auto-generated method stub
		return teachTopicDao.getSize(courseid);
	}

	public void batchDelete(Long courseid) {
		// TODO Auto-generated method stub
		teachTopicDao.batchDelete(courseid);
	}
}
