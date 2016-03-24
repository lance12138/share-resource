package com.jxust.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.Question;
import com.jxust.dao.QuestionDao;
import com.jxust.service.QuestionService;
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{
 @Resource
 private QuestionDao questionDao;

public List getBygrade(int grade,Long courseId) {
	// TODO Auto-generated method stub
	return questionDao.getBygrade(grade,courseId);
}


/*public List getListForPage(int startRow, int endRow, int Count1,
		int Count2,int Count3) {
	// TODO Auto-generated method stub
	return questionDao.getListForPage(startRow, endRow, Count1, Count2,Count3);
}
*/

public Question findById(Long id) {
	// TODO Auto-generated method stub
	return questionDao.getById(id);
}


public void save(Question question) {
	questionDao.save(question);
	
}


public String getHQL(Long courseID) {
	// TODO Auto-generated method stub
	return questionDao.getHQL(courseID);
}


public List getByHQL(String hql) {
	// TODO Auto-generated method stub
	return questionDao.getByHQL(hql);
}

public List getListForPageCommon(String hql, int startRow, int endRow) {
	// TODO Auto-generated method stub
	return questionDao.getListForPageCommon(hql, startRow, endRow);
}


public void delete(Long id) {
	questionDao.delect(id);
	
}


public void update(Question question) {
	questionDao.update(question);
	
}


public int getSize(Long courseid) {
	// TODO Auto-generated method stub
	return questionDao.getSize(courseid);
}


public void batchDelete(Long courseid) {
	// TODO Auto-generated method stub
	questionDao.batchDelete(courseid);
}
}
