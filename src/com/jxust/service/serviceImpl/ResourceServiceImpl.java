package com.jxust.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.dao.ResourceDao;
import com.jxust.service.ResourceService;

@Service
@Transactional
public class ResourceServiceImpl implements ResourceService{

	@Resource
	private ResourceDao resourceDao;
	public List findBygrade(Integer grade) {
		// TODO Auto-generated method stub
		return resourceDao.findBygrade(grade);
	}
	public void save(com.jxust.bean.Resource resource) {
		resourceDao.save(resource);
	}
	public void saves(com.jxust.bean.Resource[] resource) {
		resourceDao.saves(resource);
		
	}
	public int getCountByHQL(String hql,Integer type) {
		// TODO Auto-generated method stub
		return resourceDao.getCountByHQL(hql,type);
	}
	public String getHQL(com.jxust.bean.Resource resource,String downloadSelect) {
		// TODO Auto-generated method stub
		return resourceDao.getHQL(resource,downloadSelect);
	}
	public List getListForPage(String hql, int startRow, int endRow,Integer type) {
		// TODO Auto-generated method stub
		return resourceDao.getListForPage(hql, startRow, endRow,type);
	}
	public void delete(Long resourceId) {
		resourceDao.delect(resourceId);
		
	}
	public com.jxust.bean.Resource findById(Long id) {
		// TODO Auto-generated method stub
		return resourceDao.getById(id);
	}
	public List<com.jxust.bean.Resource> finByIdAndGrade(Long courseid,
			int grade) {
		// TODO Auto-generated method stub
		return resourceDao.findByIdAndGrade(courseid,grade);
	}
	public int findSizeByGrade(int grade) {
		// TODO Auto-generated method stub
		return resourceDao.findSizeByGrade(grade);
	}
	public void batchDelete(int grade,Long id) {
		// TODO Auto-generated method stub
		resourceDao.batchByGrade(grade,id);
	}
	public int findSizeByGrade(int type, Long id) {
		// TODO Auto-generated method stub
		return resourceDao.getSize(type,id);
	}
	

}
