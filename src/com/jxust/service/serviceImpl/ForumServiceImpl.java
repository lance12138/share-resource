
package com.jxust.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.Forum;
import com.jxust.dao.ForumDao;
import com.jxust.service.ForumService;




@Service
@Transactional
public class ForumServiceImpl implements ForumService{

	@Resource
	private ForumDao forumDao;
	public void save(Forum forum) {
		// TODO Auto-generated method stub
		forumDao.save(forum);
	}
	public String getHQL(Forum forum) {
		// TODO Auto-generated method stub
		return forumDao.getHQL(forum);
	}
	public int getCountByHql(String hql) {
		// TODO Auto-generated method stub
		return forumDao.getCountByHQL(hql);
	}
	public List getListForPage(String hql, int startRow, int endRow) {
		// TODO Auto-generated method stub
		return forumDao.getListForPage(hql, startRow, endRow);
	}
	public Forum findById(Long forumId) {
		// TODO Auto-generated method stub
		return forumDao.getById(forumId);
	}
	public void update(Forum forum) {
		// TODO Auto-generated method stub
		forumDao.update(forum);
	}
	public void delete(Long id) {
		// TODO Auto-generated method stub
		forumDao.delect(id);
	}
	
	public int getSize() {
		// TODO Auto-generated method stub
		return forumDao.getSize();
	}
	public List<Forum> findAll() {
		// TODO Auto-generated method stub
		return forumDao.findAll();
	}

}
